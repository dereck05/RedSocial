/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import API.IObserver;
import API.MensajeObject;
import ControllerRedSocial.ControllerVistaCrearVIP;
import ControllerRedSocial.ControllerVistaPostear;
import ControllerRedSocial.ControllerVistaVIP;
import ControllerRedSocial.ControllerVistaVerMensajes;
import VistaVIP.VistaCrearVIP;
import VistaVIP.VistaPostear;
import VistaVIP.VistaVIP;
import VistaVIP.VistaVerMensajes;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naty9
 */
public class VIPThread extends Thread implements IObserver,Serializable, Runnable{
    final int puerto = 8888;
    final String host = "127.0.0.1";
    Socket socket;
    ServerSocket sk;
    ObjectInputStream is;
    ObjectOutputStream os;
    VIP famoso;
    JsonVIP json;
    public static String VIPJson;
    
    public static HashMap<String, String> VIPLista;
    
    public VIPThread() {
        json = new JsonVIP();
        
    }
    
    public void crearFlujos(){
        try{
           is = new ObjectInputStream(socket.getInputStream());
           os= new ObjectOutputStream(socket.getOutputStream());

        }catch(IOException ex){
            Logger.getLogger(VIPThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void conectarConElServidor(){
        try {
            socket = new Socket(host,puerto);
        } catch (IOException ex) {
            Logger.getLogger(VIPThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(MensajeObject mensaje){     
        try {
            os= new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(mensaje);
           // os.newLine();
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(VIPThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run(){
        crearFlujos();
        
        
        while(true){
            MensajeObject opcion = notifyObserver();
            System.out.println(opcion.getComando());
            switch (opcion.getComando()){
                case "notificacion observador":
                    VIPJson = opcion.getObjeto();
                    VIPLista = json.obtenerHashMapObjetoJson(VIPJson);

                    break;
                default:
                    System.out.println("Comando no encontrado");
                    break;           
            }
        }
    }
    
    public void crearVIP(String nombre, String apellido1, String apellido2, String username){
        this.famoso = new VIP(nombre, apellido1, apellido2,username);    
    }

    public User getVIP() {
        return famoso;
    }

    public void setVIP(VIP subastador) {
        this.famoso = famoso;
    }
    public void saveVIP(){
        String objJson = json.establecerJson(famoso);
        MensajeObject objeto = new MensajeObject();
        objeto.setComando("Crear VIP");
        objeto.setKey(famoso.getUsername());
        objeto.setObjeto(objJson);
        objeto.setNombreAplcacion("RedSocial");
        enviarMensaje(objeto);
    }
    public void postearMensaje(String vipName,Mensaje m) {
        
        VIP v = (VIP)json.obtenerObjetoJson(VIPLista.get(vipName));
        v.postMessage(m);
        String s1 = json.establecerJson(v);
        MensajeObject objeto = new MensajeObject();
        objeto.setComando("Postear mensaje");
        objeto.setNombreAplcacion("RedSocial");
        objeto.setKey(v.getUsername());
        objeto.setObjeto(s1);
        enviarMensaje(objeto);
        
    }
    public ArrayList<Mensaje> verMensajes(String vipName) {
        VIP v = (VIP)json.obtenerObjetoJson(VIPLista.get(vipName));
        return v.getMensajes();
       
    }
    
    public void darDeBaja(String vipName){
        VIP v = (VIP)json.obtenerObjetoJson(VIPLista.get(vipName));
        v.setEstado(false); //inactivo
        String s1 = json.establecerJson(v);
        MensajeObject objeto = new MensajeObject();
        objeto.setComando("Postear mensaje");
        objeto.setNombreAplcacion("RedSocial");
        objeto.setKey(v.getUsername());
        objeto.setObjeto(s1);
        enviarMensaje(objeto);
    }
    
    public static void main(String[] args) throws Exception {
        VIPThread st = new VIPThread();
        st.conectarConElServidor();
        System.out.println("Conectado con éxito");
        st.start();
        VistaCrearVIP v= new VistaCrearVIP();
        ControllerVistaCrearVIP cv = new ControllerVistaCrearVIP(v,st); 
        v.setVisible(true);   
    }

    @Override
    public MensajeObject notifyObserver() {
        MensajeObject mensaje = new MensajeObject();
        try{
            mensaje = (MensajeObject) is.readObject();
            System.out.println("Si recibe mensaje: " + mensaje);
            return mensaje;
        }catch(IOException ex){
            Logger.getLogger(VIPThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VIPThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }
}
