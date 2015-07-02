package ru.cj;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by df on 01.07.2015.
 */
public class Util {

    private Util(){};

    public static final String APP_URL = "/CryNTest";

    public static String encode(String str) {
        try {
            return str == null ? "" : new String(str.getBytes("ISO-8859-1"), "UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
    }

    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        if (request.getCookies() == null) {
            return null;
        }
        for (int i = 0; i < request.getCookies().length; i++) {
            if (request.getCookies()[i].getName().equals(name)) {
                return request.getCookies()[i];
            }
        }
        return null;
    }
}
