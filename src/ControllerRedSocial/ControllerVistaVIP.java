/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import API.MensajeObject;
import Modelo.JsonVIP;
import Modelo.VIPThread;
import static Modelo.VIPThread.VIPJson;
import static Modelo.VIPThread.VIPLista;
import VistaVIP.VistaPostear;
import VistaVIP.VistaVIP;
import VistaVIP.VistaVerMensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ControllerVistaVIP extends Thread implements Serializable, Runnable,ActionListener{
    private VistaVIP vista;
    private VIPThread famoso;
    private String usernameVIP;

    
    public ControllerVistaVIP(){}
            
    public ControllerVistaVIP(VistaVIP pVista, VIPThread pFamoso){
        this.vista = pVista;
        this.famoso = pFamoso;
//        this.json= new JsonVIP();
        this.vista.btn_postearMensaje.addActionListener(this);
        this.vista.btn_darseDeBaja.addActionListener(this);
        this.vista.btn_verMensajes.addActionListener(this);
        famoso.saveVIP();

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
        {
            try {
                darseDeBaja();
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerVistaVIP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        vds.setVisible(true);
        

    }
    
    private void verMensajes() {
        VistaVerMensajes vds = new VistaVerMensajes();   
        ControllerVistaVerMensajes cvds = new ControllerVistaVerMensajes(vds,famoso);
        vds.setVisible(true);
    }
    
    private void darseDeBaja() throws InterruptedException{
        famoso.darDeBaja(famoso.getVIP().getUsername());
        JOptionPane.showMessageDialog(vista, "Usted fue dado de baja!:(");
        Thread.sleep(2000);
        vista.dispose();
    }
}