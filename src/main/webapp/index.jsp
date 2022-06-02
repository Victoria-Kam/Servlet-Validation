<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        .error{color: red; font-family: Arial}
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/hello-servlet" method="post">
        <h1>Введи свой E-mail</h1>
        <input type="text" name="email">
        <label class="error">${messageEmail}</label>
        <br>
        <h1>Введи свой номер телефона</h1>
        <input type="text" name="mobNumber">
        <label class="error">${messageNumber}</label>
        <br>
        <br>
        <button type="submit">Отправить</button>
    </form>
</body>
</html>