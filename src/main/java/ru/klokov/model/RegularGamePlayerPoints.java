package ru.klokov.model;

public enum RegularGamePlayerPoints {
    ZERO, FIFTEEN, THIRTY, FORTY, ADVANTAGE;

    public RegularGamePlayerPoints next() {
        if (this == ADVANTAGE) throw new IllegalStateException("Can't call next() on ADVANTAGE");
        else return RegularGamePlayerPoints.values()[this.ordinal() + 1];
    }
}
