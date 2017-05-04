/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.QuestionnaireManager;
import ejb.UtilisateurManager;
import entities.Questionnaire;
import entities.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author madlord
 */
@Named(value = "createQuestionnaire")
@RequestScoped
public class CreateQuestionnaire implements Serializable{


    @EJB
    private QuestionnaireManager qm;

    @EJB
    private UtilisateurManager um;

    private Questionnaire questionnaire;
    private Long idUtilisateur;
        private Long idQuestionnaire;

    private Utilisateur utilisateur;

    /**
     * Creates a new instance of CreateQuestionnaire
     */
    public CreateQuestionnaire() {
        utilisateur=new Utilisateur();
        questionnaire=new Questionnaire();
    }

    public String creer() {

        questionnaire.setDateCreation(new Date());
        questionnaire.setDateModification(new Date());
        questionnaire.setUtilisateur(utilisateur);
        System.out.println("managedBean.CreateQuestionnaire.creer()");
        qm.creerQuestionnaire(questionnaire);
        return "/teacher/questionnaires?faces-redirect=true&amp;includeViewParams=true";
    }

    public void init() {
        utilisateur = um.findById(new Long(11));
        if(idQuestionnaire!=null){
            questionnaire=qm.findById(idQuestionnaire);
            questionnaire.setId(null);
        }
    }

    /**
     * @return the questionnaire
     */
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    /**
     * @param questionnaire the questionnaire to set
     */
    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    /**
     * @return the idUtilisateur
     */
    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * @param idUtilisateur the idUtilisateur to set
     */
    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    
    
    /**
     * @return the idQuestionnaire
     */
    public Long getIdQuestionnaire() {
        return idQuestionnaire;
    }

    /**
     * @param idQuestionnaire the idQuestionnaire to set
     */
    public void setIdQuestionnaire(Long idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

}
