<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@ include file="/css/finished-matches.css"%></style>
    <title>Finished matches</title>
</head>
<body>
    <section>
        <header>
            <nav>
                <ul class="nav-list">
                    <li><a class="nav-link" href="index">HOME</a></li>
                    <li><a class="nav-link" href="new-match">NEW</a></li>
                    <li><a class="nav-link" href="matches">MATCHES</a></li>
                </ul>
            </nav>
        </header>
    </section>
    <section>
        <article>
            <div class="content">
                <h1>Finished matches</h1>
                <div class="content-body">
                    <div class="filter">
                        <form action="matches">
                            <label class="nameLabel" for="filter_by_player_name">Name:</label>
                            <input id="playerNameInput" class="playerName" type="text" value="${playerName}" name="filter_by_player_name">
                            <input type="submit" value="Search" class="filterButton" />
                            <a href="matches" class="clearLink"><input type="button" value="Clear" class="clearButton" /></a>
                        </form>
                        <c:if test="${error != null}">
                            <div class="error">${error}</div>
                        </c:if>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <td class="matchId">ID</td>
                                <td class="playerOneName">Player 1</td>
                                <td class="playerTwoName">Player 2</td>
                                <td class="winnerName">Winner</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${matches}" var="match">
                                <tr>
                                    <td>${match.id}</td>
                                    <td>${match.playerOne.name}</td>
                                    <td>${match.playerTwo.name}</td>
                                    <td>${match.winner.name}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <c:choose>
                            <c:when test="${empty playerName}">
                                <c:set var="filter" value="" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="filter" value="&filter_by_player_name=${playerName}" />
                            </c:otherwise>
                        </c:choose>
                        <c:if test="${totalPages > 1}">
                            <c:choose>
                                <c:when test="${pageNumber == 1}">
                                    <div class="page"><a disabled>Prev</a></div>
                                </c:when>
                                <c:when test="${pageNumber > 1}">
                                    <div class="page"><a href="matches?page=${pageNumber - 1}${filter}">Prev</a></div>
                                </c:when>
                            </c:choose>
                            <div class="page"><a disabled>${pageNumber}</a></div>
                            <c:choose>
                                <c:when test="${pageNumber == totalPages}">
                                    <div class="page"><a disabled>Next</a></div>
                                </c:when>
                                <c:when test="${pageNumber < totalPages}">
                                    <div class="page"><a href="matches?page=${pageNumber + 1}${filter}">Next</a></div>
                                </c:when>
                            </c:choose>
                        </c:if>
                    </div>
                </div>
            </div>
        </article>
    </section>
</body>
</html>