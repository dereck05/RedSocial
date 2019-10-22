/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRedSocial;

import API.MensajeObject;
import Modelo.JsonVIP;
import Modelo.VIPThread;
import VistaVIP.VistaPostear;
import VistaVIP.VistaVIP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author naty9
 */
public class ControllerVistaVIP implements ActionListener{
    private VistaVIP vista;
    private VIPThread famoso;
    private JsonVIP json;
    private String usernameVIP;
            
    public ControllerVistaVIP(VistaVIP pVista, VIPThread pFamoso){
        this.vista = pVista;
        this.famoso = pFamoso;
        this.json= new JsonVIP();
        this.vista.btn_postearMensaje.addActionListener(this);
        this.vista.btn_darseDeBaja.addActionListener(this);
        this.vista.btn_verMensajes.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch(e.getActionCommand()){
            case "Postear Mensaje":
                postearMensaje();
                break;
            case "Darse de Baja":
                //aceptarOfertas();
                break;
            case "Ver Mensajes":
                //cerrarSubasta();
            default:
                JOptionPane.showMessageDialog(vista, "Opción no registrada");
                break;
        }
    }
    
    private void postearMensaje() {
        VistaPostear vds = new VistaPostear();   
        ControllerVistaPostear cvds = new ControllerVistaPostear(vds,famoso);
        cvds.setUsernameVIP(usernameVIP);
        cvds.setVIP();
        vds.setVisible(true);
    }
    /*private void cerrarSubasta(){
        Subasta s = json.obtenerObjetoJson(SubastadorThread.subastasLista.get(nombreSubasta));
        s.setStatus("Cerrada");
        String s1 = json.establecerJson(s);
        MensajeObject objeto = new MensajeObject();
        objeto.setComando("Cerrar Subasta");
        objeto.setNombreAplcacion("Subasta");
        objeto.setKey(nombreSubasta);
        objeto.setObjeto(s1);
        subastador.enviarMensaje(objeto);   
        JOptionPane.showMessageDialog(vista, "Subasta cerrada con éxito");
    }
    private void cancelarSubasta(){
        Subasta s = json.obtenerObjetoJson(SubastadorThread.subastasLista.get(nombreSubasta));
        s.setStatus("Cancelada");
        String s1 = json.establecerJson(s);
        MensajeObject objeto = new MensajeObject();
        objeto.setComando("Cancelar Subasta");
        objeto.setNombreAplcacion("Subasta");
        objeto.setKey(nombreSubasta);
        objeto.setObjeto(s1);
        subastador.enviarMensaje(objeto);   
        JOptionPane.showMessageDialog(vista, "Subasta cerrada con éxito");
    }
    private void aceptarOfertas() {
        VistaAceptarOfertas vao = new VistaAceptarOfertas();
    }*/
    
    
    
}
