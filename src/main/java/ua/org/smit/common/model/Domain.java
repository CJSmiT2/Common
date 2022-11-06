package ua.org.smit.common.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Domain {

    private final String value;

    public Domain(String value) {
        this.value = value.replaceAll("&", "&amp;");
//        valid(value);
    }

    private void valid(String value) {
        Pattern patt = Pattern.compile("^([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = patt.matcher(value);
        boolean result = matcher.matches();
        if (!result) {
            throw new RuntimeException("Is not a domain! '" + value + "'");
        }
    }

    public String getValue() {
        return value;
    }

}
