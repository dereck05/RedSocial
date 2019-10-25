package ControllerRedSocial;

import Modelo.FollowerThread;
import VistaFollower.VistaCrearFollower;
import VistaFollower.VistaFollower;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerVistaCrearFollower implements ActionListener{
    private VistaCrearFollower vista;
    private FollowerThread follower;
    
    public ControllerVistaCrearFollower(VistaCrearFollower pVista, FollowerThread pFollower){
        this.vista = pVista;
        this.follower = pFollower;
        this.vista.btn_iniciar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        iniciar();
    }
    
    
    
    public void iniciar(){
        follower.crearFollower(vista.txt_nombre.getText(), vista.txt_apellido1.getText(), vista.txt_apellido2.getText(), vista.txt_user.getText());
        VistaFollower vds = new VistaFollower();   
        ControllerVistaFollower cvds = new ControllerVistaFollower(vds,follower);
        vds.setVisible(true);
        this.vista.setVisible(false);
        JOptionPane.showMessageDialog(vista, "Follower Creado!");
    }
            
}
