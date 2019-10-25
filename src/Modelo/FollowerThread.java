/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import API.IObserver;
import API.MensajeObject;
import ControllerRedSocial.ControllerVistaCrearFollower;
import ControllerRedSocial.ControllerVistaPostear;
import ControllerRedSocial.ControllerVistaFollower;
import ControllerRedSocial.ControllerVistaVerMensajes;
import VistaFollower.VistaCrearFollower;
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
public class FollowerThread extends Thread implements IObserver,Serializable, Runnable{
    final int puerto = 8888;
    final String host = "127.0.0.1";
    Socket socket;
    ServerSocket sk;
    ObjectInputStream is;
    ObjectOutputStream os;
    Follower follower;
    JsonVIP jsonV;
    JsonFollower jsonF;
    ObjectOutputStream followerOS;
    public static String VIPJson;
    
    public static HashMap<String, String> VIPLista;
    
    public FollowerThread() {
        jsonV = new JsonVIP();
        jsonF = new JsonFollower();
        
    }
    
    public void crearFlujos(){
        try{
           is = new ObjectInputStream(socket.getInputStream());
           os= new ObjectOutputStream(socket.getOutputStream());

        }catch(IOException ex){
            Logger.getLogger(FollowerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void conectarConElServidor(){
        try {
            socket = new Socket(host,puerto);
        } catch (IOException ex) {
            Logger.getLogger(FollowerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(MensajeObject mensaje){     
        try {
            os= new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(mensaje);
           // os.newLine();
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(FollowerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run(){
        crearFlujos();
        
        
        while(true){
            MensajeObject opcion = notifyObserver();
            System.out.println(opcion.getComando());
            switch (opcion.getComando()){
                case "notificacion observador":
                    VIPJson = (String)opcion.getObjeto();
                    VIPLista = jsonV.obtenerHashMapObjetoJson(VIPJson);

                    break;
                case "actualizar follower":
                    followerOS = (ObjectOutputStream)opcion.getObjeto();
                default:
                    System.out.println("Comando no encontrado");
                    break;           
            }
        }
    }
    
    public void crearFollower(String nombre, String apellido1, String apellido2, String username){
        this.follower = new Follower(nombre, apellido1, apellido2,username);    
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(Follower subastador) {
        this.follower = follower;
    }
    public void saveFollower(){
        String objJson = jsonF.establecerJson(follower);
        MensajeObject objeto = new MensajeObject();
        objeto.setComando("Crear Follower");
        objeto.setKey(follower.getUsername());
        objeto.setObjeto(objJson);
        objeto.setNombreAplcacion("RedSocial");
        enviarMensaje(objeto);
    }
    public void seguirVIP(String vipID) {
        
        VIP v = (VIP)jsonV.obtenerObjetoJson(VIPLista.get(vipID));
        String objJson = jsonV.establecerJson(v);
        v.addFollower(followerOS);
        MensajeObject objeto = new MensajeObject();
        objeto.setComando("Seguir VIP");
        objeto.setNombreAplcacion("RedSocial");
        objeto.setKey(v.getUsername());
        objeto.setObjeto(objJson);
        enviarMensaje(objeto);
        
    }
    
    public static void main(String[] args) throws Exception {
        FollowerThread st = new FollowerThread();
        st.conectarConElServidor();
        System.out.println("Conectado con éxito");
        st.start();
        VistaCrearFollower v= new VistaCrearFollower();
        ControllerVistaCrearFollower cv = new ControllerVistaCrearFollower(v,st); 
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
            Logger.getLogger(FollowerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FollowerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }
}
