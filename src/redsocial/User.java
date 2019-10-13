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
public class User {
    private String username;
    private String ip;
    
    
    public void setUsername(String user){this.username = user;}
    public String getUsername(){return this.username;}
    public void setIp(String ip){this.ip = ip;}
    public String getIp(){return this.ip;}
}
