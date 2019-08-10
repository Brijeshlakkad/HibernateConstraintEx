/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.exercise6.operations;

import com.argusoft.exercise6.model.User;
import com.argusoft.exercise6.utils.HibernateUtility;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author brijesh
 */
public class UserDbOperations {

    public final static Logger logger = Logger.getLogger(UserDbOperations.class);
    static Session sessionObj;

    public static void createRecord(User user) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            sessionObj.save(user);
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (sessionObj.getTransaction() != null) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<User> displayRecords() {
        List<User> msgList = new ArrayList<User>();
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            msgList = (List<User>) sessionObj.createQuery("FROM User").list();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return msgList;
    }

    public static User findRecordById(Long userId) {
        User findObj = null;
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();

            findObj = (User) sessionObj.get(User.class, userId);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
    }

    public static void updateRecord(User user) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            sessionObj.update(user);
            sessionObj.getTransaction().commit();
            logger.info("\nMessage With Id?= " + user.getId() + " Is Successfully Updated In The Database!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    public static void deleteRecord(Long userId) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();

            User msg = findRecordById(userId);
            sessionObj.delete(msg);

            sessionObj.getTransaction().commit();
            logger.info("\nUser With Id?= " + userId + " Is Successfully Deleted From The Database!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

}
