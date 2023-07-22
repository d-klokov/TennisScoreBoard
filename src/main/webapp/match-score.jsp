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
                                <td class="points">${match.matchScore.sets[0]}</td>
                                <td class="points">${match.matchScore.games[0]}</td>
                                <c:choose>
                                    <c:when test="${match.matchScore.ads[0] == 0 && match.matchScore.ads[1] == 0}">
                                        <td class="points">${match.matchScore.points[0]}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${match.matchScore.ads[0] == 1 && match.matchScore.ads[1] == 0}">
                                                <td class="points">AD</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                            <tr>
                                <td>${match.playerTwo.name}</td>
                                <td class="points">${match.matchScore.sets[1]}</td>
                                <td class="points">${match.matchScore.games[1]}</td>
                                <c:choose>
                                    <c:when test="${match.matchScore.ads[0] == 0 && match.matchScore.ads[1] == 0}">
                                        <td class="points">${match.matchScore.points[1]}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${match.matchScore.ads[0] == 0 && match.matchScore.ads[1] == 1}">
                                                <td class="points">AD</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </tbody>
                    </table>
                    <c:if test="${isTieBreak}">
                        <div class="tieBreak">
                            <h3>Tie break!</h3>
                            <table>
                                <thead>
                                    <tr>
                                        <td class="col">${match.playerOne.name}</td>
                                        <td class="col">${match.playerTwo.name}</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="col, points">${match.matchScore.tieBreakPoints[0]}</td>
                                        <td class="col, points">${match.matchScore.tieBreakPoints[1]}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
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
