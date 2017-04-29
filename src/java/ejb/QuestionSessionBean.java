/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Question;
import entities.Questionnaire;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Stateful
public class QuestionSessionBean {

    @PersistenceContext(unitName = "QCM_HPU")
    private EntityManager em;

    public void creerQuestion(Question q) {
        em.persist(q);
    }
    
    public Question udpade(Question q){
        return em.merge(q);
    }
    
    public List<Question> findAll(){
        Query query = em.createNamedQuery("Question.findAll");
        return query.getResultList();
    }
    
    public Question findByid(int id){
        return em.find(Question.class, id);
    }
    
    public void deleteQuestion(Question q){
        
        em.remove(q);
    }
    
    /**
     * Méthode de recherche
     * @param motcles
     * @return 
     */
    public List<Questionnaire> find(String[] motcles) {
        String queryString = "SELECT * FROM QUESTION";
        if (motcles != null && motcles.length > 0) {
            String where = " WHERE";
            for (int i = 0; i < motcles.length; i++) {
                if (i != motcles.length - 1) {
                    where += " MOTCLE LIKE '%" + motcles[i] + "%' OR";
                } else {
                    where += " MOTCLE LIKE '%" + motcles[i] + "%'";
                }
            }
            queryString += where;
        }
        Query query = em.createQuery(queryString);

        return query.getResultList();
    }
}
