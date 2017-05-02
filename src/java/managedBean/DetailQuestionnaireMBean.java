/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.MesQuestionsManager;
import ejb.NotesManager;
import ejb.QuestionManager;
import ejb.QuestionnaireManager;
import ejb.ReponseManager;
import ejb.UtilisateurManager;
import entities.Mesquestions;
import entities.Notes;
import entities.Question;
import entities.Questionnaire;
import entities.Reponse;
import entities.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import util.Util;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Named(value = "detailQuestionnaireMBean")
@ViewScoped
public class DetailQuestionnaireMBean implements Serializable{

    /**
     * @return the idUser
     */
    public Long getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the reponseConverter
     */
    public Converter getReponseConverter() {
        return reponseConverter;
    }

    /**
     * @param reponseConverter the reponseConverter to set
     */
    public void setReponseConverter(Converter reponseConverter) {
        this.reponseConverter = reponseConverter;
    }

    private Long id;
    private Long idUser;
    private Questionnaire questionnaire;
    private List<Question> listQuestion;
    @EJB
    private QuestionnaireManager questionnaireManager;
    
    @EJB
    private QuestionManager questionManager;
    
    @EJB
    private MesQuestionsManager mesQuestionsManager;
    
    @EJB
    private ReponseManager reponseManager;
    
    @EJB
    private NotesManager nm;
    
    @EJB
    UtilisateurManager um;
    
    private Reponse[] reponses;
    
    private Converter reponseConverter = new Converter() {
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return reponseManager.findById(Long.decode(value));
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            Reponse cb = (Reponse) value;
            return cb.getId().toString();
        }
    };
    
    public DetailQuestionnaireMBean() {
    }
    public void initQuestionnaire(){
        setQuestionnaire(questionnaireManager.findById(getId()));
        setReponses(new Reponse[questionnaire.getListMesquestions().size()]);
        for(int i=0; i< getReponses().length;i++){
            getReponses()[i]=new Reponse();
        }
    }
    
    public String soumettre(){
        int note=0;
        int max=0;
        for(int i=0;i<reponses.length;i++)
        {
            int temp=reponses[i].getQuestion().getNote();
            max+=temp;
            note=(reponses[i].getStatut())?note+temp:note;
        }
        note=20*note/max;
        Utilisateur u;
        u = um.findById(idUser);
        Notes n=new Notes(note, new Date(), u, questionnaire);
        nm.creerNotes(n);
        Util.addFlashInfoMessage("Vous avez passé le quizz '"+questionnaire.getTextIntro()+"' avec une note de "+note+"/20.");
        return "/student/index?faces-redirect=true&amp;idUser=" + u.getId();
    }
    
    public String upatdequestion()
    {
        setQuestionnaire(questionnaireManager.update(getQuestionnaire()));
        return "listQuestionnaire";
    }
    
    /** 
   * Retourne la liste des questions d'une questionnaire.
     * @return 
   */
    public List<Question> getListQuestion(){
        List<Mesquestions> lmesq = mesQuestionsManager.getAll();
        for(Mesquestions mq:lmesq){
            if(mq.getQuestionnaire().getId()== getId()){
                listQuestion.add(mq.getQuestion());
            }
        }
        return listQuestion;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the reponses
     */
    public Reponse[] getReponses() {
        return reponses;
    }

    /**
     * @param reponses the reponses to set
     */
    public void setReponses(Reponse[] reponses) {
        this.reponses = reponses;
    }
    
}
