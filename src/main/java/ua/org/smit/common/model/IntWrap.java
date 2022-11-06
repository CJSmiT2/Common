package ua.org.smit.common.model;

public abstract class IntWrap {

    private int value;

    public IntWrap(int value) {
        this.value = value;
    }

    public IntWrap(String value) {
        this.value = Integer.valueOf(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntWrap{" + "value=" + value + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.value;
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
        final IntWrap other = (IntWrap) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

}
