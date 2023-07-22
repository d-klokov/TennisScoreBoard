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
                    <table>
                        <thead>
                            <tr>
                                <td class="player">PLAYER</td>
                                <td class="set">SETS</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${match.playerOne.name}</td>
                                <td>${match.matchScore.sets[0]}</td>
                            </tr>
                            <tr>
                                <td>${match.playerTwo.name}</td>
                                <td>${match.matchScore.sets[1]}</td>
                            </tr>
                        </tbody>
                    </table>
                    <a class="homeBtn" href="index"><div>HOME</div></a>
                </div>
            </div>
        </article>
    </section>
</body>
</html>