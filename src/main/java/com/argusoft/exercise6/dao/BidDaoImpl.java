package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.Bid;
import com.argusoft.exercise6.model.Item;
import com.argusoft.exercise6.model.User;
import com.argusoft.exercise6.utils.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rahul
 */
public class BidDaoImpl implements BidDao {

    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void create(int userId, int itemId, Bid bid) {
        try {
            entityManager.getTransaction().begin();
            bid.setBuyer(entityManager.find(User.class, userId));
            bid.setItem_id(entityManager.find(Item.class, itemId));
            entityManager.persist(bid);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Bid get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bid> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
