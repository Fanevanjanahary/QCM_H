/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Notes;
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
public class GestionnaireNote {

    @PersistenceContext(unitName = "QCM_HPU")
    private EntityManager em;

    public void creerNotes(Notes note) {
        em.persist(note);
    }
    
    public Notes udpade(Notes n){
        return em.merge(n);
    }
    
    public List<Notes> findAll(){
        Query query = em.createNamedQuery("Notes.findAll");
        return query.getResultList();
    }
    
    public Notes findByid(int id){
        return em.find(Notes.class, id);
    }
    
    public Notes findById(Long id) {
        return em.find(Notes.class, id);
    }
    
    public void delete(Notes n){
        em.remove(n);
    }
}
