<% request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
<form method="post" action="login/" class="form-signin" style="max-width: 330px">
    <h2 class="form-signin-heading">Вход в систему:</h2>
    <input name="username" class="form-control"
           placeholder="логин" autofocus="">
    <input name ="password" type="password"
           class="form-control"  placeholder="пароль" required="">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
</form>
</div>
</body>
</html>
