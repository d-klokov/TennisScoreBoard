<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@ include file="/css/style.css"%></style>
    <style><%@ include file="/css/error.css"%></style>
    <title>Error ${status}</title>
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