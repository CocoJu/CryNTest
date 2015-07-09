package ru.cj.servlets;

/**
 * Created by df on 29.06.2015.
 */
import ru.cj.Util;
import ru.cj.db.Security;

import javax.servlet.http.*;
import java.io.IOException;

// Extend HttpServlet class
public class LoginController extends HttpServlet {

    private String username;
    private String pwd;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response){
        username = request.getParameter("username");
        pwd = request.getParameter("password");
        int role = Security.getUserRole(username, pwd);
        if(role > Security.NO_AUTHORY){
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);
            session.setAttribute("role", role);
            try {
                response.sendRedirect(Util.APP_URL+"/houselist.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                response.sendRedirect(Util.APP_URL+"/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}