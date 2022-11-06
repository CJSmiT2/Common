package ua.org.smit.common.cropresizeimage;

class Resolution {

    private final int winth;
    private final int height;

    public Resolution(int winth, int height) {
        this.winth = winth;
        this.height = height;
    }

    public int getWidth() {
        return winth;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Resolution{" + "winth=" + winth + ", height=" + height + '}';
    }

}
