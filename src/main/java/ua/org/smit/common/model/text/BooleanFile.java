package ua.org.smit.common.model.text;

import java.io.File;
import ua.org.smit.common.filesystem.FileCms;
import ua.org.smit.common.filesystem.TxtFile;

public class BooleanFile extends TxtFile {

    public BooleanFile(String path) {
        super(path);
        initParamFile();
    }

    public BooleanFile(File file) {
        super(file.getAbsolutePath());
        initParamFile();
    }

    public BooleanFile(FileCms file) {
        super(file);
        initParamFile();
    }

    public boolean readValue() {
        return Boolean.valueOf(super.readFirstValue());
    }

    public void writeValue(boolean value) {
        super.reWrite(String.valueOf(value));
    }

    private void initParamFile() {
        if (!super.exists()) {
            super.makeEmpty();
            super.addToFile("false");
        }
    }
}
