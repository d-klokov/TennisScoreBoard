package service;


import org.junit.jupiter.api.*;
import ru.klokov.model.EPlayer;
import ru.klokov.model.MatchScore;
import ru.klokov.service.MatchScoreCalculationService;

import static org.junit.jupiter.api.Assertions.*;


public class MatchScoreCalculationServiceTest {
    private MatchScoreCalculationService matchScoreCalculationService;
    private MatchScore matchScore;
    EPlayer playerOne = EPlayer.PLAYER_ONE;
    EPlayer playerTwo = EPlayer.PLAYER_TWO;

//    @BeforeEach
//    public void scoreInit() {
//        matchScore = new MatchScore();
//        matchScoreCalculationService = new MatchScoreCalculationService();
//    }
//
//    @Test
//    @DisplayName("When player 1 wins point and points are 40-40 then player 1 get advantage")
//    public void advantagePoint() {
//        matchScore.setPoints(new int[]{40, 40});
//
//        matchScoreCalculationService.playerWinsPoint(playerOne, matchScore);
//
//        assertEquals(matchScore.getPlayerAds(playerOne), 1);
//        assertEquals(matchScore.getPlayerAds(playerTwo), 0);
//    }
//
//    @Test
//    @DisplayName("When player 1 wins point with advantage then player 1 wins game")
//    public void winPointWithAdvantage() {
//        matchScore.setPoints(new int[]{40, 40});
//        matchScore.setAds(new int[]{1, 0});
//
//        matchScoreCalculationService.playerWinsPoint(playerOne, matchScore);
//
//        assertEquals(matchScore.getPlayerGames(playerOne), 1);
//        assertEquals(matchScore.getPlayerGames(playerTwo), 0);
//    }
//
//    @Test
//    @DisplayName("When player 1 loose point with advantage then points are 40-40")
//    public void loosePointWithAdvantage() {
//        matchScore.setPoints(new int[]{40, 40});
//        matchScore.setAds(new int[]{1, 0});
//
//        matchScoreCalculationService.playerWinsPoint(playerTwo, matchScore);
//
//        assertEquals(matchScore.getPlayerPoints(playerOne), 40);
//        assertEquals(matchScore.getPlayerPoints(playerTwo), 40);
//        assertEquals(matchScore.getPlayerAds(playerOne), 0);
//        assertEquals(matchScore.getPlayerAds(playerTwo), 0);
//    }
//
//    @Test
//    @DisplayName("When player 1 wins point and points are 40-0 then player 1 wins game")
//    public void playerWinsGame() {
//        matchScore.setPoints(new int[]{40, 0});
//
//        matchScoreCalculationService.playerWinsPoint(playerOne, matchScore);
//
//        assertEquals(matchScore.getPlayerGames(playerOne), 1);
//        assertEquals(matchScore.getPlayerGames(playerTwo), 0);
//    }
//
//    @Test
//    @DisplayName("When player 1 wins game and games are 5-0 then player 1 wins set")
//    public void playerWinsSet() {
//        matchScore.setGames(new int[]{5, 0});
//
//        matchScoreCalculationService.playerWinsGame(playerOne, matchScore);
//
//        assertEquals(matchScore.getPlayerSets(playerOne), 1);
//        assertEquals(matchScore.getPlayerSets(playerTwo), 0);
//    }
//
//    @Test
//    @DisplayName("When player 1 wins game and games are 5-5 then match not finished")
//    public void matchNotFinished() {
//        matchScore.setGames(new int[]{5, 5});
//
//        matchScoreCalculationService.playerWinsGame(playerOne, matchScore);
//
//        assertFalse(matchScoreCalculationService.isMatchFinished(matchScore));
//    }
//
//    @Test
//    @DisplayName("When player 1 wins game and games are 6-5 then player 1 wins set")
//    public void playerWinsSetWhenGames6_5() {
//        matchScore.setGames(new int[]{6, 5});
//
//        matchScoreCalculationService.playerWinsGame(playerOne, matchScore);
//
//        assertEquals(matchScore.getPlayerSets(playerOne), 1);
//        assertEquals(matchScore.getPlayerSets(playerTwo), 0);
//    }
//
//    @Test
//    @DisplayName("When player 1 wins game and games are 5-6 then tie-break")
//    public void tieBreak() {
//        matchScore.setGames(new int[]{5, 6});
//
//        matchScoreCalculationService.playerWinsGame(playerOne, matchScore);
//
//        assertTrue(matchScoreCalculationService.isTieBreak(matchScore));
//    }
//
//    @Test
//    @DisplayName("When tie-break and player 1 wins point and points are 5-6 then points are 6-6")
//    public void clearTieBreakPoints() {
//        matchScoreCalculationService.setTieBreakMode(matchScore);
//        matchScore.setTieBreakPoints(new int[]{5, 6});
//
//        matchScoreCalculationService.playerWinsPoint(playerOne, matchScore);
//
//        assertEquals(matchScore.getPlayerTieBreakPoints(playerOne), 6);
//        assertEquals(matchScore.getPlayerTieBreakPoints(playerTwo), 6);
//    }
//
//    @Test
//    @DisplayName("When tie-break and player 1 wins point and points are 6-5 then player 1 wins set")
//    public void winTieBreak() {
//        matchScoreCalculationService.setTieBreakMode(matchScore);
//        matchScore.setTieBreakPoints(new int[]{6, 5});
//
//        matchScoreCalculationService.playerWinsPoint(playerOne, matchScore);
//
//        assertEquals(matchScore.getPlayerSets(playerOne), 1);
//        assertEquals(matchScore.getPlayerSets(playerTwo), 0);
//    }
//
//    @Test
//    @DisplayName("When tie-break and player 1 wins point and points are 7-6 then player 1 wins set")
//    public void winTieBreakPointWithAdvantage() {
//        matchScoreCalculationService.setTieBreakMode(matchScore);
//        matchScore.setTieBreakPoints(new int[]{7, 6});
//
//        matchScoreCalculationService.playerWinsPoint(playerOne, matchScore);
//
//        assertEquals(matchScore.getPlayerSets(playerOne), 1);
//        assertEquals(matchScore.getPlayerSets(playerTwo), 0);
//    }
//
//    @Test
//    @DisplayName("When player 1 wins set and sets are 1-0 then player 1 wins match")
//    public void winMatch() {
//        matchScore.setSets(new int[]{1, 0});
//
//        matchScoreCalculationService.playerWinsSet(playerOne, matchScore);
//
//        assertTrue(matchScoreCalculationService.isMatchFinished(matchScore));
//        assertEquals(matchScoreCalculationService.getWinner(matchScore), playerOne);
//    }
}
