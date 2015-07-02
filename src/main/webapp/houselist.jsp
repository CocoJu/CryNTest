<%@ page import="ru.cj.db.HouseManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="ru.cj.Util" %>

<% request.setCharacterEncoding("UTF-8"); %>

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
      HouseManager hm = new HouseManager();
      hm.openConnection();
      ResultSet listHouses = hm.getAllHouses();
      while(listHouses.next()){
    %>
    <tr>
      <th><%= listHouses.getString("adress") %></th>
      <th><%= listHouses.getInt("count_floors") %></th>
      <th>
          <a class="btn btn-default"
             href="<%= Util.APP_URL%>/del_house/?id=<%= listHouses.getInt("id_house") %>">удалить</a>
      </th>
    </tr>
    <%
      }
      hm.closeConnection();
    %>
    </tbody>
  </table>
</div>
</body>
</html>