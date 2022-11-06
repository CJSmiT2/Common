package ua.org.smit.common.model.field.id;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ua.org.smit.common.filesystem.FileCms;
import ua.org.smit.common.filesystem.TxtFile;

public class IdsFile extends TxtFile {

    public IdsFile(String pathname) {
        super(pathname);
    }

    public IdsFile(File file) {
        super(file.getAbsolutePath());
    }

    public IdsFile(FileCms file) {
        super(file);
    }

    public List<Id> read() {
        List<Id> ids = new ArrayList<>();
        for (String line : super.readByLines()) {
            if (line != null && !line.isEmpty()) {
                ids.add(new Id(line));
            }
        }
        return ids;
    }

    public void addId(Id id) {
        super.add(id.getValue());
    }

    public void reWrite(List<Id> ids) {
        super.makeEmpty();
        super.addAll(idsToNumbers(ids));
    }

    private List<Integer> idsToNumbers(List<Id> ids) {
        List<Integer> numbers = new ArrayList<>();
        for (Id id : ids) {
            numbers.add(id.getValue());
        }
        return numbers;
    }

}
