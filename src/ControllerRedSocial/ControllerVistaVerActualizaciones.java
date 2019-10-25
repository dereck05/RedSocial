/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.JsonFollower;
import Modelo.Mensaje;
import Modelo.FollowerThread;
import VistaFollower.VistaVerActualizaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ControllerVistaVerActualizaciones{
    VistaVerActualizaciones vista;
    FollowerThread follower;
    
    JsonFollower json;
            
    public ControllerVistaVerActualizaciones(VistaVerActualizaciones pVista,FollowerThread pFollower){
        this.vista = pVista;
        this.follower = pFollower;
        json = new JsonFollower();
        //verMensajes();
        
        
    }
    
}

    
//    public void verMensajes(){
//        ArrayList<Mensaje> m = famoso.verMensajes(famoso.getFollower().getUsername());
//        for (int i =0 ; i< m.size(); i++){
//            Mensaje msg = m.get(i);
//            vista.txtMensajePosteado.append("Post #"+Integer.toString(i+1)+": "+msg.getContenido()+"\nLikes: "+msg.getLikes()+"\nDislikes: "+msg.getDislikes()+"\n\n");
//        }
//    }
    