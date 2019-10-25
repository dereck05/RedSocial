/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import API.MensajeObject;
import Modelo.JsonFollower;
import Modelo.FollowerThread;


import VistaFollower.VistaFollower;
import VistaFollower.VistaSeguirVIP;
import VistaFollower.VistaVerActualizaciones;
import VistaFollower.VistaVerNotificaciones;

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


public class ControllerVistaFollower extends Thread implements Serializable, Runnable,ActionListener{
    private VistaFollower vista;
    private FollowerThread follower;
    private String usernameFollower;

    
    public ControllerVistaFollower(){}
            
    public ControllerVistaFollower(VistaFollower pVista, FollowerThread pFamoso){
        this.vista = pVista;
        this.follower = pFamoso;
//        this.json= new JsonFollower();
        this.vista.btn_follow.addActionListener(this);
        this.vista.btn_verEstados.addActionListener(this);
        this.vista.btnVerNotif.addActionListener(this);
        follower.saveFollower();

    }
    
    public void setUser(String user){
        this.usernameFollower = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Dar Follow":
                darFollow();
                break;
            case "Ver Estados":
                verEstados();
                break;
            case "Ver Notificaciones":
                verNotificaciones();
                break;
            default:
                JOptionPane.showMessageDialog(vista, "Opción no registrada");
                break;
        }
    }

    
    private void darFollow() {
        VistaSeguirVIP vds = new VistaSeguirVIP();   
        ControllerVistaSeguirVIP cvds = new ControllerVistaSeguirVIP(vds,follower);
        vds.setVisible(true);
        

    }
    
    private void verEstados() {
        VistaVerActualizaciones vds = new VistaVerActualizaciones();   
        ControllerVistaVerActualizaciones cvds = new ControllerVistaVerActualizaciones(vds,follower);
        vds.setVisible(true);
    }
    
    private void verNotificaciones() {
        VistaVerNotificaciones vds = new VistaVerNotificaciones();   
        ControllerVistaVerNotificaciones cvds = new ControllerVistaVerNotificaciones(vds,follower);
        vds.setVisible(true);
    }
}