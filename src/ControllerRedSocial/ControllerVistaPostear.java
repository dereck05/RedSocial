/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.*;
import API.MensajeObject;
import Modelo.VIPThread;
import VistaVIP.VistaPostear;
import VistaVIP.VistaVIP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerVistaPostear implements ActionListener {
    VistaPostear vista;
    VIPThread famoso;
    String usernameVIP;
    String vip;
    JsonVIP json;

    
            
    public ControllerVistaPostear(VistaPostear pVista,VIPThread pFamoso){
        this.vista = pVista;
        this.famoso = pFamoso;
        json = new JsonVIP();
        this.vista.btnPost.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Enviar":
                postear();
            
        }
    }
    
    public void setVIP(){
        this.vip = VIPThread.VIPLista.get(usernameVIP);
    }
    
    public void setUsernameVIP(String usernameVIP) {
        this.usernameVIP = usernameVIP;
    }

    public String getVIP() {
        return vip;
    }
    
    public void postear(){
       Mensaje message = new Mensaje(this.vista.txt_post.getText());
 
       String objJson = json.establecerJson(message);
       MensajeObject objeto = new MensajeObject();
       objeto.setComando("Postear mensaje");
       int numero = (int) (Math.random() * 100000) + 1;
       objeto.setKey(Integer.toString(numero));
       objeto.setObjeto(objJson);
       objeto.setNombreAplcacion("Subasta");
       famoso.enviarMensaje(objeto);
       VistaVIP vms = new VistaVIP();
       ControllerVistaVIP cvms = new ControllerVistaVIP(vms,famoso);
       cvms.setUser(this.famoso.getVIP().getNombre());
       vms.setVisible(true);
       this.vista.setVisible(false);
        
    }
    
}
