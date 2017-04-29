/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.GestionnaireNote;
import entities.Notes;
import entities.Questionnaire;
import entities.Reponse;
import entities.Utilisateur;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Proprietaire
 */
@Named(value = "notesManagedBean")
@ViewScoped
public class NotesManagedBean implements InterfaceManagedBean {

    private Long id;
    private int note;
    private Date date;
    private Long id_utilisateur;
    private Long id_questionnaire;
    @EJB
    private GestionnaireNote gestionnaireNote;

    /**
     * Creates a new instance of NotesManagedBean
     */
    public NotesManagedBean() {
    }
    
    /**
     * Méthode pour avoir toutes les notes
     * @return 
     */
    public List<Notes> getNotes(){
        return gestionnaireNote.findAll();
    }
    
    /**
     * Méthode pour insérer une note
     * @return 
     */
    @Override
    public String inserer(){
        Notes _notes = new Notes(note, date, new Utilisateur(id_utilisateur), new Questionnaire(id_questionnaire));
        gestionnaireNote.creerNotes(_notes);
        
        return "";
    }
    
    /**
     * Méthode pour modifier une note
     * @return 
     */
    @Override
    public String modifier(){
        Notes _notes = new Notes(note, date, new Utilisateur(id_utilisateur), new Questionnaire(id_questionnaire));
        gestionnaireNote.udpade(_notes);
        
        return "";
    }
    
    /**
     * Méthode pour supprimer une note
     * @return 
     */
    @Override
    public String supprimer(){
        Notes reponse = gestionnaireNote.findById(id);
        gestionnaireNote.delete(reponse);
        
        return "";
    }
}
