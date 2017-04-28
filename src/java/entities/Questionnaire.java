/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Entity
@Table(name = "QUESTIONNAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questionnaire.findAll", query = "SELECT q FROM Questionnaire  q"),
    @NamedQuery(name = "Questionnaire.count", query = "SELECT count(c) FROM Questionnaire c")
})
public class Questionnaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private String textIntro;
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    private String mode;
    private  String motCle;
    @OneToMany(mappedBy = "questionnaire",fetch = FetchType.LAZY)
    private List<Notes> lesNotes;
    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "questionnaire", fetch = FetchType.EAGER)
    private List<Mesquestions> listMesquestions;

    public Questionnaire() {
    }

    public Questionnaire(Date dateCreation, String textIntro, Date dateModification, String mode, String motCle, Utilisateur utilisateur, List<Mesquestions> listMesquestions, List<Notes> lesNotes) {
        this.dateCreation = dateCreation;
        this.textIntro = textIntro;
        this.dateModification = dateModification;
        this.mode = mode;
        this.motCle = motCle;
        this.lesNotes = lesNotes;
        this.utilisateur = utilisateur;
        this.listMesquestions = listMesquestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTextIntro() {
        return textIntro;
    }

    public void setTextIntro(String textIntro) {
        this.textIntro = textIntro;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Notes> getLesNotes() {
        return lesNotes;
    }

    public void setLesNotes(List<Notes> lesNotes) {
        this.lesNotes = lesNotes;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Mesquestions> getListMesquestions() {
        return listMesquestions;
    }

    public void setListMesquestions(List<Mesquestions> listMesquestions) {
        this.listMesquestions = listMesquestions;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionnaire)) {
            return false;
        }
        Questionnaire other = (Questionnaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
    
}
