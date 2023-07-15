<html>
    <head>
        <title>New match</title>
    </head>
    <style><%@ include file="/css/new-match.css"%></style>
    <body>
        <div class="navigation">
            <div class="links">
                <a class="link" href="index">HOME</a>
                <a class="link" href="new-match">NEW</a>
                <a class="link" href="matches">MATCHES</a>
            </div>
        </div>
        <div class="container">
            <div class="title"><h1>New match</h1></div>
            <div class="content">
                <form action="new-match" method="POST">
                    <div class="formRow">
                        <strong>Player 1 name: </strong><input type="text" name="playerOneName" value="${playerOneName}" />
                        <c:if test="${errors.playerOneNameNotValid}">
                            <div class="error">${errors.playerOneNameNotValid}</div>
                        </c:if>
                    </div>
                    <div class="formRow">
                        <strong>Player 2 name: </strong><input type="text" name="playerTwoName" value="${playerTwoName}" />
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
    </body>
</html>
