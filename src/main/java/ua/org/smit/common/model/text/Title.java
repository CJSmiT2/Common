package ua.org.smit.common.model.text;

public class Title extends Text {

    public static final String TITLE = "title";

    public Title(String value) {
        super(value);
    }

    public Alias createAlias() {
        Alias alias = new Alias();
        alias.createAlias(super.getValue());
        return alias;
    }

}
