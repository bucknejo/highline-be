package com.redbonesolutions.highline.domain.ui;

public class Option {

    private String value;
    private String text;
    private boolean selected;

    public Option() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Option [value=" + value + ", text=" + text + ", selected="
                + selected + "]";
    }

}
