
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Калькулятор - площади трапеции</title>
</head>
<body>

<h1>Калькулятор - площади трапеции</h1>>
    <form action="${pageContext.request.contextPath}/Calc" method="post">
        <label for="first">Первое ребро:</label>
        <input type="text" name="first" id="first" value="${first}">
        <label for="second">Второе ребро:</label>
        <input type="text" name="second" id="second" value="${second}">
        <label for="second">Высота:</label>
        <input type="text" name="third" id="second" value="${third}">
        <input type="submit" name="sign" value="Calculate">
    </form>
    </body>
</html>