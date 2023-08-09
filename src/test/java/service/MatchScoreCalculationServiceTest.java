package service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.klokov.model.*;
import ru.klokov.service.MatchScoreCalculationService;

import static org.junit.jupiter.api.Assertions.*;


public class MatchScoreCalculationServiceTest {
    private final MatchScoreCalculationService matchScoreCalculationService;
    private MatchScore matchScore;

    public MatchScoreCalculationServiceTest() {
        this.matchScoreCalculationService = new MatchScoreCalculationService();
    }

    @BeforeEach
    public void scoreInit() {
        matchScore = new MatchScore();
    }

    @Test
    @DisplayName("When player 1 wins point and points are 40-40 then player 1 get advantage")
    public void advantagePoint() {
        for (int i = 0; i < 4; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
            matchScoreCalculationService.playerWonPoint(1, matchScore);
        }

        matchScoreCalculationService.playerWonPoint(0, matchScore);

        assertEquals(matchScore.getCurrentSet().getCurrentGame().getPlayerScore(0),
                RegularGamePlayerPoints.ADVANTAGE);
        assertEquals(matchScore.getCurrentSet().getCurrentGame().getOtherPlayerScore(0),
                RegularGamePlayerPoints.FORTY);
    }

    @Test
    @DisplayName("When player 1 wins point with advantage then player 1 wins game")
    public void winPointWithAdvantage() {
        for (int i = 0; i < 5; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
            if (i < 4) matchScoreCalculationService.playerWonPoint(1, matchScore);
        }

        matchScoreCalculationService.playerWonPoint(0, matchScore);

        assertEquals(matchScore.getCurrentSet().getPlayerScore(0), 1);
        assertEquals(matchScore.getCurrentSet().getOtherPlayerScore(0), 0);
    }

    @Test
    @DisplayName("When player 1 loose point with advantage then points are 40-40")
    public void loosePointWithAdvantage() {
        for (int i = 0; i < 5; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
            if (i < 4) matchScoreCalculationService.playerWonPoint(1, matchScore);
        }

        matchScoreCalculationService.playerWonPoint(1, matchScore);

        assertEquals(matchScore.getCurrentSet().getCurrentGame().getPlayerScore(0),
                RegularGamePlayerPoints.FORTY);
        assertEquals(matchScore.getCurrentSet().getCurrentGame().getOtherPlayerScore(0),
                RegularGamePlayerPoints.FORTY);
    }

    @Test
    @DisplayName("When player 1 wins point and points are 40-0 then player 1 wins game")
    public void playerWinsGame() {
        for (int i = 0; i < 3; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
        }

        matchScoreCalculationService.playerWonPoint(0, matchScore);

        assertEquals(matchScore.getCurrentSet().getPlayerScore(0), 1);
        assertEquals(matchScore.getCurrentSet().getOtherPlayerScore(0), 0);
    }

    @Test
    @DisplayName("When player 1 wins game and games are 5-0 then player 1 wins set")
    public void playerWinsSet() {
        matchScore.getCurrentSet().setPlayerScore(0, 5);
        matchScore.getCurrentSet().setOtherPlayerScore(0, 0);

        for (int i = 0; i < 4; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
        }

        assertEquals(matchScore.getPlayerScore(0), 1);
        assertEquals(matchScore.getOtherPlayerScore(0), 0);
    }

    @Test
    @DisplayName("When player 1 wins game and games are 5-5 then match not finished")
    public void matchNotFinished() {
        matchScore.getCurrentSet().setPlayerScore(0, 5);
        matchScore.getCurrentSet().setOtherPlayerScore(0, 5);

        for (int i = 0; i < 3; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
        }

        assertFalse(matchScoreCalculationService.playerWonPoint(0, matchScore));
    }

    @Test
    @DisplayName("When player 1 wins game and games are 6-5 then player 1 wins set")
    public void playerWinsSetWhenGames6_5() {
        matchScore.getCurrentSet().setPlayerScore(0, 6);
        matchScore.getCurrentSet().setOtherPlayerScore(0, 5);

        for (int i = 0; i < 4; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
        }

        assertEquals(matchScore.getPlayerScore(0), 1);
        assertEquals(matchScore.getOtherPlayerScore(0), 0);
    }

    @Test
    @DisplayName("When player 1 wins game and games are 5-6 then tie-break")
    public void tieBreak() {
        matchScore.getCurrentSet().setPlayerScore(0, 5);
        matchScore.getCurrentSet().setOtherPlayerScore(0, 6);

        for (int i = 0; i < 4; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
        }

        assertTrue(matchScore.getCurrentSet().isTieBreak());
    }

    @Test
    @DisplayName("When tie-break and player 1 wins point and points are 5-6 then points are 6-6")
    public void clearTieBreakPoints() {
        matchScore.getCurrentSet().setTieBreak();
        matchScore.getCurrentSet().setCurrentGame(new TieBreakGameScore());

        for (int i = 0; i < 6; i++) {
            if (i < 5) matchScoreCalculationService.playerWonPoint(0, matchScore);
            matchScoreCalculationService.playerWonPoint(1, matchScore);
        }

        matchScoreCalculationService.playerWonPoint(0, matchScore);

        assertEquals(matchScore.getCurrentSet().getCurrentGame().getPlayerScore(0), 6);
        assertEquals(matchScore.getCurrentSet().getCurrentGame().getPlayerScore(1), 6);
    }

    @Test
    @DisplayName("When tie-break and player 1 wins point and points are 6-5 then player 1 wins set")
    public void winTieBreak() {
        matchScore.getCurrentSet().setTieBreak();
        matchScore.getCurrentSet().setCurrentGame(new TieBreakGameScore());

        for (int i = 0; i < 6; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
            if (i < 5) matchScoreCalculationService.playerWonPoint(1, matchScore);
        }

        matchScoreCalculationService.playerWonPoint(0, matchScore);

        assertEquals(matchScore.getPlayerScore(0), 1);
        assertEquals(matchScore.getPlayerScore(1), 0);
    }

    @Test
    @DisplayName("When tie-break and player 1 wins point and points are 7-6 then player 1 wins set")
    public void winTieBreakPointWithAdvantage() {
        matchScore.getCurrentSet().setTieBreak();
        matchScore.getCurrentSet().setCurrentGame(new TieBreakGameScore());

        for (int i = 0; i < 7; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
            if (i < 6) matchScoreCalculationService.playerWonPoint(1, matchScore);
        }

        matchScoreCalculationService.playerWonPoint(0, matchScore);

        assertEquals(matchScore.getPlayerScore(0), 1);
        assertEquals(matchScore.getPlayerScore(1), 0);
    }

    @Test
    @DisplayName("When player 1 wins set and sets are 1-0 then player 1 wins match")
    public void winMatch() {
        matchScore.setPlayerScore(0, 1);
        matchScore.getCurrentSet().setPlayerScore(0, 5);
        matchScore.getCurrentSet().setPlayerScore(1, 0);

        for (int i = 0; i < 4; i++) {
            matchScoreCalculationService.playerWonPoint(0, matchScore);
        }

        assertTrue(matchScoreCalculationService.isMatchFinished());
        assertEquals(matchScore.getPlayerScore(0), 2);
        assertEquals(matchScore.getPlayerScore(1), 0);
    }
}
