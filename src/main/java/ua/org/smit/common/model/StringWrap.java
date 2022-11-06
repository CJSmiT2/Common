package ua.org.smit.common.model;

import java.util.Objects;

public class StringWrap {

    private String value;

    public StringWrap(String value) {
        this.value = value;
    }

    public StringWrap() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        final StringWrap other = (StringWrap) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StringWrap{" + "value=" + value + '}';
    }

}
