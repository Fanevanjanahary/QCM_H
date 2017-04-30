/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.Utilisateur;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author madlord
 */
@Named(value = "login")
@RequestScoped
public class loginBean {
    private Utilisateur user;
    
    /**
     * Creates a new instance of loginBean
     */
    public loginBean() {
        user=new Utilisateur();        
    }
    
    public String login(){
        return "test?login="+user.getNomUtilisateur()+"&mdp="+user.getMotDepasse();
    }

    /**
     * @return the user
     */
    public Utilisateur getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
}
