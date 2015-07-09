<%@ page import="ru.cj.db.dao.House" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.cj.db.DbManagerFactory" %>

<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
  <title>список домов</title>
  <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
  <script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <form method="post" role="form" class="navbar-form pull-left" action="add_house/" accept-charset="UTF-8">
    <input name="action" value="add_house" style="display: none">
    <input name="adress" type="text"
           class="form-control span2" placeholder="адрес дома">
    <input name="count_floors" type="text"
           class="form-control span2" placeholder="количество этажей">
    <button type="submit" class="btn btn-default">Добавить</button>
  </form>
  <table class="table">
    <caption>Список домов:</caption>
    <thead>
    <tr>
      <th>адрес дома</th>
      <th>этажность</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<House> houseList = DbManagerFactory.newInstance().getAllHouses();
        request.setAttribute("houseList", houseList);%>
      <c:forEach items="${requestScope.houseList}" var="house" >
        <tr>
          <th><c:out value="${house.getAddress()}"/></th>
          <th><c:out value="${house.getCountFloors()}"/></th>
          <th>
            <c:set var="appUrl" value="${ru.cj.Util.APP_URL}"/>
            <a class="btn btn-default"
               href=" <c:url value="${appUrl}/del_house/?id=${house.getId()}"/> ">удалить</a>
          </th>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>