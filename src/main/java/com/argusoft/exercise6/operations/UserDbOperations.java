/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.exercise6.operations;

import com.argusoft.exercise6.model.User;
import com.argusoft.exercise6.utils.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

/**
 *
 * @author brijesh
 */
public class UserDbOperations {

    public final static Logger logger = Logger.getLogger(UserDbOperations.class);
    private static EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    public static void createRecord(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception sqlException) {
            if (entityManager.getTransaction() != null) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                entityManager.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<User> displayRecords() {
        List<User> msgList = new ArrayList<User>();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM User");
            msgList = (List<User>) query.getResultList();
        } catch (Exception sqlException) {
            if (null != entityManager.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                entityManager.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return msgList;
    }

    public static User findRecordById(Long userId) {
        User findObj = null;
        try {
//            Query query = entityManager.createQuery("FROM User WHERE id=?");
//            query.setParameter(1, userId);
//            findObj = (User) query.getSingleResult();
            findObj = entityManager.find(User.class, userId);
        } catch (Exception sqlException) {
            if (null != entityManager.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                entityManager.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
    }

    public static void updateRecord(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            logger.info("\nMessage With Id?= " + user.getId() + " Is Successfully Updated In The Database!\n");
        } catch (Exception sqlException) {
            if (null != entityManager.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                entityManager.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public static void deleteRecord(Long userId) {
        try {
            entityManager.getTransaction().begin();
            User msg = findRecordById(userId);
            entityManager.remove(msg);
            entityManager.getTransaction().commit();
            logger.info("\nUser With Id?= " + userId + " Is Successfully Deleted From The Database!\n");
        } catch (Exception sqlException) {
            if (null != entityManager.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                entityManager.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

}
