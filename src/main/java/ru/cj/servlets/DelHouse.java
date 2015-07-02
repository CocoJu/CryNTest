package ru.cj.servlets;

import ru.cj.Util;
import ru.cj.db.HouseManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by df on 30.06.2015.
 */
public class DelHouse extends HttpServlet{

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response){
        String id = request.getParameter("id");
        if(id != null){
            HouseManager hm = new HouseManager();
            hm.openConnection();
            hm.deleteHouse(Integer.parseInt(id));
            hm.closeConnection();
        }
        try {
            response.sendRedirect(Util.APP_URL + "/houselist.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
