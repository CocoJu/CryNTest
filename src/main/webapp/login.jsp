<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 14.05.2015
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<form name="f1" method="post" action="login/login.jsp" id="f1">
    <table>
        <tr>
            <td class="f1_label">User Name :</td><td><input type="text" name="username" value="" />
        </td>
        </tr>
        <tr>
            <td class="f1_label">Password  :</td><td><input type="password" name="password" value=""  />
        </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="login" value="Log In" style="font-size:18px; " />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
