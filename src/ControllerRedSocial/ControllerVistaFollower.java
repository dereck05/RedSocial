/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import VistaFollower.VistaFollower;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author naty9
 */
public class ControllerVistaFollower implements ActionListener {
    private VistaFollower vista;
            
    public ControllerVistaFollower(VistaFollower pVista){
        this.vista = pVista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
