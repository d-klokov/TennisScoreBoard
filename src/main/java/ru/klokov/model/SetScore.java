package ru.klokov.model;

public class SetScore extends Score<Integer> {
    private GameScore<?> currentGame;

    private boolean tieBreak;

    public SetScore() {
        this.currentGame = new RegularGameScore();
        this.tieBreak = false;
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

        if (isTieBreak()) {
            System.out.println("RESET TIE BREAK");
            resetTieBreak();
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        }

        currentGame = new RegularGameScore();

        if (getPlayerScore(playerNumber) == 6) {
            if (getOtherPlayerScore(playerNumber) < 5) {
                return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
            } else if (getOtherPlayerScore(playerNumber) == 6) {
                currentGame = new TieBreakGameScore();
                setTieBreak();
            }
        } else if (getPlayerScore(playerNumber) == 7 && getOtherPlayerScore(playerNumber) == 5) {
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        }

        return State.ONGOING;
    }

    public GameScore<?> getCurrentGame() {
        return currentGame;
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
