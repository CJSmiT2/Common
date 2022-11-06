package ua.org.smit.common.web.utilites.grid;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private final List<Object> objects = new ArrayList();

    public void add(Object item) {
        objects.add(item);
    }

    public List<Object> get() {
        return objects;
    }

}
