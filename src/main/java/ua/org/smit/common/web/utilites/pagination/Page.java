package ua.org.smit.common.web.utilites.pagination;

import java.util.ArrayList;
import java.util.List;
import ua.org.smit.common.web.utilites.grid.Row;

public class Page {

    private final int number;
    private final List<Row> rows = new ArrayList<>();

    public Page(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public List<Row> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "Page{" + "number=" + number + ", objects=" + rows + '}';
    }

}
