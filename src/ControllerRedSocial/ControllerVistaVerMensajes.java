/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.JsonVIP;
import Modelo.Mensaje;
import Modelo.VIPThread;
import VistaVIP.VistaVerMensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ControllerVistaVerMensajes{
    VistaVerMensajes vista;
    VIPThread famoso;
    String vip;
    JsonVIP json;
            
    public ControllerVistaVerMensajes(VistaVerMensajes pVista,VIPThread pFamoso){
        this.vista = pVista;
        this.famoso = pFamoso;
        json = new JsonVIP();
        verMensajes();
        
        
    }

    public String getVIP() {
        return vip;
    }
    
    public void verMensajes(){
        ArrayList<Mensaje> m = famoso.verMensajes(famoso.getVIP().getUsername());
        for (int i =0 ; i< m.size(); i++){
            Mensaje msg = m.get(i);
            vista.txtMensajePosteado.append("Post #"+Integer.toString(i+1)+": "+msg.getContenido()+"\nLikes: "+msg.getLikes()+"\nDislikes: "+msg.getDislikes()+"\n\n");
        }
    }
    
    
    

    
    
    
}
