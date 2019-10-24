/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.JsonVIP;
import Modelo.VIPThread;
import VistaVIP.VistaVerMensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerVistaVerMensajes{
    VistaVerMensajes vista;
    VIPThread famoso;
    String usernameVIP;
    String vip;
    JsonVIP json;
            
    public ControllerVistaVerMensajes(VistaVerMensajes pVista,VIPThread pFamoso){
        this.vista = pVista;
        this.famoso = pFamoso;
        json = new JsonVIP();
        
        
    }
    
    
//    public void setUsernameVIP(String usernameVIP) {
//        this.usernameVIP = usernameVIP;
//    }

    public String getVIP() {
        return vip;
    }
    
    public void listarMensajes(){
        json.obtenerObjetoJson(VIPThread.VIPJson.get(famoso.getVIP().getUsername()));
    }
    

    
    
    
}
