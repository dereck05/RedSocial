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
import VistaFollower.VistaVerNotificaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ControllerVistaVerNotificaciones{
    VistaVerNotificaciones vista;
    FollowerThread follower;
    
    JsonFollower json;
            
    public ControllerVistaVerNotificaciones(VistaVerNotificaciones pVista,FollowerThread pFollower){
        this.vista = pVista;
        this.follower = pFollower;
        json = new JsonFollower();
        //verMensajes();
        
        
    }
    
}