/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.*;
import Modelo.VIPThread;
import VistaVIP.VistaPostear;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControllerVistaPostear implements ActionListener {
    VistaPostear vista;
    VIPThread famoso;
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

    public String getVIP() {
        return vip;
    }
    
    public void postear(){
       Mensaje message = new Mensaje(this.vista.txt_post.getText());
       famoso.postearMensaje(famoso.getVIP().getUsername(),message);
       JOptionPane.showMessageDialog(vista, "Post publicado!"); 
    }
    
}
