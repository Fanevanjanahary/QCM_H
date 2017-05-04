/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.UtilisateurManager;
import entities.Personne;
import entities.Utilisateur;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;

/**
 *
 * @author madlord
 */
@Named(value = "etudiantMBean")
@ViewScoped
public class EtudiantMBean implements Serializable{

    /**
     * @return the etudiants
     */
    public List<Utilisateur> getEtudiants() {
        return etudiants;
    }

    /**
     * @param etudiants the etudiants to set
     */
    public void setEtudiants(List<Utilisateur> etudiants) {
        this.etudiants = etudiants;
    }
    
    @EJB
    private UtilisateurManager um;
    
    private List<Utilisateur> etudiants;

    /**
     * Creates a new instance of EtudiantMBean
     */
    public EtudiantMBean() {
    }
    
    
    @PostConstruct
    public void init(){
        setEtudiants(um.findStudent());
    }
    
}
