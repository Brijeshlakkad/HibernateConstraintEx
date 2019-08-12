package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.Item;
import java.util.List;

/**
 *
 * @author rahul
 */
public interface ItemDao {
    public void create(int sallerId, Item item);
    public Item get(int id);
    public List<Item> getAll();
}
