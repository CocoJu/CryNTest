package ru.cj.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by df on 30.06.2015.
 */
public class HouseEditor extends HttpServlet{

    private String adress;
    private String count_floors;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response){
        adress = request.getParameter("adress");
        count_floors = request.getParameter("count_floors");
        if(adress!=null && count_floors!= null){

        }


    }
}
