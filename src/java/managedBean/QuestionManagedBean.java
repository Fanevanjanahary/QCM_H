/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.QuestionSessionBean;
import entities.Question;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Named(value = "questionManagedBean")
@ViewScoped
public class QuestionManagedBean {

    @EJB
    private QuestionSessionBean questionSessionBean;
    private List<Question> listQuestion;

    public QuestionManagedBean() {
    }
    
    public void creerQuestion(Question q)
    {
        questionSessionBean.creerQuestion(q);
    }
    public List<Question> getQuestion()
    {
         if(listQuestion==null){
               listQuestion = questionSessionBean.findAll();
         }
        return listQuestion;
    }
    
    public void deleteQuestion(Question q){
        questionSessionBean.deleteQuestion(q);
    }
    
    
    
}
