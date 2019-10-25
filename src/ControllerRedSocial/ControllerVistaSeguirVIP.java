/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.FollowerThread;
import VistaFollower.VistaSeguirVIP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author naty9
 */
public class ControllerVistaSeguirVIP implements ActionListener { 
    private VistaSeguirVIP vista;
            
    public ControllerVistaSeguirVIP(VistaSeguirVIP pVista){
        this.vista = pVista;
    }

    ControllerVistaSeguirVIP(VistaSeguirVIP vds, FollowerThread follower) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
