package com.practica.transporte.services.exceptions;

public class ServicesUtil {

    public static boolean validUsername(String username){
        if(username == null) return false;
        if(username.trim().isEmpty()) return false;
        return true;
    }
}
