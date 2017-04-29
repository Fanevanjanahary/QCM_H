/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.QuestionSessionBean;
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
 * @author ANDRIAMIADANTSOA
 */
@Named(value = "detailQuestionManagedBean")
@ViewScoped
public class DetailQuestionManagedBean implements Serializable{
    private int id;
    private Question question;
    List<Reponse> listReponse;
    @EJB
    private GestionnaireReponse reponseSessionBean;

    @EJB
    private QuestionSessionBean questionSessionBean;
    

    
    public DetailQuestionManagedBean() {
    }
    
    public String upatdequestion()
    {
        question = questionSessionBean.udpade(question);
        return "listQuestion";
    }
    
    /** 
   * Retourne la liste des reponse d'une question.
     * @return 
   */
    public List<Reponse> getReponses() {  
      for(Reponse rep:reponseSessionBean.findAll()) {
        if(rep.getQuestion().getId()==id){
            listReponse.add(rep);
        }
           }
      return listReponse;
    }
    
    /* update une reponse d'une question */
    public String updateReponse(int id)
    {
        reponseSessionBean.update(listReponse.get(id));
        return "listReponse";
    }
    
}
