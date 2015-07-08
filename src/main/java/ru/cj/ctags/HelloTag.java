/*package ru.cj.ctags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class HelloTag extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("Hello Custom Tag!");
        javax.servlet.
    }
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


}*/
