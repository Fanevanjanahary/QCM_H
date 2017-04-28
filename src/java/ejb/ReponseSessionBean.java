/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Reponse;
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
public class ReponseSessionBean {

    @PersistenceContext(unitName = "QCM_HPU")
    private EntityManager em;

    public void creerReponse(Reponse reponse) {
        em.persist(reponse);
    }
    
    public Reponse update(Reponse r){
        return em.merge(r);
    }
    
    public List<Reponse> getAllReponse()
    {
        Query query = em.createNamedQuery("Reponse.findAll");
        return query.getResultList();
    }
    
    public Reponse getById(int id){
        return em.find(Reponse.class, id);
    }

    public void deleteQuestionnaire(Reponse r){
        em.remove(r);
    }

}
