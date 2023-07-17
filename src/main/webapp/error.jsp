<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@ include file="/css/error.css"%></style>
    <title>Error ${status}</title>
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
                <h1>${status} ${statusTitle}</h1>
                <div class="content-body">
                    <div class="message">${message}</div>
                    <a class="homeBtn" href="index"><div>HOME</div></a>
                </div>
            </div>
        </article>
    </section>
</body>
</html>