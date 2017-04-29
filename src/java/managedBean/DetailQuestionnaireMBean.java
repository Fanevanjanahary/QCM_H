/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.MesQuestionsManager;
import ejb.QuestionManager;
import ejb.QuestionnaireManager;
import entities.Mesquestions;
import entities.Question;
import entities.Questionnaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Named(value = "detailQuestionnaireMBean")
@ViewScoped
public class DetailQuestionnaireMBean implements Serializable{

    private int id;
    private Questionnaire questionnaire;
    private List<Question> listQuestion;
    @EJB
    private QuestionnaireManager questionnaireManager;
    
    @EJB
    private QuestionManager questionManager;
    
    @EJB
    private MesQuestionsManager mesQuestionsManager;
    
    public DetailQuestionnaireMBean() {
    }
    
    public String upatdequestion()
    {
        questionnaire = questionnaireManager.update(questionnaire);
        return "listQuestionnaire";
    }
    
    /** 
   * Retourne la liste des questions d'une questionnaire.
     * @return 
   */
    public List<Question> getListQuestion(){
        List<Mesquestions> lmesq = mesQuestionsManager.getAll();
        for(Mesquestions mq:lmesq){
            if(mq.getQuestionnaire().getId()== id){
                listQuestion.add(mq.getQuestion());
            }
        }
        return listQuestion;
    }
    
}
