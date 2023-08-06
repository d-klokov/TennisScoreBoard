package ru.klokov.model;

public class TieBreakGameScore extends GameScore<Integer> {
    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    State playerWonPoint(int playerNumber) {
        if (getPlayerScore(playerNumber) < 6) setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
        else if (getPlayerScore(playerNumber) == 6) {
            if (getOtherPlayerScore(playerNumber) < 6) {
                resetTieBreak();
                return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
            } else setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
        } else {
            setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
            if (getPlayerScore(playerNumber) - getOtherPlayerScore(playerNumber) == 2) {
                resetTieBreak();
                return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
            }
        }

        return State.ONGOING;
    }
}
