/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

/**
 *
 * @author derec
 */
public class Mensaje {
    private String contenido;
    private int likes;
    private int dislikes;
    
    public Mensaje(String content){
        this.contenido = content;
        this.likes = 0;
        this.dislikes =0;
    }
    
    public void setContenido(String cont){
        this.contenido = cont;
    }
    public String getContenido(){
        return this.contenido;
    }
    public void addLike(){
        this.likes = this.likes+=1;
    }
    public void addDislikes(){
        this.dislikes = this.dislikes+=1;
    }
}
