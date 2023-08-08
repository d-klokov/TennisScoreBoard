<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@ include file="/css/style.css"%></style>
    <style><%@ include file="/css/final-score.css"%></style>
    <title>Final score</title>
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
                <h1>Match finished! ${match.winner.name} wins!</h1>
                <div class="content-body">
                    <div class="result">
                        <div class="row">
                            <div class="playerName">${match.playerOne.name}</div>
                            <div class="score">${match.matchScore.getPlayerScore(0)}</div>
                        </div>
                        <div class="row">
                            <div class="playerName">${match.playerTwo.name}</div>
                            <div class="score">${match.matchScore.getPlayerScore(1)}</div>
                        </div>
                    </div>
                    <a class="homeBtn" href="index"><div>HOME</div></a>
                </div>
            </div>
        </article>
    </section>
</body>
</html>