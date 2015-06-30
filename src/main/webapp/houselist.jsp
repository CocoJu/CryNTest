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
  <form role="form" class="navbar-form pull-left" action="addhouse/" accept-charset="UTF-8">
    <input name="adress" type="text"
           class="form-control span2" placeholder="адрес дома">
    <input name="count_floors" type="text"
           class="form-control span2" placeholder="материал здания">
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
      <th><button type="submit" class="btn btn-default"
              id="<%= listHouses.getString("id_house")%>">Submit</button></th>
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