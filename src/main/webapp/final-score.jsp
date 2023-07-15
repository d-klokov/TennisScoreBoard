<html>
<head>
    <title>Final score</title>
    <style><%@ include file="/css/final-score.css"%></style>
</head>
<body>
    <div class="navigation">
        <div class="links">
            <a class="link" href="index">HOME</a>
            <a class="link" href="new-match">NEW</a>
            <a class="link" href="matches">MATCHES</a>
        </div>
    </div>
    <div class="container">
        <div class="title"><h1>Match finished! ${match.winner.name} wins!</h1></div>
        <div class="content">
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
</body>
</html>