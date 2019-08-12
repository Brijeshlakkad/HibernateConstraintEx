package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.Shipment;
import java.util.List;

/**
 *
 * @author rahul
 */
public interface ShipmentDao {
    public void create(int itemId, int buyerId, int sallerId, int addresId, Shipment shipment);
    public Shipment get(int id);
    public List<Shipment> getAll();
}
