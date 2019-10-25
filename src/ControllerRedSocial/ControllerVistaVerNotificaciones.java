/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.Follower;
import Modelo.JsonFollower;
import Modelo.FollowerThread;
import Modelo.VIP;
import VistaFollower.VistaVerNotificaciones;
import java.util.ArrayList;


public class ControllerVistaVerNotificaciones{
    VistaVerNotificaciones vista;
    FollowerThread follower;
    
    JsonFollower json;
            
    public ControllerVistaVerNotificaciones(VistaVerNotificaciones pVista,FollowerThread pFollower){
        this.vista = pVista;
        this.follower = pFollower;
        json = new JsonFollower();
        verNotificaciones();
        
        
    }
    public void verNotificaciones(){
       String notif = "";
       ArrayList<VIP> arr = follower.obtenerVIP();
       for(int i=0;i<arr.size();i++){
           VIP v = (VIP)arr.get(i);
           for(Follower f:v.getFollowers()){
               String fol1 = follower.getFollower().getUsername();
               String fol2 = f.getUsername();
               if(fol1.equals(fol2)){
                   notif += f.getNotificaciones()+"\n\n";
                   vista.txt_notificaciones.append(notif);
               }
           }
           
           
       }
    }
    
}