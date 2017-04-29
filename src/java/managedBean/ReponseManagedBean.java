/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.GestionnaireReponse;
import entities.Question;
import entities.Reponse;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Proprietaire
 */
@Named(value = "reponseManagedBean")
@ViewScoped
public class ReponseManagedBean implements Serializable, InterfaceManagedBean {
    private Long id;
    private String textIntro;
    private Question question;
    private Boolean statut;
    @EJB
    private GestionnaireReponse gestionnaireReponse;

    /**
     * Creates a new instance of ReponseManagedBean
     */
    public ReponseManagedBean() {
    }
    
    /**
     * Méthode pour avoir toutes les Reponse
     * @return 
     */
    public List<Reponse> getReponse(){
        return gestionnaireReponse.findAll();
    }
    
    /**
     * Méthode pour insérer une Reponse
     * @return 
     */
    @Override
    public String inserer() {
        Reponse reponse = new Reponse(textIntro, question, statut);
        gestionnaireReponse.creerReponse(reponse);
        
        return "";
    }

    
    /**
     * Méthode pour modifier une Reponse
     * @return 
     */
    @Override
    public String modifier() {
        Reponse reponse = new Reponse(textIntro, question, statut);
        gestionnaireReponse.update(reponse);
        
        return "";
    }

    
    /**
     * Méthode pour supprimer une Reponse
     * @return 
     */
    @Override
    public String supprimer() {
        Reponse reponse = gestionnaireReponse.findById(id);
        gestionnaireReponse.delete(reponse);
        
        return "";
    }
    
}
