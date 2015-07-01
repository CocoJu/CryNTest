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
public class HouseEditor extends HttpServlet{

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response){

        String action = request.getParameter("action");

        if(action.equals("add_house")){
            String adress = request.getParameter("adress");
            String count_floors = request.getParameter("count_floors");
            if(adress != null && count_floors != null){
                HouseManager hm = new HouseManager();
                System.out.println(adress);
                hm.insertHouse(Util.encode(adress), Integer.parseInt(count_floors));
                System.out.println(adress);
                hm.closeConnection();
            }
        }

        if(action.equals("delete_house")){
            String id = request.getParameter("house_id");
            if(id != null){
                HouseManager hm = new HouseManager();
                hm.deleteHouse(Integer.parseInt(id));
                hm.closeConnection();
            }
        }

        try {
            response.sendRedirect(Util.APP_URL + "/houselist.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}