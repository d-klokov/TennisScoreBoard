package ru.klokov.model;

public class TieBreakGameScore extends GameScore<Integer> {
    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    State playerWonPoint(int playerNumber) {
        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);

        if (getPlayerScore(playerNumber) >= 7 && (getPlayerScore(playerNumber) - getOtherPlayerScore(playerNumber) >= 2)) {
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        }

        return State.ONGOING;
    }
}
