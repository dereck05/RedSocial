/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import API.MensajeObject;
import Modelo.JsonVIP;
import Modelo.VIPThread;
import VistaVIP.VistaPostear;
import VistaVIP.VistaVIP;
import VistaVIP.VistaVerMensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControllerVistaVIP implements ActionListener{
    private VistaVIP vista;
    private VIPThread famoso;
    private JsonVIP json;
    private String usernameVIP;
            
    public ControllerVistaVIP(VistaVIP pVista, VIPThread pFamoso){
        this.vista = pVista;
        this.famoso = pFamoso;
        this.json= new JsonVIP();
        this.vista.btn_postearMensaje.addActionListener(this);
        this.vista.btn_darseDeBaja.addActionListener(this);
        this.vista.btn_verMensajes.addActionListener(this);
    }
    
    public void setUser(String user){
        this.usernameVIP = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Postear mensaje":
                postearMensaje();
                break;
            case "Darse de baja":
                //aceptarOfertas();
                break;
            case "Ver Mensajes":
                verMensajes();
                break;
            default:
                JOptionPane.showMessageDialog(vista, "Opción no registrada");
                break;
        }
    }
    
    private void postearMensaje() {
        VistaPostear vds = new VistaPostear();   
        ControllerVistaPostear cvds = new ControllerVistaPostear(vds,famoso);
        cvds.setUsernameVIP(usernameVIP); 
        vds.setVisible(true);
    }
    
    private void verMensajes() {
        VistaVerMensajes vds = new VistaVerMensajes();   
        ControllerVistaVerMensajes cvds = new ControllerVistaVerMensajes(vds,famoso);
        cvds.setUsernameVIP(usernameVIP); 
        vds.setVisible(true);
    }
}