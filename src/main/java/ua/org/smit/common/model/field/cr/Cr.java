package ua.org.smit.common.model.field.cr;

import java.io.File;
import ua.org.smit.common.model.FolderInterface;
import ua.org.smit.common.model.LongWrap;
import ua.org.smit.common.filesystem.FolderCms;
import ua.org.smit.common.filesystem.TxtFile;

public class Cr extends LongWrap implements FolderInterface {
    // Cr aka Credits, Price, etc

    private static final String NAME_ON_DISC = "cr.txt";

    public Cr(long value) {
        super(value);
        valid(super.getValue());
    }

    public Cr(String s) throws NumberFormatException {
        super(s);
        valid(super.getValue());
    }

    public Cr() {
        super(0);
    }

    @Override
    public void initFromDisc(FolderCms folder) {
        TxtFile txt = new TxtFile(folder + File.separator + NAME_ON_DISC);
        super.setValue(Long.valueOf(txt.readFirstValue()));
    }

    @Override
    public void writeOnDisc(FolderCms folder) {
        TxtFile txtFile = new TxtFile(folder + File.separator + NAME_ON_DISC);
        txtFile.delete();
        txtFile.makeEmpty();
        txtFile.add(super.getValue());
    }

    private void valid(long value) {
        if (value < 0) {
            throw new RuntimeException("Cr cannot be lower zero!");
        }
    }

    public void add(Cr cr) {
        long newValue = super.getValue() + cr.getValue();
        super.setValue(newValue);
    }

    public void remove(Cr cr) {
        long newValue = super.getValue() - cr.getValue();
        valid(newValue);
        super.setValue(newValue);
    }

}
