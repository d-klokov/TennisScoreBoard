<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@ include file="/css/style.css"%></style>
    <style><%@ include file="/css/match-score.css"%></style>
    <title>Match score</title>
</head>
<body>
    <section>
        <header>
            <nav>
                <div class="nav-list">
                    <a class="nav-link" href="index"><div>HOME</div></a>
                    <a class="nav-link" href="new-match"><div>NEW</div></a>
                    <a class="nav-link" href="matches"><div>MATCHES</div></a>
                </div>
            </nav>
        </header>
    </section>
    <section>
        <article>
            <div class="content">
                <h1>Match score</h1>
                <div class="content-body">
                    <div class="score-board">
                        <div class="headers">
                            <div class="players">PLAYERS</div>
                            <div class="sets">SETS</div>
                            <div class="games">GAMES</div>
                            <div class="points">POINTS</div>
                        </div>
                        <div class="playerOneScore">
                            <div class="playerName">${match.playerOne.name}</div>
                            <div class="value">${match.matchScore.getPlayerScore(0)}</div>
                            <div class="value">${match.matchScore.currentSet.getPlayerScore(0)}</div>
                            <c:if test="${isTieBreak}">
                                <div class="value">${match.matchScore.currentSet.currentGame.getPlayerScore(0)}</div>
                            </c:if>
                            <c:if test="${!isTieBreak}">
                                <div class="value">${match.matchScore.currentSet.currentGame.getPlayerScore(0).getValue()}</div>
                            </c:if>
                        </div>
                        <div class="playerTwoScore">
                            <div class="playerName">${match.playerTwo.name}</div>
                            <div class="value">${match.matchScore.getPlayerScore(1)}</div>
                            <div class="value">${match.matchScore.currentSet.getPlayerScore(1)}</div>
                            <c:if test="${isTieBreak}">
                                <div class="value">${match.matchScore.currentSet.currentGame.getPlayerScore(1)}</div>
                            </c:if>
                            <c:if test="${!isTieBreak}">
                                <div class="value">${match.matchScore.currentSet.currentGame.getPlayerScore(1).getValue()}</div>
                            </c:if>
                        </div>
                    </div>
                    <div class="buttons">
                        <form action="match-score?uuid=${uuid}" method="POST">
                            <button class="button" name="playerNumberParameter" value="0">Player 1 wins point!</button>
                            <button class="button" name="playerNumberParameter" value="1">Player 2 wins point!</button>
                        </form>
                    </div>
                </div>
            </div>
        </article>
    </section>
</body>
</html>
