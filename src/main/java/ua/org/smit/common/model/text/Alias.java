package ua.org.smit.common.model.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ua.org.smit.common.model.StringWrap;

public class Alias extends StringWrap {

    public static final String ALIAS = "alias";
    private static final int MAX_LENGTH = 200;

    public Alias(String value) {
        super(value);
    }

    public Alias() {
    }

    public void createAlias(String value) {

        if (value == null) {
            throw new RuntimeException("Alias cannot be NULL!");
        } else if (value.isEmpty()) {
            throw new RuntimeException("Alias cannot be EMPTY!");
        } else if (value.length() > MAX_LENGTH) {
            throw new RuntimeException("Alias to LONG! " + value);
        }

        value = filterOnlyLettersAndnumbers(value);

        value = value.toLowerCase();
        value = value.trim();
        value = value.replaceAll("\\s+", "_");
//        value = value.replaceAll("-", "_");

        setValue(value);
    }

    private String filterOnlyLettersAndnumbers(String value) {
        String regex = "^[a-zA-Z0-9 _]+$";
        Pattern pattern = Pattern.compile(regex);

        StringBuilder stringBuilder = new StringBuilder();

        for (char singleChar : value.toCharArray()) {
            String singleCharString = String.valueOf(singleChar);
            Matcher matcher = pattern.matcher(singleCharString);
            if (matcher.find()) {
                stringBuilder.append(singleCharString);
            }
        }

        return stringBuilder.toString();
    }

}
