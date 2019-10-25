/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.User;
import Modelo.Follower;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author derec
 */
public class VIP extends User {
    private ArrayList<Mensaje> mensajes;
    private ArrayList<ObjectOutputStream> followers;
    private Boolean activo;
    private int nivel;
    
    public VIP(String nombre, String apellido1, String apellido2, String username){
        super(nombre, apellido1, apellido2, username);
        this.mensajes = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.activo = true;
        this.nivel =0;
    }
    public ArrayList getMensajes(){
        return mensajes;
    }
    public ArrayList<ObjectOutputStream> getFollowers(){
        return followers;
    }
    
    public void postMessage(Mensaje msg){
        
        mensajes.add(msg);                   
    }
    public void addFollower(ObjectOutputStream f){
        followers.add(f);                    
    }
    public void addNivel(){
        nivel = nivel+=1;
    }
    public String getNivel(){
        return Integer.toString(nivel);
    }
    public void setEstado(Boolean b){
        this.activo = b;
    }
    
    
}
