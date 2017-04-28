/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.NoteSessionBean;
import ejb.QuestionnaireSessionBean;
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
@Named(value = "questionnaireManagedBean")
@ViewScoped
public class QuestionnaireManagedBean implements Serializable{

    private List<Questionnaire> listQuestionnaire;
    @EJB
    private QuestionnaireSessionBean questionnaireSessionBean;
    @EJB
    private NoteSessionBean noteSessionBean;
    

    public QuestionnaireManagedBean() {
    }
    
    public List<Questionnaire> getQuestionnaire(){
        if(listQuestionnaire == null){
            listQuestionnaire = questionnaireSessionBean.getAllQuestionnaire();
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
                questionnaireSessionBean.deleteQuestionnaire(q);
            }
            throw new Exception("Cet questionnaire ne pas effacer");
        
    }
    
    
    
}
