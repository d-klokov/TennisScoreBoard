<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style><%@ include file="/css/style.css"%></style>
        <style><%@ include file="/css/new-match.css"%></style>
        <title>New match</title>
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
                    <h1>New match</h1>
                    <div class="content-body">
                        <div class="form-container">
                            <form action="new-match" method="POST">
                                <div class="row">
                                    <div class="titleCol"><h4>Player 1 name:</h4></div>
                                    <div class="inputCol"><input type="text" name="playerOneName" value="${playerOneName}" /></div>
                                </div>
                                <div class="row">
                                    <c:if test="${errors.playerOneNameNotValid}">
                                        <div class="error"><span>${errors.playerOneNameNotValid}</span></div>
                                    </c:if>
                                </div>
                                <div class="row">
                                    <div class="titleCol"><h4>Player 2 name:</h4></div>
                                    <div class="inputCol"><input type="text" name="playerTwoName" value="${playerTwoName}" /></div>
                                </div>
                                <div class="row">
                                    <c:if test="${errors.playerTwoNameNotValid}">
                                        <div class="error"><span>${errors.playerTwoNameNotValid}</span></div>
                                    </c:if>
                                </div>
                                <c:if test="${errors.playerNamesAreSame}">
                                    <div class="row">
                                        <div class="error">${errors.playerNamesAreSame}</div>
                                    </div>
                                </c:if>
                                <div class="row">
                                    <input class="submit" type="submit" value="START"></input>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </article>
        </section>
    </body>
</html>
