<%@ page import="ru.cj.db.HouseManager" %>
<%@ page import="java.sql.ResultSet" %>

<% request.setCharacterEncoding("UTF-8"); %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
<script src="resources/js/bootstrap.min.js"></script>
<head>
  <title></title>
</head>
<body>
<div class="container">
  <form method="post" role="form" class="navbar-form pull-left" action="edit_house/" accept-charset="UTF-8">
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
      ResultSet listHouses = hm.getAllHouses();
      while(listHouses.next()){
    %>
    <tr>
      <th><%= listHouses.getString("adress") %></th>
      <th><%= listHouses.getInt("count_floors") %></th>
      <th>
        <form method="post" role="form"  action="edit_house/" accept-charset="UTF-8">
          <input name="action" value="delete_house" style="display: none">
          <input name="house_id" value="<%= listHouses.getString("id_house")%>" style="display: none">
          <%--<input type="button" class="btn btn-mini" value="<%= listHouses.getString("id_house")%>" >--%>
          <button type="submit" class="btn btn-mini btn-dange">удалить</button>
         <%-- <input type="button" class="btn btn-mini"  >--%>
        </form>
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