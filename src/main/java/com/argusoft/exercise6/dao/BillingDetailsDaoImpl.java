package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.BillingDetails;
import com.argusoft.exercise6.model.User;
import com.argusoft.exercise6.utils.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rahul
 */
public class BillingDetailsDaoImpl implements BillingDetailsDao{

    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    @Override
    public void create(int userId, BillingDetails billing) {
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, userId);
            user.getBillings().add(billing);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public BillingDetails get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillingDetails> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
