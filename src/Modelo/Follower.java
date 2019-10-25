/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author derec
 */
public class Follower extends User {
    private transient ArrayList <VIP> followed;
    private ArrayList<String> notificaciones;
    
    public Follower(String nombre, String apellido1, String apellido2, String username){
        super(nombre, apellido1, apellido2,username);
        this.followed = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }
    
    public void addNotificacion(String s){
        notificaciones.add(s);
    }
    public ArrayList<String> getNotificaciones(){
        return this.notificaciones;
    }
    
}
