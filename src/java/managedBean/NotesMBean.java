/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.NotesManager;
import entities.Notes;
import entities.Questionnaire;
import entities.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Proprietaire
 */
@Named(value = "notesMBean")
@ViewScoped
public class NotesMBean implements Serializable {

    private List<Notes> notesList;
    @EJB
    private NotesManager notesManager;

    /**
     * Creates a new instance of NotesManagedBean
     */
    public NotesMBean() {
    }
    
    /**
     * Méthode pour avoir toutes les notes
     * @return 
     */
    public List<Notes> getNotes(){
        if(notesList==null)
            notesList = notesManager.findAll();
        return notesList;
    }
}
