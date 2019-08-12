package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.Comment;
import java.util.List;

/**
 *
 * @author rahul
 */
public interface CommentDao {
    public void create(int userId, int itemId, Comment comment);
    public Comment get(int id);
    public List<Comment> getAll();
}
