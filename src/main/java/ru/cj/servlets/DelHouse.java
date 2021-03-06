package ru.cj.servlets;

import ru.cj.Util;
import ru.cj.db.DbManagerFactory;
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
            DbManagerFactory.newInstance()
                    .deleteHouse(Integer.parseInt(id));
        }
        try {
            response.sendRedirect(Util.APP_URL + "/houselist.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
