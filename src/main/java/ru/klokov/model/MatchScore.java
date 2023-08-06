package ru.klokov.model;

public class MatchScore extends Score<Integer> {
    private SetScore currentSet;

    public MatchScore() {
        this.currentSet = new SetScore();
    }

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    public State playerWonPoint(int playerNumber) {
        State setState = currentSet.playerWonPoint(playerNumber);

        if (setState == State.PLAYER_ONE_WON) return playerWonSet(0);
        else if (setState == State.PLAYER_TWO_WON) return playerWonSet(1);

        return State.ONGOING;
    }

    private State playerWonSet(int playerNumber) {
        currentSet = new SetScore();
        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);

        return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
    }

    public SetScore getCurrentSet() {
        return currentSet;
    }
}
