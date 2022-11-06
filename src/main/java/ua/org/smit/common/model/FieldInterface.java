package ua.org.smit.common.model;

import ua.org.smit.common.filesystem.FolderCms;

public interface FieldInterface {

    void writeValueOnDisk(FolderCms folder);

    void readValueFromDisk(FolderCms folder);
}
