package ru.cj.servlets;

/**
 * Created by df on 29.06.2015.
 */
import ru.cj.db.Security;

import javax.servlet.http.*;

// Extend HttpServlet class
public class LoginController extends HttpServlet {

    private String username;
    private String pwd;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response){
        username = request.getParameter("username");
        pwd = request.getParameter("password");
        int role = Security.getUserRole(username, pwd);
        if(role > 0){
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setAttribute("role", role);
        }
    }
}