/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.QuestionManager;
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
 * @author ANDRIAMIADANTSOA
 */
@Named(value = "detailQuestionMBean")
@ViewScoped
public class DetailQuestionMBean implements Serializable{
    private int id;
    private Question question;
    List<Reponse> listReponse;
    @EJB
    private ReponseManager reponseManager;

    @EJB
    private QuestionManager questionManager;
    
    /** 
   * Retourne la liste des reponse d'une question.
     * @return 
   */
    public List<Reponse> getReponses() {  
      for(Reponse rep:reponseManager.findAll()) {
        if(rep.getQuestion().getId()==id){
            listReponse.add(rep);
        }
           }
      return listReponse;
    }
    
    /* update une reponse d'une question */
    public String updateReponse(int id)
    {
        reponseManager.update(listReponse.get(id));
        return "listReponse";
    }
    
    public DetailQuestionMBean() {
    }
    
    public String upatdequestion()
    {
        question = questionManager.udpade(question);
        return "listQuestion";
    }
    
}
