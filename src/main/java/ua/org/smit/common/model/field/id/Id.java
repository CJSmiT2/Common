package ua.org.smit.common.model.field.id;

import java.io.File;
import ua.org.smit.common.model.FieldInterface;
import ua.org.smit.common.model.IntWrap;
import ua.org.smit.common.filesystem.FolderCms;
import ua.org.smit.common.filesystem.TxtFile;

public class Id extends IntWrap implements FieldInterface {

    public static final String COMMON_MODEL_ID = "common_model_id";

    public Id() {
        super(0);
    }

    public Id(int value) {
        super(value);
    }

    public Id(String value) {
        super(Integer.valueOf(value));
    }

    public boolean isAboveZero() {
        return super.getValue() > 0;
    }

    @Override
    public void writeValueOnDisk(FolderCms folder) {
        new TxtFile(folder + File.separator + COMMON_MODEL_ID + ".txt").reWrite(getValue());
    }

    @Override
    public void readValueFromDisk(FolderCms folder) {
        int id = new TxtFile(folder + File.separator + COMMON_MODEL_ID + ".txt").readFirstInteger();
        setValue(id);
    }

}
