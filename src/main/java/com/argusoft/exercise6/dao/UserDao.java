package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.User;
import java.util.List;

/**
 *
 * @author rahul
 */
public interface UserDao {

    public void create(User user);

    public User get(int id);

    public List<User> getAll();
}
