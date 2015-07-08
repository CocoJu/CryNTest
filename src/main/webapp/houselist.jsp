<%@ page import="ru.cj.db.DbManagerI" %>
<%@ page import="ru.cj.db.jdbc.JdbcDbManager" %>
<%@ page import="ru.cj.db.dao.House" %>
<%@ page import="java.util.List" %>
<%--<%@ taglib prefix="tagFiles" tagdir="/WEB-INF/tags.tld" %>--%>

- See more at: http://www.javabeat.net/custom-tags-in-jsp-2-0/#sthash.Kz14bZyf.dpuf
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
    <% DbManagerI dbMan = new JdbcDbManager();
      List<House> list = dbMan.getAllHouses();
      %>
      <c:set var="list" value="<%=list%>"/>
      <c:forEach items="${list}" var="house" >
        <tr>
          <th><c:out value="${house.getAddress()}"/></th>
          <th><c:out value="${house.getCountFloors()}"/></th>
          <%--<th>
            <a class="btn btn-default"
               href="<%= Util.APP_URL%>/del_house/?id=<%= listHouses.getInt("id_house") %>">удалить</a>
          </th>--%>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>