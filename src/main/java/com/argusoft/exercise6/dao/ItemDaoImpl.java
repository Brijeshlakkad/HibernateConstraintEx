package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.Item;
import com.argusoft.exercise6.model.Item;
import com.argusoft.exercise6.model.User;
import com.argusoft.exercise6.utils.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rahul
 */
public class ItemDaoImpl implements ItemDao {

    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void create(int sallerId, Item item) {
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, sallerId);
            user.getItems().add(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Item get(int id) {
        Item item = null;
        try {
            item = entityManager.find(Item.class, id);
        } catch (Exception e) {
        }
        return item;
    }

    @Override
    public List<Item> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
