package ua.org.smit.common.model;

public abstract class LongWrap {

    private long value;

    public LongWrap(long value) {
        this.value = value;
    }

    public LongWrap(String value) {
        this.value = Long.valueOf(value);
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.value ^ (this.value >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LongWrap other = (LongWrap) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

}
