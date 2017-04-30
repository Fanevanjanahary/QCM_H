/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Entity
@Table(name = "QUESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.count", query = "SELECT count(q) FROM Question q"),
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")}
)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer note;
    private String textIntro;
    private String motCle;
    
    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
    private List<Reponse> lesReponses;
    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    private List<Mesquestions> listMesquestions;
    
    public Question(){
        lesReponses=new ArrayList<Reponse>();
    }

    public Question(Integer note, String textIntro, String motCle, List<Reponse> lesReponses, List<Mesquestions> listMesquestions) {
        this.note = note;
        this.textIntro = textIntro;
        this.motCle = motCle;
        this.lesReponses = (lesReponses!=null)?lesReponses:new ArrayList<Reponse>();
        this.listMesquestions = listMesquestions;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getTextIntro() {
        return textIntro;
    }

    public void setTextIntro(String textIntro) {
        this.textIntro = textIntro;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Reponse> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(List<Reponse> lesReponses) {
        this.lesReponses = lesReponses;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdbs.qcm_h.modele.Question[ id=" + id + " ]";
    }
    
}
