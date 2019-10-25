/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.FollowerThread;
import Modelo.VIP;
import VistaFollower.VistaSeguirVIP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author naty9
 */
public class ControllerVistaSeguirVIP implements ActionListener { 
    private VistaSeguirVIP vista;
    private FollowerThread follower;

   
    public ControllerVistaSeguirVIP(VistaSeguirVIP vds, FollowerThread f) {
        this.vista = vds;
        this.follower = f;
        this.vista.btnFollow.addActionListener(this);
        visualizarVIP();
        
    }
    public void visualizarVIP(){
        DefaultListModel model = new DefaultListModel<>();
        ArrayList<VIP> arr = this.follower.obtenerVIP();
        for (VIP item: arr){

            String texto = item.getUsername();
            model.addElement(texto);
        }
        this.vista.list.setModel(model);

        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seleccionarSubasta();
    }
    public void seleccionarSubasta(){
      if(this.vista.list.isSelectionEmpty()){
          JOptionPane.showMessageDialog(vista, "Debe seleccionar un VIP");
      }
      else{
          String vip = this.follower.obtenerVIP().get(this.vista.list.getSelectedIndex()).getUsername();
          follower.seguirVIP(vip);
          JOptionPane.showMessageDialog(vista, "VIP seguido!");


      }
    
    }
    
}
