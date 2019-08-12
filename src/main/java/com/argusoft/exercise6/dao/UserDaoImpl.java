package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.User;
import com.argusoft.exercise6.utils.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rahul
 */
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void create(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public User get(int id) {
        User person = null;
        try {
            person = entityManager.find(User.class, id);
        } catch (Exception e) {
        }
        return person;
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
