package ua.org.smit.common.model.text;

import ua.org.smit.common.model.StringWrap;

public class Text extends StringWrap {

    public static String TEXT = "text";

    public Text(String value) {
        super(value);
        super.setValue(removeParenthesis(value));
    }

    public boolean isEmpty() {
        return super.getValue() == null || super.getValue().isEmpty();
    }

    private String removeParenthesis(String value) {
        if (value == null) {
            throw new RuntimeException("Value cant be NULL");
        }
        value = value.replaceAll("<", "");
        value = value.replaceAll(">", "");
        value = value.replaceAll("script", "");
        value = value.replaceAll("javascript", "");
        return value;
    }

}
