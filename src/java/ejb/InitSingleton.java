/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Mesquestions;
import entities.Notes;
import entities.Personne;
import entities.Question;
import entities.Questionnaire;
import entities.Reponse;
import entities.Utilisateur;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Proprietaire
 */
@Startup
@LocalBean
@Singleton
public class InitSingleton {

    @PersistenceContext(unitName = "QCM_HPU")
    private EntityManager em;
    
    @PostConstruct
    public void chargerLesDonnees()
    {
        if(nbrEnregistrement(Personne.class.getSimpleName()) == 0){;
            Personne p1 = new Personne("Richard", "Grin", null);
            Personne p2 = new Personne("ANDRIAMIADANTSOA", "Fanevanjanahary", null);
            Personne p3 = new Personne("ASSANY", "Ylias", null);
            Personne p4 = new Personne("ANDRIAMIADANTSOA", "Fanevanjanahary", null);
            Personne p5 = new Personne("Michel", "Buffa", null);
            
            Utilisateur u1 = new Utilisateur("richard", "richard", p1, null, null);
            Utilisateur u2 = new Utilisateur("faneva", "faneva", p2, null, null);
            Utilisateur u3 = new Utilisateur("andry", "andry", p3, null, null);
            Utilisateur u4 = new Utilisateur("ylias", "ylias", p4, null, null);
            Utilisateur u5 = new Utilisateur("michel", "michel", p5, null, null);
            
             Question q1_1 = new Question(2, "Combien de couches au moins dans une application Java EE ?", "JEE", null, null);
              Reponse r11_1 = new Reponse("Vrai", q1_1, Boolean.TRUE);
              Reponse r11_2 = new Reponse("Faux", q1_1, Boolean.FALSE);
             Question q1_2 = new Question(2, "Une application Java EE ne peut pas fonctionner sans", "JEE", null, null);
              Reponse r12_1 = new Reponse("Vrai", q1_2, Boolean.TRUE);
              Reponse r12_2 = new Reponse("Faux", q1_2, Boolean.FALSE);
             Question q1_3 = new Question(2, "Java EE", "JEE", null, null);
              Reponse r13_1 = new Reponse("La page JSF pour laquelle l’EJB effectue un traitement", q1_3, Boolean.TRUE);
              Reponse r13_2 = new Reponse("L’interface Java implémentée par l’EJB", q1_3, Boolean.FALSE);
             Question q1_4 = new Question(2, "Un container", "container", null, null);
              Reponse r14_1 = new Reponse("La page JSF pour laquelle l’EJB effectue un traitement", q1_4, Boolean.TRUE);
              Reponse r14_2 = new Reponse("L’interface Java implémentée par l’EJB", q1_4, Boolean.FALSE);
             Question q1_5 = new Question(2, "Que ne peut pas faire un container EJB", "EJB", null, null);
              Reponse r15_1 = new Reponse("La page JSF pour laquelle l’EJB effectue un traitement", q1_5, Boolean.TRUE);
              Reponse r15_2 = new Reponse("L’interface Java implémentée par l’EJB", q1_5, Boolean.FALSE);
             List<Question> lq1 = new ArrayList<>();
              lq1.add(q1_1); lq1.add(q1_2); lq1.add(q1_3); lq1.add(q1_4); lq1.add(q1_5);
            Questionnaire q1 = new Questionnaire(new Date(), "Quizz Introduction", null, "Apprentissage", "Quizz/Introduction", u1, null, null);
            
            Mesquestions mq_11 = new Mesquestions(q1, q1_1);
            Mesquestions mq_12 = new Mesquestions(q1, q1_2);
            Mesquestions mq_13 = new Mesquestions(q1, q1_3);
            Mesquestions mq_14 = new Mesquestions(q1, q1_4);
            Mesquestions mq_15 = new Mesquestions(q1, q1_5);
             List<Mesquestions> lmq1 = new ArrayList<>();
              lmq1.add(mq_11); lmq1.add(mq_12); lmq1.add(mq_13); lmq1.add(mq_14); lmq1.add(mq_15);
            q1.setListMesquestions(lmq1);
            
             Question q2_1 = new Question(2, "Si on change de serveur d’application Java EE il faut récrire une petite partie des EJB", "EJB/JEE", null, null);
              Reponse r21_1 = new Reponse("Vrai", q2_1, Boolean.TRUE);
              Reponse r21_2 = new Reponse("Faux", q2_1, Boolean.FALSE);
             Question q2_2 = new Question(2, "Les EJB sont appelés directement par les pages JSF pour effectuer les traitements liés à l’interface utilisateur", "EJB/JSF", null, null);
              Reponse r22_1 = new Reponse("Vrai", q2_2, Boolean.TRUE);
              Reponse r22_2 = new Reponse("Faux", q2_2, Boolean.FALSE);
             Question q2_3 = new Question(2, "Ce qu’on appelle interface d’un EJB c’est", "EJB/interface", null, null);
              Reponse r23_1 = new Reponse("La page JSF pour laquelle l’EJB effectue un traitement", q2_3, Boolean.TRUE);
              Reponse r23_2 = new Reponse("L’interface Java implémentée par l’EJB", q2_3, Boolean.FALSE);
             Question q2_4 = new Question(2, "", "", null, null);
              Reponse r24_1 = new Reponse("La page JSF pour laquelle l’EJB effectue un traitement", q2_4, Boolean.TRUE);
              Reponse r24_2 = new Reponse("L’interface Java implémentée par l’EJB", q2_4, Boolean.FALSE);
             Question q2_5 = new Question(2, "", "", null, null);
              Reponse r25_1 = new Reponse("La page JSF pour laquelle l’EJB effectue un traitement", q2_5, Boolean.TRUE);
              Reponse r25_2 = new Reponse("L’interface Java implémentée par l’EJB", q2_5, Boolean.FALSE);
             List<Question> lq2 = new ArrayList<>();
              lq2.add(q2_1); lq2.add(q2_2); lq2.add(q2_3); lq2.add(q2_4); lq2.add(q2_5);
            Questionnaire q2 = new Questionnaire(new Date(), "Examen EJB", null, "Examen", "Examen/EJB", u2, null, null);
            
            Mesquestions mq_21 = new Mesquestions(q2, q2_1);
            Mesquestions mq_22 = new Mesquestions(q2, q2_2);
            Mesquestions mq_23 = new Mesquestions(q2, q2_3);
            Mesquestions mq_24 = new Mesquestions(q2, q2_4);
            Mesquestions mq_25 = new Mesquestions(q2, q2_5);
             List<Mesquestions> lmq2 = new ArrayList<>();
              lmq2.add(mq_21); lmq2.add(mq_22); lmq2.add(mq_23); lmq2.add(mq_24); lmq2.add(mq_25);
            q2.setListMesquestions(lmq2);
            
             Question q3_1 = new Question(2, "JSF signifie", "JSF", null, null);
              Reponse r31_1 = new Reponse("Java Server Framework", q3_1, Boolean.FALSE);
              Reponse r31_2 = new Reponse("Java Server Faces", q3_1, Boolean.TRUE);
             Question q3_2 = new Question(2, "Une page JSF est représentée sur le serveur par des classes Java", "JSF/Java", null, null);
              Reponse r32_1 = new Reponse("Vrai", q3_2, Boolean.FALSE);
              Reponse r32_2 = new Reponse("Faux", q3_2, Boolean.TRUE);
             Question q3_3 = new Question(2, "Un backing bean peut contenir", "backing/bean", null, null);
              Reponse r33_1 = new Reponse("Des valeurs affichées sur le navigateur dans une page HTML", q3_3, Boolean.FALSE);
              Reponse r33_2 = new Reponse("Des méthodes qui sont exécutées quand l’utilisateur clique sur un bouton", q3_3, Boolean.TRUE);
              Reponse r33_3 = new Reponse("Des valeurs présentées à l’utilisateur dans une liste de choix", q3_3, Boolean.FALSE);
             Question q3_4 = new Question(2, "L’interface avec une base de données est plutôt faite par", "base de données", null, null);
              Reponse r34_1 = new Reponse("Un ou plusieurs backing beans", q3_4, Boolean.FALSE);
              Reponse r34_2 = new Reponse("Un ou plusieurs EJB", q3_4, Boolean.FALSE);
              Reponse r34_3 = new Reponse("Une ou plusieurs classes Java ordinaires", q3_4, Boolean.TRUE);
             Question q3_5 = new Question(2, "Où peut-on rencontrer ce genre de code : #{utilisateur.nom}", "code", null, null);
              Reponse r35_1 = new Reponse("Dans un backing bean", q3_5, Boolean.FALSE);
              Reponse r35_2 = new Reponse("Dans une page JSF", q3_5, Boolean.TRUE);
              Reponse r35_3 = new Reponse("Dans un EJB", q3_5, Boolean.FALSE);
             List<Question> lq3 = new ArrayList<>();
              lq3.add(q3_1); lq3.add(q3_2); lq3.add(q3_3); lq3.add(q3_4); lq3.add(q3_5);              
            Questionnaire q3 = new Questionnaire(new Date(), "Apprentissage JSF", null, "Apprentissage", "Apprentissage/JSF", u3, null, null);
            
            Mesquestions mq_31 = new Mesquestions(q3, q3_1);
            Mesquestions mq_32 = new Mesquestions(q3, q3_2);
            Mesquestions mq_33 = new Mesquestions(q3, q3_3);
            Mesquestions mq_34 = new Mesquestions(q3, q3_4);
            Mesquestions mq_35 = new Mesquestions(q3, q3_5);
             List<Mesquestions> lmq3 = new ArrayList<>();
              lmq3.add(mq_31); lmq3.add(mq_32); lmq3.add(mq_33); lmq3.add(mq_34); lmq3.add(mq_35);
            q3.setListMesquestions(lmq3);
            
             Question q4_1 = new Question(2, "JPA est une spécification pour la persistance des objets Java dans tous les types de base de données ?", "JPA/Java", null, null);
              Reponse r41_1 = new Reponse("Vrai", q4_1, Boolean.TRUE);
              Reponse r41_2 = new Reponse("Faux", q4_1, Boolean.FALSE);
             Question q4_2 = new Question(2, "JPA est construit au-dessus de JDBC", "JPA/JDBC", null, null);
              Reponse r42_1 = new Reponse("Vrai", q4_2, Boolean.TRUE);
              Reponse r42_2 = new Reponse("Faux", q4_2, Boolean.FALSE);
             Question q4_3 = new Question(2, "JPA peut être utilisé en dehors de Java EE", "JPA/JAVA EE", null, null);
              Reponse r43_1 = new Reponse("Vrai", q4_3, Boolean.TRUE);
              Reponse r43_2 = new Reponse("Faux", q4_3, Boolean.FALSE);
             Question q4_4 = new Question(2, "Toutes les instances d’entités sont automatiquement sauvegardées dans la base de données", "instances/base de données", null, null);
              Reponse r44_1 = new Reponse("Vrai", q4_4, Boolean.TRUE);
              Reponse r44_2 = new Reponse("Faux", q4_4, Boolean.FALSE);
             Question q4_5 = new Question(2, "Toutes les classes Java annotées avec @Entity sont des entités", "Java/Entity", null, null);
              Reponse r45_1 = new Reponse("Vrai", q4_5, Boolean.TRUE);
              Reponse r45_2 = new Reponse("Faux", q4_5, Boolean.FALSE);
             List<Question> lq4 = new ArrayList<>();
              lq4.add(q4_1); lq4.add(q4_2); lq4.add(q4_3); lq4.add(q4_4); lq4.add(q4_5);
            Questionnaire q4 = new Questionnaire(new Date(), "Examen JPA", null, "Examen", "Examen/JPA", u4, null, null);
            
            Mesquestions mq_41 = new Mesquestions(q4, q4_1);
            Mesquestions mq_42 = new Mesquestions(q4, q4_2);
            Mesquestions mq_43 = new Mesquestions(q4, q4_3);
            Mesquestions mq_44 = new Mesquestions(q4, q4_4);
            Mesquestions mq_45 = new Mesquestions(q4, q4_5);
             List<Mesquestions> lmq4 = new ArrayList<>();
              lmq4.add(mq_41); lmq4.add(mq_42); lmq4.add(mq_43); lmq4.add(mq_44); lmq4.add(mq_45);
            q4.setListMesquestions(lmq4);
            
            Notes n11 = new Notes(12, new Date(), u3, q1);
            Notes n12 = new Notes(14, new Date(), u4, q1);
            Notes n13 = new Notes(16, new Date(), u5, q1);
            List<Notes> ln1 = new ArrayList<>();
              ln1.add(n11); ln1.add(n12); ln1.add(n13);
              q1.setLesNotes(ln1);
            Notes n14 = new Notes(14, new Date(), u3, q2);
            Notes n15 = new Notes(10, new Date(), u4, q2);
            Notes n16 = new Notes(8, new Date(), u5, q2);
             List<Notes> ln2 = new ArrayList<>();
              ln2.add(n14); ln2.add(n15); ln2.add(n16); 
              q2.setLesNotes(ln2);
            Notes n17 = new Notes(12, new Date(), u3, q3);
            Notes n18 = new Notes(12, new Date(), u4, q3);
            Notes n19 = new Notes(8, new Date(), u5, q3);
             List<Notes> ln3 = new ArrayList<>();
              ln3.add(n17); ln3.add(n18); ln3.add(n19);
              q3.setLesNotes(ln3);           
            Notes n21 = new Notes(20, new Date(), u3, q4);
            Notes n22 = new Notes(10, new Date(), u4, q4);
            Notes n23 = new Notes(10, new Date(), u5, q4);
             List<Notes> ln4 = new ArrayList<>();
              ln4.add(n21); ln4.add(n22); ln4.add(n23);
              q4.setLesNotes(ln4);             
              
            persist(q1);
            persist(q2);
            persist(q3);
            persist(q4);
        }
        /*
        if(nbrEnregistrement(Utilisateur.class.getName()) == 0){
            
        }
        if(nbrEnregistrement(Questionnaire.class.getName()) == 0){
            
        }
        if(nbrEnregistrement(Question.class.getName()) == 0){
            
        }
        if(nbrEnregistrement(Mesquestions.class.getName()) == 0){
            
        }
        if(nbrEnregistrement(Reponse.class.getName()) == 0){
            
        }
        
        if(nbrEnregistrement(Notes.class.getName()) == 0){
            
        }
        */
    }
    
    /**
     * Calcule le nombre d'enregistrement pour le nom-table référencé
     * @param nom_table
     * @return 
     */
    private Long nbrEnregistrement(String entity_name){
        Query query = em.createNamedQuery(entity_name.concat(".count"));
        return (Long) query.getResultList().get(0);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
