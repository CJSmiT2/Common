package ua.org.smit.common.cropresizeimage;

class ImageSizeConsider {

    private final Resolution imgSize;

    ImageSizeConsider(int currentWidth, int currentHeight, int maxWidth, int maxHeight) {
        int newWidth;
        int newHeight;

        double aspectRatio = (double) currentWidth / (double) currentHeight;

        if (currentWidth > currentHeight) {
            newWidth = maxWidth;
            newHeight = (int) (maxWidth / aspectRatio);
        } else {
            newHeight = maxHeight;
            newWidth = (int) (maxHeight * aspectRatio);
        }

        imgSize = new Resolution(newWidth, newHeight);
    }

    Resolution getImgSize() {
        return imgSize;
    }

}
