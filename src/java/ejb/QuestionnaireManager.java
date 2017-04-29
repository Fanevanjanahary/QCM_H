/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Questionnaire;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ANDRIAMIADANTSOA
 */
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.ClientDataSource",
        name = "java:app/jdbc/db_qcm_h",
        serverName = "localhost",
        portNumber = 1527,
        user = "faneva", // nom et
        password = "fan", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "db_qcm_h"
)
@Stateful
public class QuestionnaireManager {

    @PersistenceContext(unitName = "QCM_HPU")
    private EntityManager em;

    public void creerQuestionnaire(Questionnaire questionnaire) {
        em.persist(questionnaire);
    }

    public Questionnaire update(Questionnaire questionnaire) {
        return em.merge(questionnaire);
    }

    public List<Questionnaire> getAllQuestionnaire() {
        Query query = em.createNamedQuery("Questionnaire.findAll");
        return query.getResultList();
    }

    public Questionnaire findById(Long id) {
        return em.find(Questionnaire.class, id);
    }

    public void deleteQuestionnaire(Questionnaire q) {
        em.remove(q);
    }

    /**
     * Méthode de recherche
     * @param motcles
     * @return 
     */
    public List<Questionnaire> find(String[] motcles) {
        String queryString = "SELECT * FROM QUESTIONNAIRE";
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
