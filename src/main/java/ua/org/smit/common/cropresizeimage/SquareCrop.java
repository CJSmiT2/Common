package ua.org.smit.common.cropresizeimage;

class SquareCrop {

    private final int indent; // indent from top side of image in percent
    private final int squareSideSize;

    SquareCrop(int indent, int squareSideSize) {
        this.indent = indent;
        this.squareSideSize = squareSideSize;
    }

    SquareCropProperties getParams(int realWidth, int realHeight) {
        SquareCropProperties properties = new SquareCropProperties();
        if (isImgVertical(realWidth, realHeight)) {
            makeVerticalParams(properties, realWidth, realHeight);
        } else {
            makeHorizontalParams(properties, realWidth, realHeight);
        }

        return properties;
    }

    private boolean isImgVertical(int realWidth, int realHeight) {
        return realHeight > realWidth;
    }

    private void makeVerticalParams(SquareCropProperties params, int realWidth, int realHeight) {
        params.newWidth = realWidth;
        params.newHeight = realWidth;
        int dif = realWidth - this.squareSideSize;
        int offset = dif / this.indent;
        params.heightCropPoint = offset * (-1);
    }

    private void makeHorizontalParams(SquareCropProperties params, int realWidth, int realHeight) {
        params.newHeight = realHeight;
        params.newWidth = realHeight;
        params.heightCropPoint = 0;
        params.widthCropPoint = ((realWidth - realHeight) / 2) * (-1);
    }
}
