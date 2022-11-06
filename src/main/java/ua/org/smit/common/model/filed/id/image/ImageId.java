package ua.org.smit.common.model.filed.id.image;

import ua.org.smit.common.model.field.id.Id;

public class ImageId extends Id {

    public static final String IMAGE_ID = "image_id";

    public ImageId(int value) {
        super(value);
    }

    public ImageId(String value) {
        super(Integer.valueOf(value));
    }

}
