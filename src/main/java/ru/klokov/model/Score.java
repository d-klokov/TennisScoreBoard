package ru.klokov.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Score<T> {
    private final List<T> scores = new ArrayList<>();

    protected abstract T getZeroScore();

    public Score() {
        scores.add(getZeroScore());
        scores.add(getZeroScore());
    }

    public T getPlayerScore(int playerNumber) {
        return scores.get(playerNumber);
    }

    public T getOtherPlayerScore(int playerNumber) {
        return scores.get(playerNumber == 0 ? 1 : 0);
    }

    public void setPlayerScore(int playerNumber, T score) {
        scores.set(playerNumber, score);
    }

    public void setOtherPlayerScore(int playerNumber, T score) {
        scores.set(playerNumber == 0 ? 1 : 0, score);
    }

    abstract State playerWonPoint(int playerNumber);
}
