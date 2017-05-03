/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.NotesManager;
import ejb.UtilisateurManager;
import entities.Notes;
import entities.Utilisateur;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author madlord
 */
@Named(value = "detailEtudiantMBean")
@RequestScoped
public class DetailEtudiantMBean implements Serializable{

    /**
     * @return the listeNotes
     */
    public List<Notes> getListeNotes() {
        return listeNotes;
    }

    /**
     * @param listeNotes the listeNotes to set
     */
    public void setListeNotes(List<Notes> listeNotes) {
        this.listeNotes = listeNotes;
    }

    /**
     * @return the idEtudiant
     */
    public Long getIdEtudiant() {
        return idEtudiant;
    }

    /**
     * @param idEtudiant the idEtudiant to set
     */
    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    /**
     * @return the u
     */
    public Utilisateur getU() {
        return u;
    }

    /**
     * @param u the u to set
     */
    public void setU(Utilisateur u) {
        this.u = u;
    }
    
    @EJB
    private UtilisateurManager um;
    
    @EJB
    private NotesManager nm;
    
    private Long idEtudiant;
    private Utilisateur u;
    private List<Notes> listeNotes;

    /**
     * Creates a new instance of DetailEtudiantMBean
     */
    public DetailEtudiantMBean() {
    }
    
    public void init(){
        setU(um.findById(getIdEtudiant()));
        setListeNotes(nm.findByUtilisateur(u));
    }
    
}
