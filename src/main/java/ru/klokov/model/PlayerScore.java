package ru.klokov.model;

public class PlayerScore {
    private GamePoints regularModePoints;
    private Integer tieBreakModePoints;
    private Integer games;
    private Integer sets;

    public PlayerScore() {
        regularModePoints = GamePoints.ZERO;
        tieBreakModePoints = 0;
        games = 0;
        sets = 0;
    }

    public GamePoints getRegularModePoints() {
        return regularModePoints;
    }

    public void setRegularModePoints(GamePoints regularModePoints) {
        this.regularModePoints = regularModePoints;
    }

    public Integer getTieBreakModePoints() {
        return tieBreakModePoints;
    }

    public void setTieBreakModePoints(Integer tieBreakModePoints) {
        this.tieBreakModePoints = tieBreakModePoints;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }
}
