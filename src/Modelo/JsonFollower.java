/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import API.Json;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author naty9
 */
public class JsonFollower extends Json{

    @Override
    public Follower obtenerObjetoJson(String json) {
        try{
            final Gson gson = new Gson();
            final Follower cl = gson.fromJson(json, Follower.class);
            return cl;
        }
        catch(JsonSyntaxException e){
            return null;
        }
    }

    @Override
    public ArrayList<Object> obtenerArrayObjetoJson(HashMap<String,String> arreglo){
        ArrayList<Object> c = new ArrayList<>();
        //try{
            Gson gson = new Gson();
            for(String value: arreglo.values()){
                System.out.println(value);
                Follower cl = (Follower)obtenerObjetoJson(value);
                c.add(cl);
            }
        //}
            System.out.println("si");
            return c;
        }

    @Override
    public HashMap<String, String> obtenerHashMapObjetoJson(String json) {
        Gson gson = new Gson();
        HashMap<String, String> newMap = gson.fromJson(json, HashMap.class); 
        return newMap;
    }
    
}
