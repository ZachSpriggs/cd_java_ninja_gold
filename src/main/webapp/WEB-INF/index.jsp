<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Ninja Gold!</title>
</head>
<body>

    <div class="wrapper">
    <div class="count">
        <h3>Your Gold: <c:out value = "${gold}"/></h3>
    </div>
    <div class="options">
        <div class="farm">
            <h1>Farm</h1>
            <h3>(earns 10-20 golds)</h3>
            <form action="/process_money" method = "POST">
                <input type="hidden" name = 'action' value = 'farm'>
                <button>Find Gold!</button>
            </form>
        </div>
        <div class="cave">
            <h1>Cave</h1>
            <h3>(earns 5-10 golds)</h3>
            <form action="/process_money" method = "POST">
                <input type="hidden" name = 'action' value = 'cave'>
                <button>Find Gold!</button>
            </form>
        </div>
        <div class="house">
            <h1>House</h1>
            <h3>(earns 2-5 golds)</h3>
            <form action="/process_money" method = "POST">
                <input type="hidden" name = 'action' value = 'house'>
                <button>Find Gold!</button>
            </form>
        </div>
        <div class="casino">
            <h1>Casino</h1>
            <h3>(earns/takes 0-50 golds)</h3>
            <form action="/process_money" method = "POST">
                <input type="hidden" name = 'action' value = 'casino'>
                <button>Find Gold!</button>
            </form>
        </div>
        <div class="activities">
            <h3>Activities:</h3>
              	<c:forEach items = "${activities}" var = "i">
         				<p><c:out value = "${i}"/><p>
     			</c:forEach>
        </div>
        <div class="reset">
            <form action="/reset" method='post'>
                <button>Reset Game</button>
            </form>
        </div>
    </div>

</body>
</html>