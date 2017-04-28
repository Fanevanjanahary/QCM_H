/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Proprietaire
 */
@Entity
@Table(name="MESQUESTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesquestions.findAll", query = "SELECT m FROM Mesquestions m"),
    @NamedQuery(name = "Mesquestions.count", query = "SELECT count(m) FROM Mesquestions m")}
)
public class Mesquestions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Questionnaire questionnaire;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Question question;

    public Mesquestions() {
    }

    public Mesquestions(Questionnaire questionnaire, Question question) {
        this.questionnaire = questionnaire;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
