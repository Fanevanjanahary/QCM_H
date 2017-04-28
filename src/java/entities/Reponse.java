/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Entity
@Table(name = "REPONSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reponse.count", query = "SELECT count(r) FROM Reponse r"),
    @NamedQuery(name = "Reponse.findAll", query = "SELECT r FROM Reponse  r")}
)
public class Reponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String textIntro;
    @ManyToOne
    private Question question;
    Boolean statut;
    
    public Reponse() {
    }

    public Reponse(String textIntro, Question question, Boolean statut) {
        this.textIntro = textIntro;
        this.question = question;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getTextIntro() {
        return textIntro;
    }

    public void setTextIntro(String textIntro) {
        this.textIntro = textIntro;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
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
        if (!(object instanceof Reponse)) {
            return false;
        }
        Reponse other = (Reponse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
