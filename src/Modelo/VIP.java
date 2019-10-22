/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.User;
import Modelo.Follower;
import java.util.ArrayList;

/**
 *
 * @author derec
 */
public class VIP extends User {
    public ArrayList<Mensaje> mensajes;
    public ArrayList<Follower> followers;
    
    public VIP(String nombre, String apellido1, String apellido2, String username){
        super(nombre, apellido1, apellido2, username);
        this.mensajes = new ArrayList<>();
        this.followers = new ArrayList<>();
    }
    
    public void postMessage(String msg){
        Mensaje m = new Mensaje(msg);
        mensajes.add(m);                    //no se si aqui iria el observer
    }
    public void addFollower(Follower f){
        followers.add(f);                    //aqui puede ser tambien los observadores
    }
    
    
}
