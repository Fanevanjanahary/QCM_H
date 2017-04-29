/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.NotesManager;
import ejb.QuestionnaireManager;
import entities.Notes;
import entities.Questionnaire;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Named(value = "questionnaireMBean")
@ViewScoped
public class QuestionnaireMBean implements Serializable{

    private Long id;
    private List<Questionnaire> listQuestionnaire;
    @EJB
    private QuestionnaireManager questionnaireManager;
    @EJB
    private NotesManager noteSessionBean;
    private String motCle;
    private Long copieId;
    

    public QuestionnaireMBean() {
    }
    
    public List<Questionnaire> getQuestionnaire(){
        if(listQuestionnaire == null){
            listQuestionnaire = questionnaireManager.getAllQuestionnaire();
        }
        return listQuestionnaire;
    }
    
    /* tester si le questionnaire n'est pas n'est pas encore repondu*/
    public boolean estRepondu(Questionnaire q){
        for(Notes n: noteSessionBean.findAll())
        { 
            if(Objects.equals(n.getQuestionnaire().getId(), q.getId())){
                return true;
            }
        }
        return false;
    }
    
    public void deleteQuestionnaire(Questionnaire q) throws Exception{
        
        if(estRepondu(q)==false){
                questionnaireManager.deleteQuestionnaire(q);
            }
            throw new Exception("Cet questionnaire ne pas effacer");        
    }
    
    /**
     * Méthode pour copier un questionnaire
     * @return 
     */
    public String copierQuestionnaire(){
        return "copieId=" + copieId + "&amp;faces-redirect=true";
    }
    
    /**
     * Méthode pour récupérer la copie
     * @return 
     */
    public Questionnaire getCopie(){
        return questionnaireManager.findById(copieId);
    }
    
    /**
     * Méthode pour rechercher un questionnaire par un ou plusieurs mot clé
     * @return 
     */
    public List<Questionnaire> recherche(){
        String[] mots = motCle.split(" ");
        
        return questionnaireManager.find(mots);       
    }
}
