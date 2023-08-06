package ru.klokov.model;

public class RegularGameScore extends GameScore<RegularGamePlayerPoints> {

    @Override
    protected RegularGamePlayerPoints getZeroScore() {
        return RegularGamePlayerPoints.ZERO;
    }

    @Override
    State playerWonPoint(int playerNumber) {
        RegularGamePlayerPoints playerScore = getPlayerScore(playerNumber);
        if (playerScore.ordinal() < RegularGamePlayerPoints.FORTY.ordinal()) {
            setPlayerScore(playerNumber, playerScore.next());
        } else if (playerScore == RegularGamePlayerPoints.FORTY) {
            RegularGamePlayerPoints otherPlayerPoints = getOtherPlayerScore(playerNumber);
            if (otherPlayerPoints.ordinal() < RegularGamePlayerPoints.FORTY.ordinal()) {
                return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
            } else if (otherPlayerPoints == RegularGamePlayerPoints.FORTY) {
                setPlayerScore(playerNumber, RegularGamePlayerPoints.ADVANTAGE);
            } else {
                setOtherPlayerScore(playerNumber, RegularGamePlayerPoints.FORTY);
            }
        } else if (playerScore == RegularGamePlayerPoints.ADVANTAGE) {
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        } else {
            throw new IllegalStateException("Can't call playerWinsPoint() on ADVANTAGE");
        }

        return State.ONGOING;
    }
}
