package ru.klokov.model;

public class SetScore extends Score<Integer> {
    private GameScore<?> currentGame;

    public SetScore() {
        this.currentGame = new RegularGameScore();
    }

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    State playerWonPoint(int playerNumber) {
        State gameState = currentGame.playerWonPoint(playerNumber);

        if (gameState == State.PLAYER_ONE_WON) return playerWonGame(0);
        else if (gameState == State.PLAYER_TWO_WON) return playerWonGame(1);

        return State.ONGOING;
    }

    private State playerWonGame(int playerNumber) {
        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
        this.currentGame = new RegularGameScore();

        if (getPlayerScore(playerNumber) == 6) {
            if (getOtherPlayerScore(playerNumber) < 5)
        }
    }
}
