package ru.klokov.model;

public enum RegularGamePlayerPoints {
    ZERO("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), ADVANTAGE("AD");

    private String value;

    RegularGamePlayerPoints(String value) {
        this.value = value;
    }

    public RegularGamePlayerPoints next() {
        if (this == ADVANTAGE) throw new IllegalStateException("Can't call next() on ADVANTAGE");
        else return RegularGamePlayerPoints.values()[this.ordinal() + 1];
    }

    public String getValue() {
        return value;
    }
}
