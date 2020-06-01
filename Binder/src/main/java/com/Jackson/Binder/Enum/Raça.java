package com.Jackson.Binder.Enum;

public enum Raça {
    ANAO ("anao"),
    ElFO ("elfo"),
    HUMANO ("humano"),
    MAGO ("mago"),
    ORC ("orc");

    private String value;

    Raça (String value){
        this.value = value;
    }

    public static String getValue(String name) {
        return getValue ("name");
    }

    public static String getText() {
        return getText ();
    }

    public static String getValue() {
        return null;
    }
}
