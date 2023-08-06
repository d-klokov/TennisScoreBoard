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
                    <table class="main-tbl">
                        <thead>
                            <tr>
                                <td class="player">PLAYER</td>
                                <td class="set">SETS</td>
                                <td class="game">GAMES</td>
                                <td class="point">POINTS</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${match.playerOne.name}</td>
                                <td class="points">${match.matchScore.getPlayerScore(0)}</td>
                                <td class="points">${match.matchScore.currentSet.getPlayerScore(0)}</td>
                                <c:if test="${isTieBreak}">
                                    <td class="points">${match.matchScore.currentSet.currentGame.getPlayerScore(0)}</td>
                                </c:if>
                                <c:if test="${!isTieBreak}">
                                    <td class="points">${match.matchScore.currentSet.currentGame.getPlayerScore(0).getValue()}</td>
                                </c:if>
                            </tr>
                            <tr>
                                <td>${match.playerTwo.name}</td>
                                <td class="points">${match.matchScore.getPlayerScore(1)}</td>
                                <td class="points">${match.matchScore.currentSet.getPlayerScore(1)}</td>
                                <c:if test="${isTieBreak}">
                                    <td class="points">${match.matchScore.currentSet.currentGame.getPlayerScore(1)}</td>
                                </c:if>
                                <c:if test="${!isTieBreak}">
                                    <td class="points">${match.matchScore.currentSet.currentGame.getPlayerScore(1).getValue()}</td>
                                </c:if>
                            </tr>
                        </tbody>
                    </table>
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
