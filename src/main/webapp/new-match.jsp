<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style><%@ include file="/css/new-match.css"%></style>
        <title>New match</title>
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
                    <h1>New match</h1>
                    <div class="content-body">
                        <form action="new-match" method="POST">
                            <div class="formRow">
                                <span>Player 1 name: </span><input type="text" name="playerOneName" value="${playerOneName}" />
                                <c:if test="${errors.playerOneNameNotValid}">
                                    <div class="error">${errors.playerOneNameNotValid}</div>
                                </c:if>
                            </div>
                            <div class="formRow">
                                <span>Player 2 name: </span><input type="text" name="playerTwoName" value="${playerTwoName}" />
                                <c:if test="${errors.playerTwoNameNotValid}">
                                    <div class="error">${errors.playerTwoNameNotValid}</div>
                                </c:if>
                            </div>
                            <div class="formRow">
                                <c:if test="${errors.playerNamesAreSame}">
                                    <div class="error">${errors.playerNamesAreSame}</div>
                                </c:if>
                            </div>
                            <div class="formRow">
                                <input class="submit" type="submit" value="START"></input>
                            </div>
                        </form>
                    </div>
                </div>
            </article>
        </section>
    </body>
</html>
