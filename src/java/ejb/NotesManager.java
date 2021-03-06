/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Notes;
import entities.Utilisateur;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@Stateful
public class NotesManager {

    @PersistenceContext(unitName = "QCM_HPU")
    private EntityManager em;
    
    @EJB
    private QuestionnaireManager qm;

    
    @EJB
    private UtilisateurManager um;

    
    public void creerNotes(Notes note) {
        note.setQuestionnaire(qm.findById(note.getQuestionnaire().getId()));
        note.setUtilisateur(um.findById(note.getUtilisateur().getId()));
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
    
    public  List<Notes> findByUtilisateur(Utilisateur u){
        return em.createNamedQuery("Notes.findByUtilisateurId").setParameter("utilisateur", u).getResultList();
    }
}
