package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.Address;
import com.argusoft.exercise6.model.Item;
import com.argusoft.exercise6.model.Shipment;
import com.argusoft.exercise6.model.User;
import com.argusoft.exercise6.utils.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rahul
 */
public class ShipmentDaoImpl implements ShipmentDao {

    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void create(int itemId, int buyerId, int sallerId, int addresId, Shipment shipment) {
        try {
            entityManager.getTransaction().begin();
            shipment.setItem_id(entityManager.find(Item.class, itemId));
            shipment.setSeller(entityManager.find(User.class, sallerId));
            shipment.setBuyer(entityManager.find(User.class, buyerId));
            shipment.setDilivery(entityManager.find(Address.class, addresId));
            entityManager.persist(shipment);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Shipment get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Shipment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
