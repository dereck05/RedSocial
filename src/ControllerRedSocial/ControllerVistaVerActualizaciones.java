/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import Modelo.Follower;
import Modelo.JsonFollower;
import Modelo.Mensaje;
import Modelo.FollowerThread;
import Modelo.VIP;
import VistaFollower.VistaVerActualizaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class ControllerVistaVerActualizaciones implements ActionListener{
    VistaVerActualizaciones vista;
    FollowerThread follower;
    ArrayList<VIP> auxVIP;
    
    JsonFollower json;
            
    public ControllerVistaVerActualizaciones(VistaVerActualizaciones pVista,FollowerThread pFollower){
        this.vista = pVista;
        this.follower = pFollower;
        json = new JsonFollower();
        vista.btnLike.addActionListener(this);
        vista.btnDislike.addActionListener(this);
        auxVIP = new ArrayList<>();
       
        verMensajes();
        
        
    }
    
    public void verMensajes(){
        DefaultListModel model = new DefaultListModel<>();
        ArrayList<VIP> arr = this.follower.obtenerVIP();
        VIP v ;
        String myID = follower.getFollower().getUsername();
        for (VIP item: arr){
            for(Follower f : item.getFollowers()){
                if(f.getUsername().equals(myID)){
                    auxVIP.add(item);
                    for(int i = 0; i < item.getMensajes().size();i++){
                        
                        Mensaje m = (Mensaje)item.getMensajes().get(i);
                        String texto = "Usuario: "+item.getUsername()+"     Post: "+m.getContenido();
                        model.addElement(texto);
                    }
                }
            }
            
        }
        this.vista.listaMsj.setModel(model);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Like":
                like();
                break;
            case "Dislike":
                dislike();
                break;
            default:
                break;
            
        }
        
    }
    
    
    public void like(){
        if(this.vista.listaMsj.isSelectionEmpty()){
          JOptionPane.showMessageDialog(vista, "Debe seleccionar un msj");
        }
        else{
            int index = this.vista.listaMsj.getSelectedIndex();
            int cont =0;
            for (VIP v: auxVIP){
                for (int i = 0; i < v.getMensajes().size();i++){
                    if(cont < index){
                        cont++;
                    }
                    else{
                        Mensaje m = (Mensaje)v.getMensajes().get(i);
                        m.addLike();
                        int nlikes = Integer.parseInt(m.getLikes());
                        
                        v.getMensajes().set(i,m);
                        follower.reaccionarAMensaje(v);
                        
                        if(nlikes % 2 == 0 && nlikes != 0){            //2 likes
                            
                            follower.setNotificacion(v.getUsername(), "El mensaje: "+m.getContenido()+" de "+v.getUsername()+ " ha llegado a "+nlikes+" likes\n");
                        }
                        JOptionPane.showMessageDialog(vista, "Reaccion agregada!");

                        break;
                    }
                }
                break;
            }

        }
    }
    public void dislike(){
        if(this.vista.listaMsj.isSelectionEmpty()){
          JOptionPane.showMessageDialog(vista, "Debe seleccionar un msj");
        }
        else{
            int index = this.vista.listaMsj.getSelectedIndex();
            int cont =0;
            for (VIP v: auxVIP){
                for (int i = 0; i < v.getMensajes().size();i++){
                    if(cont < index){
                        cont++;
                    }
                    else{
                        Mensaje m = (Mensaje)v.getMensajes().get(i);
                        m.addDislikes();
                        v.getMensajes().set(i,m);
                        follower.reaccionarAMensaje(v);
                        JOptionPane.showMessageDialog(vista, "Reaccion agregada!");

                        break;
                    }
                }
                break;
            }

        }
    }
    
}

