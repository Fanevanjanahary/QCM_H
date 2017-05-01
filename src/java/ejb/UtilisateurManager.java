/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Utilisateur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author madlord
 */
@Stateless
public class UtilisateurManager {
    
    
    @PersistenceContext(unitName = "QCM_HPU")
    private EntityManager em;
    
    public void creerUtilisateur(Utilisateur reponse) {
        em.persist(reponse);
    }
    
    public Utilisateur update(Utilisateur r){
        return em.merge(r);
    }
    
    public List<Utilisateur> findAll()
    {
        Query query = em.createNamedQuery("Utilisateur.findAll");
        return query.getResultList();
    }
    
    public List<Utilisateur> find(Utilisateur u)
    {
        Query query = em.createNamedQuery("Utilisateur.find")
                .setParameter("utilisateur", u.getNomUtilisateur())
                .setParameter("motDePasse", u.getMotDepasse());
        return query.getResultList();
    }
    
    
    
    public Utilisateur findById(Long id){
        return em.find(Utilisateur.class, id);
    }

    public void delete(Utilisateur r){
        em.remove(r);
    }

}
