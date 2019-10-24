/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.VIPThread;
import VistaVIP.VistaCrearVIP;
import VistaVIP.VistaVIP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerVistaCrearVIP implements ActionListener{
    private VistaCrearVIP vista;
    private VIPThread famoso;

    public ControllerVistaCrearVIP(VistaCrearVIP pVista, VIPThread pFamoso){
        this.vista = pVista;
        this.famoso = pFamoso;
        this.vista.btnIniciar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        iniciar();
    }
    
    public void iniciar(){
        famoso.crearVIP(vista.txtNombre.getText(), vista.txtApellido1.getText(), vista.txtApellido2.getText(), vista.txtNick.getText());
        VistaVIP vds = new VistaVIP();   
        ControllerVistaVIP cvds = new ControllerVistaVIP(vds,famoso);
        vds.setVisible(true);
        this.vista.setVisible(false);
    }
            
}
