package ru.klokov.model;

public class MatchScore {
//    private int[] points;
//    private int[] games;
//    private int[] sets;
//    private int[] ads;
//    private int[] tieBreakPoints;
    private PlayerScore playerOneScore;
    private PlayerScore playerTwoScore;
    private boolean tieBreak;
    private boolean matchFinished;
    private EPlayer winner;

    public MatchScore() {
        this.playerOneScore = new PlayerScore();
        this.playerTwoScore = new PlayerScore();
        this.tieBreak = false;
        this.matchFinished = false;
        this.winner = null;
    }

    public GamePoints getPlayerRegularModePoints(EPlayer player) {
        PlayerScore playerScore = player.equals(EPlayer.PLAYER_ONE) ? playerOneScore : playerTwoScore;
        return playerScore.getRegularModePoints();
    }

    public void increasePlayerRegularModePoints(EPlayer player) {
        PlayerScore playerScore = player.equals(EPlayer.PLAYER_ONE) ? playerOneScore : playerTwoScore;
        switch (playerScore.getRegularModePoints()) {
            case ZERO:
                playerScore.setRegularModePoints(GamePoints.FIFTEEN);
                break;
            case FIFTEEN:
                playerScore.setRegularModePoints(GamePoints.THIRTY);
                break;
            case THIRTY:
                playerScore.setRegularModePoints(GamePoints.FORTY);
                break;
            case FORTY:
                playerScore.setRegularModePoints(GamePoints.AD);
                break;
        }
    }

    public boolean playerWinsPoint(EPlayer player) {
        if (!isTieBreak()) calculatePlayerPointsInRegularMode(player);
        else calculatePlayerPointsInTieBreakMode(player);

        return isMatchFinished();
    }

    public void playerWinsGame(EPlayer player) {

    }

    public void clearPoints() {
        playerOneScore.setRegularModePoints(GamePoints.ZERO);
        playerTwoScore.setRegularModePoints(GamePoints.ZERO);
    }

    public void calculatePlayerPointsInRegularMode(EPlayer player) {
        EPlayer otherPlayer = player.equals(EPlayer.PLAYER_ONE) ? EPlayer.PLAYER_TWO : EPlayer.PLAYER_ONE;

        if (playerPointsLessThen40(player)) increasePlayerRegularModePoints(player);
        else if (playerPointsEqualsTo40(player)) {
            if (playerPointsLessThen40(otherPlayer)) {
                playerWinsGame(player);
                clearPoints();
            } else if (playerPointsEqualsTo40(otherPlayer)) {
                increasePlayerRegularModePoints(player);
            }
        }
    }

    public void calculatePlayerPointsInTieBreakMode(EPlayer player) {

    }

    public boolean playerPointsLessThen40(EPlayer player) {
        PlayerScore playerScore = player.equals(EPlayer.PLAYER_ONE) ? playerOneScore : playerTwoScore;
        return playerScore.getRegularModePoints().equals(GamePoints.ZERO) ||
                playerScore.getRegularModePoints().equals(GamePoints.FIFTEEN) ||
                playerScore.getRegularModePoints().equals(GamePoints.THIRTY) ||
                playerScore.getRegularModePoints().equals(GamePoints.FORTY);
    }

    public boolean playerPointsEqualsTo40(EPlayer player) {
        PlayerScore playerScore = player.equals(EPlayer.PLAYER_ONE) ? playerOneScore : playerTwoScore;
        return playerScore.getRegularModePoints().equals(GamePoints.FORTY);
    }



//    public void clearPoints() {
//        this.points[0] = 0;
//        this.points[1] = 0;
//    }
    public int[] getPoints() { return points; }
    public void setPoints(int[] points) {
        this.points = points;
    }

    public int getPlayerGames(EPlayer player) { return games[player.ordinal()]; }
    public void increasePlayerGames(EPlayer player) { games[player.ordinal()]++; }
    public void clearGames() {
        games[0] = 0;
        games[1] = 0;
        clearPoints();
    }
    public int[] getGames() { return games; }
    public void setGames(int[] games) {
        this.games = games;
    }

    public int getPlayerSets(EPlayer player) { return sets[player.ordinal()]; }
    public void increasePlayerSets(EPlayer player) { sets[player.ordinal()]++; }
    public int[] getSets() {
        return sets;
    }
    public void setSets(int[] sets) {
        this.sets = sets;
    }

    public int getPlayerAds(EPlayer player) {
        return ads[player.ordinal()];
    }
    public void increasePlayerAds(EPlayer player) { this.ads[player.ordinal()]++; }
    public void clearAds() {
        this.ads[0] = 0;
        this.ads[1] = 0;
    }
    public int[] getAds() {
        return ads;
    }
    public void setAds(int[] ads) {
        this.ads = ads;
    }

    public int getPlayerTieBreakPoints(EPlayer player) {
        return tieBreakPoints[player.ordinal()];
    }
    public void increaseTieBreakPoints(EPlayer player) {
        tieBreakPoints[player.ordinal()]++;
    }

    public void clearTieBreakPoints() {
        tieBreakPoints[0] = 0;
        tieBreakPoints[1] = 0;
    }
    public int[] getTieBreakPoints() {
        return tieBreakPoints;
    }
    public void setTieBreakPoints(int[] tieBreakPoints) {
        this.tieBreakPoints = tieBreakPoints;
    }

    public boolean isTieBreak() { return this.tieBreak; }
    public void setTieBreak(boolean tieBreak) { this.tieBreak = tieBreak; }

    public boolean isMatchFinished() { return this.matchFinished; }
    public void setMatchFinished() { this.matchFinished = true; }

    public EPlayer getWinner() { return this.winner; }
    public void setWinner(EPlayer player) { this.winner = player; }
}
