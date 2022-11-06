package ua.org.smit.common.web.utilites.grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    public static final int DEFAULT_COLUMS_SIZE = 12;

    private final List<Row> rows = new ArrayList<>();

    public Grid(List<?> objects, int rowsSize) {
        if (rowsSize <= 0 || DEFAULT_COLUMS_SIZE > 12) {
            throw new IllegalArgumentException("Colums size must be > 0 and < 13!");
        }

        int objectIndex = 0;
        for (Object object : objects) {
            Row row = new Row();
            for (int i = 0; i < rowsSize; i++) {
                if (objectIndex < objects.size()) {
                    Object selectedObject = objects.get(objectIndex);
                    row.add(selectedObject);
                    objectIndex++;
                } else {
                    break;
                }

            }
            if (!row.get().isEmpty()) {
                rows.add(row);
            }
        }
    }

    public List<Row> getRows() {
        return rows;
    }

}
