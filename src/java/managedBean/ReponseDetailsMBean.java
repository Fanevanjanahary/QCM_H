/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.ReponseManager;
import entities.Reponse;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author T7
 *
 * Backing bean pour la page CustomerDetails.xhtml.
 */
@Named(value = "reponseDetailsMBean")
@ViewScoped
public class ReponseDetailsMBean implements Serializable {

    private Long id;
    private Reponse reponse;
    @EJB
    private ReponseManager reponseManager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Renvoie les details de la reponse selectionnée
     * @return 
     */
    public Reponse getDetails() {
        return reponse;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }

    /**
     * Charge la reponse avec l'id reçu
     */
    public void loadReponse() {
        this.reponse = reponseManager.findById(id);
    }
    
    /**
     * Méthode pour insérer une Reponse
     * @return 
     */
    public String inserer() {
        // Reponse reponse = new Reponse(textIntro, question, statut);
        reponseManager.creerReponse(reponse);
        
        return "";
    }
    
    /**
     * Méthode pour modifier une Reponse
     * @return 
     */
    public String modifier() {
        // Reponse reponse = new Reponse(textIntro, question, statut);
        reponseManager.update(reponse);
        
        return "";
    }

    /**
     * Méthode pour supprimer une Reponse
     * @return 
     */
    public String supprimer() {
        // Reponse reponse = reponseManager.findById(id);
        reponseManager.delete(reponse);
        
        return "";
    }
}