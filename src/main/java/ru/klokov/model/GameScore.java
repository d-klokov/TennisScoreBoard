package ru.klokov.model;

public abstract class GameScore<T> extends Score<T> {
    private boolean tieBreak;

    public GameScore() {
        this.tieBreak = false;
    }

    public boolean isTieBreak() {
        return tieBreak;
    }

    public void setTieBreak() {
        tieBreak = true;
    }

    public void resetTieBreak() {
        tieBreak = false;
    }
}
