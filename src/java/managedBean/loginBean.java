/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.UtilisateurManager;
import entities.Utilisateur;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import util.Util;

/**
 *
 * @author madlord
 */
@Named(value = "login")
@RequestScoped
public class loginBean {

    private Utilisateur user;

    private String message;
    
    private Long idUser;

    @EJB
    UtilisateurManager um;
    
    

    /**
     * Creates a new instance of loginBean
     */
    public loginBean() {
        user = new Utilisateur();
        
    }

    public String login() {
        List<Utilisateur> res = um.find(user);
        if (res == null || res.size() == 0) {
            message = "Combinaison Login / Mot de passe incorrect.";
            return null;
        }
        user = res.get(0);
        if (user.isProfesseur()) {
            return "teacher/index?faces-redirect=true&amp;idUser=" + user.getId();
        }
        return "student/index?faces-redirect=true&amp;idUser=" + user.getId();
    }

    public void initUser() {
        //System.out.println("managedBean.loginBean.initUser()");
        //Util.addFlashInfoMessage("Je passe");
        //user = um.findById(idUser);       
    }
    
    public void test(){
        System.out.println("je passe");
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

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the idUser
     */
    public Long getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

}
