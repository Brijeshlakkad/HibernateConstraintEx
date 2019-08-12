package com.argusoft.exercise6.dao;

import com.argusoft.exercise6.model.Comment;
import com.argusoft.exercise6.model.Item;
import com.argusoft.exercise6.model.User;
import com.argusoft.exercise6.utils.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rahul
 */
public class CommentDaoImpl implements CommentDao {

    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void create(int userId, int itemId, Comment comment) {
        try {
            entityManager.getTransaction().begin();
            comment.setUser(entityManager.find(User.class, userId));
            comment.setItem(entityManager.find(Item.class, userId));
            entityManager.persist(comment);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Comment get(int id) {
        Comment comment = null;
        try {
            comment = entityManager.find(Comment.class, id);
        } catch (Exception e) {
        }
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
