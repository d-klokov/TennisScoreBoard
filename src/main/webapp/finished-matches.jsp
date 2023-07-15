<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>Finished matches</title>
    </head>
    <style><%@ include file="/css/finished-matches.css"%></style>
    <body>
        <div class="navigation">
            <div class="links">
                <a class="link" href="index">HOME</a>
                <a class="link" href="new-match">NEW</a>
                <a class="link" href="matches">MATCHES</a>
            </div>
        </div>
        <div class="container">
            <div class="title"><h1>Finished matches</h1></div>
            <div class="content">
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
                                <a><button disabled>Prev</button></a>
                            </c:when>
                            <c:when test="${pageNumber > 1}">
                                <a href="matches?page=${pageNumber - 1}${filter}"><button>Prev</button></a>
                            </c:when>
                        </c:choose>
                        <button disabled>${pageNumber}</button>
                        <c:choose>
                            <c:when test="${pageNumber == totalPages}">
                                <a><button disabled>Next</button></a>
                            </c:when>
                            <c:when test="${pageNumber < totalPages}">
                                <a href="matches?page=${pageNumber + 1}${filter}"><button>Next</button></a>
                            </c:when>
                        </c:choose>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>