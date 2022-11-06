package ua.org.smit.common.model.simple.user;

import ua.org.smit.common.model.text.Text;

public class NickName extends Text {

    private static final int LENGTH_LIMIT = 20;

    public NickName(String value) {
        super(value);
        valid(value);
    }

    private void valid(String value) {
        if (value.length() > LENGTH_LIMIT) {
            throw new RuntimeException("NickName to long! Value = '" + value + "'");
        }
    }

}
