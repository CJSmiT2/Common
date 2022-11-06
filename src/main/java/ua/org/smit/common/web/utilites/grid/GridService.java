package ua.org.smit.common.web.utilites.grid;

import java.util.List;

public class GridService {

    public final int rowSize;

    public GridService(int rowSize) {
        this.rowSize = rowSize;
    }

    public List<Row> makeRows(List<?> objects) {
        return new Grid(objects, rowSize).getRows();
    }
}
