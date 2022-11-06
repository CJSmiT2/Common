package ua.org.smit.common.model;

import ua.org.smit.common.filesystem.FolderCms;

public interface FolderInterface {

    void initFromDisc(FolderCms folder);

    void writeOnDisc(FolderCms folder);
}
