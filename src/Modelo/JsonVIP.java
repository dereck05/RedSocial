/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import API.Json;
import com.google.gson.Gson;
import java.util.HashMap;

/**
 *
 * @author naty9
 */
public class JsonVIP extends Json{

    @Override
    public Object obtenerObjetoJson(String json) {
        try{
            final Gson gson = new Gson();
            final Mensaje cl = gson.fromJson(json, Mensaje.class);
            return cl;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public Object[] obtenerArrayObjetoJson(String json) {
        try{
            Mensaje[] c = null;
            Gson gson = new Gson();
             c =  gson.fromJson(json, Mensaje[].class);
            return c;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public HashMap<String, String> obtenerHashMapObjetoJson(String json) {
        Gson gson = new Gson();
        HashMap<String, String> newMap = gson.fromJson(json, HashMap.class); 
        return newMap;
    }
    
}
