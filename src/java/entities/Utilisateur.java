/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Entity
@Table(name = "UTILISATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.count", query = "SELECT count(u) FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.find", query = "SELECT u FROM Utilisateur u WHERE u.nomUtilisateur = :utilisateur AND u.motDepasse = :motDePasse")}
)
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomUtilisateur;
    private String motDepasse;
    
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.PERSIST)
    private List<Questionnaire> lesQuestionnaires;
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.PERSIST)
    private List<Notes> lesNotes;
    @OneToOne(mappedBy="utilisateur", cascade = CascadeType.PERSIST)
    private Personne personne;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur() {
    }

    public Utilisateur(String nomUtilisateur, String motDepasse, Personne personne, List<Questionnaire> lesQuestionnaires, List<Notes> lesNotes) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDepasse = motDepasse;
        this.personne = personne;
        this.lesQuestionnaires = lesQuestionnaires;
        this.lesNotes = lesNotes;
    }
    
    public Boolean isProfesseur(){
        return false;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDepasse() {
        return motDepasse;
    }

    public void setMotDepasse(String motDepasse) {
        this.motDepasse = motDepasse;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
        // personne.setUtilisateur(this);
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
    
}
