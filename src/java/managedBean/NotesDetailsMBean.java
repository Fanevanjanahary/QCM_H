/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.NotesManager;
import entities.Notes;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author T7
 *
 * Backing bean pour la page CustomerDetails.xhtml.
 */
@Named(value = "customerDetailsMBean")
@ViewScoped
public class NotesDetailsMBean implements Serializable {

    private Long id;
    private Notes notes;
    @EJB
    private NotesManager notesManager;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Renvoie les details de la note selectionnée
     * @return 
     */
    public Notes getDetails() {
        return notes;
    }

    /**
     * Charge la note avec l'id reçu
     */
    public void loadNote() {
        this.notes = notesManager.findById(id);
    }
    
    /**
     * Méthode pour supprimer une note
     * @return 
     */
    public String supprimer(){
        Notes reponse = notesManager.findById(id);
        notesManager.delete(reponse);
        
        return "";
    }
}

/**
 * Mise à jour d'une note
 * @return 
 **
public String update() {
    notes = notesManager.udpade(notes);

    return "NotesList";
}
*/