package ua.org.smit.common.web.utilites.pagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ua.org.smit.common.web.utilites.grid.GridService;
import ua.org.smit.common.web.utilites.grid.Row;

public class Pagination {

    public static final int OBJECTS_ON_SINGLE_PAGE_LIMIT = 5;

    private final List<Page> pages = new ArrayList<>();
    private final int currentPageNumber;

    public Pagination(int columnSize, List<String> aliases, int currentPageNumber) {
        List<Row> rows = new GridService(columnSize).makeRows(aliases);
        if (currentPageNumber == 0) {
            currentPageNumber = 1;
        }
        this.currentPageNumber = currentPageNumber;

        int index = 0;
        int pagesSize = (int) Math.ceil((double) rows.size() / (double) OBJECTS_ON_SINGLE_PAGE_LIMIT);
        for (int pageIndex = 1; pageIndex <= pagesSize; pageIndex++) {
            Page page = new Page(pageIndex);
            for (int i = 0; i < OBJECTS_ON_SINGLE_PAGE_LIMIT; i++) {
                if (index < rows.size()) {
                    page.getRows().add(rows.get(index));
                    index++;
                } else {
                    break;
                }
            }
            pages.add(page);
        }
    }

    Page getCurrentPage() {
        for (Page page : pages) {
            if (page.getNumber() == currentPageNumber) {
                return page;
            }
        }
        throw new RuntimeException("Cant find page by number='" + currentPageNumber + "'");
    }

    public List<String> getSelectedAliases() {
        List<String> aliases = new ArrayList<>();

        getCurrentPage().getRows().forEach((row) -> {
            for (int index = 0; index < row.get().size(); index++) {
                aliases.add(String.class.cast(row.get().get(index)));
            }
        });

        return aliases;
    }

    public List<Number> getPreviousPages() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 1; i < currentPageNumber; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public List<Number> getNextPages() {
        List<Number> numbers = new ArrayList<>();
        for (int i = currentPageNumber + 1; i <= pages.size(); i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public List<Number> getPreviousPagesByLimit(int limit) {
        List<Number> selected = new ArrayList<>();
        List<Number> previousPages = getPreviousPages();
        Collections.reverse(previousPages);

        for (Number page : previousPages) {
            selected.add(page);
            limit--;
            if (limit < 0) {
                break;
            }
        }

        Collections.reverse(selected);
        return selected;
    }

    public List<Number> getNextPagesByLimit(int limit) {
        List<Number> selected = new ArrayList<>();
        List<Number> nextPages = getNextPages();

        for (Number page : nextPages) {
            selected.add(page);
            limit--;
            if (limit < 0) {
                break;
            }
        }

        return selected;
    }

    public Number getLastPage() {
        List<Number> pages = getNextPages();
        if (pages.isEmpty()) {
            return 1;
        } else {
            return pages.get(pages.size() - 1);
        }
    }

    public Number getFirsPage() {
        return 1;
    }

}
