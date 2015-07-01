package ru.cj;

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
}
