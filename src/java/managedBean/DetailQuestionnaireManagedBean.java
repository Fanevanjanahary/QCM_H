/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.MesQuestionsSessionBean;
import ejb.QuestionSessionBean;
import ejb.QuestionnaireSessionBean;
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
@Named(value = "detailQuestionnaireManagedBean")
@ViewScoped
public class DetailQuestionnaireManagedBean implements Serializable{

    private int id;
    private Questionnaire questionnaire;
    private List<Question> listQuestion;
    @EJB
    private QuestionnaireSessionBean questionnaireSessionBean;
    
    @EJB
    private QuestionSessionBean questionSessionBean;
    
    @EJB
    private MesQuestionsSessionBean mesQuestionsSessionBean;
    
    public DetailQuestionnaireManagedBean() {
    }
    
    public String upatdequestion()
    {
        questionnaire = questionnaireSessionBean.update(questionnaire);
        return "listQuestionnaire";
    }
    
    /** 
   * Retourne la liste des questions d'une questionnaire.
     * @return 
   */
    public List<Question> getListQuestion(){
        List<Mesquestions> lmesq = mesQuestionsSessionBean.getAll();
        for(Mesquestions mq:lmesq){
            if(mq.getQuestionnaire().getId()== id){
                listQuestion.add(mq.getQuestion());
            }
        }
        return listQuestion;
    }
    
}
