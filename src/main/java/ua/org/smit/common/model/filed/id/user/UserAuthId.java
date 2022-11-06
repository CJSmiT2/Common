package ua.org.smit.common.model.filed.id.user;

import java.io.File;
import ua.org.smit.common.model.FolderInterface;
import ua.org.smit.common.model.field.id.Id;
import ua.org.smit.common.filesystem.FolderCms;
import ua.org.smit.common.filesystem.TxtFile;

public class UserAuthId extends Id implements FolderInterface {

    public static final String USER_AUTH_ID = "user_auth_id";
    private static final String NAME_ON_DISC = USER_AUTH_ID + ".txt";

    public UserAuthId(int value) {
        super(value);
    }

    public UserAuthId(Id value) {
        super(value.getValue());
    }

    public UserAuthId(String value) {
        super(value);
    }

    public UserAuthId() {
        super(0);
    }

    public UserAuthId(TxtFile txt) {
        super(txt.readFirstInteger());
    }

    @Override
    public void initFromDisc(FolderCms folder) {
        TxtFile txt = new TxtFile(folder + File.separator + NAME_ON_DISC);
        super.setValue(txt.readFirstInteger());
    }

    @Override
    public void writeOnDisc(FolderCms folder) {
        new TxtFile(folder + File.separator + NAME_ON_DISC).add(super.getValue());
    }

}
