/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

import java.util.ArrayList;

/**
 *
 * @author derec
 */
public class Follower extends User {
    private ArrayList <VIP> followed;
    
    public Follower(String username,String IP){
        setUsername(username);
        setIp(IP);
        this.followed = new ArrayList<>();
    }
    
}
