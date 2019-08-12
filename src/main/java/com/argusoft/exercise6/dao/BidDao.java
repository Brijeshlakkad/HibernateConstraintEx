package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.Bid;
import java.util.List;

/**
 *
 * @author rahul
 */
public interface BidDao {
    public void create(int userId, int itemId, Bid bid);
    public Bid get(int id);
    public List<Bid> getAll();
}
