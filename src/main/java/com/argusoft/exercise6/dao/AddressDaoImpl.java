package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.Address;
import com.argusoft.exercise6.model.User;
import com.argusoft.exercise6.utils.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rahul
 */
public class AddressDaoImpl implements AddressDao {

    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void create(int userId, Address address) {
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, userId);
            user.getAddresses().add(address);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Address get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
