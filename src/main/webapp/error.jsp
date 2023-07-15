<html>
<head>
<title>${statusTitle}</title>
</head>
<style><%@ include file="/css/error.css"%></style>
<body>
    <div class="container">
        <div class="title"><h1>${status} ${statusTitle}</h1></div>
        <div class="content">
            <div class="message">${message}</div>
            <a class="homeBtn" href="index"><div>HOME</div></a>
        </div>
    </div>
</body>
</html>