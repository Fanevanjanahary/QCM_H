/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Mesquestions;
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
public class MesQuestionsManager {

    @PersistenceContext(unitName = "QCM_HPU")
    private EntityManager em;

    public void creerMesQuestions(Mesquestions mq) {
        em.persist(mq);
    }
    
    public List<Mesquestions> getAll()
    {
        Query query = em.createNamedQuery("Mesquestions.findAll");
        return query.getResultList();
    }
    
    public Mesquestions getById(int id){
        return em.find(Mesquestions.class, id);
    }
    
    public List<Mesquestions> getByQuestionnaire()
    {
        Query query = em.createNamedQuery("Mesquestions.findByQuestionnaire");
        return query.getResultList();
    }

   
}
