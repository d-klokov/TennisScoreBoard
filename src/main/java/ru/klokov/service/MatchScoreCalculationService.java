package ru.klokov.service;

import ru.klokov.model.MatchScore;

public class MatchScoreCalculationService {
    private Integer winnerNumber;
    private boolean matchFinished;
    private static final int NUMBER_OF_SETS_TO_WIN_MATCH = 2;

    public MatchScoreCalculationService() {
        this.winnerNumber = null;
        this.matchFinished = false;
    }

    public boolean playerWonPoint(int playerNumber, MatchScore matchScore) {
        matchScore.playerWonPoint(playerNumber);
        matchFinished = matchScore.getPlayerScore(playerNumber) == NUMBER_OF_SETS_TO_WIN_MATCH;

        if (matchFinished) winnerNumber = playerNumber;

        return matchFinished;
    }

    public Integer getWinnerNumber() {
        return winnerNumber;
    }

    public boolean isMatchFinished() {
        return matchFinished;
    }
}
