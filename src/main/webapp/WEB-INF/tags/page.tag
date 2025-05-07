<%@ tag language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Food</title>
    <style type="text/css">
        .link-button {
            margin: 5px;
            border: 1px solid;
            padding: 2px;
            -webkit-box-shadow: 5px 5px 5px 0px rgba(0,0,0,0.75);
            -moz-box-shadow: 5px 5px 5px 0px rgba(0,0,0,0.75);
            box-shadow: 5px 5px 5px 0px rgba(0,0,0,0.75);
        }
        .link-button:active {
            position: relative;
            left: 1px;
            top: 1px;
            -webkit-box-shadow: 4px 4px 4px 0px rgba(0,0,0,0.75);
            -moz-box-shadow: 4px 4px 4px 0px rgba(0,0,0,0.75);
            box-shadow: 4px 4px 4px 0px rgba(0,0,0,0.75);
        }
    </style>
</head>
<body>
<h1>Welcome here!</h1>
<div>
    <div style="margin: 10px;">
        <h3>Menu</h3>
        <a class="link-button" href="${pageContext.request.contextPath}/save-food">Új étel</a>
        <a class="link-button" href="${pageContext.request.contextPath}/food-list">Étel lista</a>
        <a class="link-button" href="${pageContext.request.contextPath}/logout">Kijelentkezés</a>
    </div>
</div>
<div>
    <jsp:doBody />
</div>
</body>
</html>
