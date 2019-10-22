/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.VIPThread;
import VistaVIP.VistaPostear;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author naty9
 */
public class ControllerVistaPostear implements ActionListener {
    private VistaPostear vista;
    private VIPThread famoso;
    private String usernameVIP;
    private String vip;
            
    public ControllerVistaPostear(VistaPostear pVista,VIPThread pFamoso){
        this.vista = pVista;
        this.famoso = pFamoso;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
