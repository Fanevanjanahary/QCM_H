/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.ReponseManager;
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
@Named(value = "reponseMBean")
@ViewScoped
public class ReponseMBean implements Serializable {
    
    private List<Reponse> reponseList;
    @EJB
    private ReponseManager reponseManager;

    /**
     * Creates a new instance of ReponseManagedBean
     */
    public ReponseMBean() {
    }
    
    /**
     * Méthode pour avoir toutes les Reponse
     * @return 
     */
    public List<Reponse> getReponse(){
        if(reponseList==null)
            reponseList = reponseManager.findAll();
        
        return reponseList;
    }
    
}
