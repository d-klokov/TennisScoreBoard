<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@ include file="/css/style.css"%></style>
    <style><%@ include file="/css/finished-matches.css"%></style>
    <title>Finished matches</title>
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
                <h1>Finished matches</h1>
                <div class="content-body">
                    <div class="filter">
                        <div class="playerNameLab">Name:</div>
                        <form action="matches">
                            <input id="playerNameInput" class="playerNameInp" type="text" value="${playerName}" name="filter_by_player_name">
                            <input type="submit" value="SEARCH" class="filterButton" />
                            <a href="matches" class="clearLink"><input type="button" value="CLEAR" class="clearButton" /></a>
                        </form>
                    </div>
                    <c:if test="${error != null}">
                        <div class="error">${error}</div>
                    </c:if>
                    <div class="matches-list">
                        <c:forEach items="${page.content}" var="match">
                            <div class="row">
                                <div class="id">${match.id}</div>
                                <div class="playerOne">${match.playerOne.name}</div>
                                <div class="playerTwo">${match.playerTwo.name}</div>
                                <div class="winner">${match.winner.name}</div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="pagination">
                        <c:choose>
                            <c:when test="${empty playerName}">
                                <c:set var="filter" value="" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="filter" value="&filter_by_player_name=${playerName}" />
                            </c:otherwise>
                        </c:choose>
                        <c:if test="${page.totalPages > 1}">
                            <c:choose>
                                <c:when test="${page.pageNumber == 1}">
                                    <div class="page"><a disabled>Prev</a></div>
                                </c:when>
                                <c:when test="${page.pageNumber > 1}">
                                    <div class="page"><a href="matches?page=${page.pageNumber - 1}${filter}">Prev</a></div>
                                </c:when>
                            </c:choose>
                            <div class="page"><a disabled>${page.pageNumber}</a></div>
                            <c:choose>
                                <c:when test="${page.pageNumber == page.totalPages}">
                                    <div class="page"><a disabled>Next</a></div>
                                </c:when>
                                <c:when test="${page.pageNumber < page.totalPages}">
                                    <div class="page"><a href="matches?page=${page.pageNumber + 1}${filter}">Next</a></div>
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