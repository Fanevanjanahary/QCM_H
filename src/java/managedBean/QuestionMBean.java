/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.QuestionManager;
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
@Named(value = "questionMBean")
@ViewScoped
public class QuestionMBean implements Serializable{
    private String motCle;
    private List<Question> listQuestion;
    @EJB
    private QuestionManager questionManager;

    public QuestionMBean() {
    }
    
    public void creerQuestion(Question q)
    {
        questionManager.creerQuestion(q);
    }
    public List<Question> getQuestion()
    {
         if(listQuestion==null){
               listQuestion = questionManager.findAll();
         }
        return listQuestion;
    }
    
    public void deleteQuestion(Question q){
        questionManager.deleteQuestion(q);
    }
    
    /**
     * Méthode pour rechercher un question par un ou plusieurs mot clé
     * @return 
     */
    public List<Questionnaire> recherche(){
        String[] mots = motCle.split(" ");
        return questionManager.find(mots);       
    }
}
