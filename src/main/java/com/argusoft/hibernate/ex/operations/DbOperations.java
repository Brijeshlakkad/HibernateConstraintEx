/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.hibernate.ex.operations;

import com.argusoft.hibernate.ex.model.UserProfile;
import com.argusoft.hibernate.ex.utils.HibernateUtility;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author brijesh
 */
public class DbOperations {

    public final static Logger logger = Logger.getLogger(DbOperations.class);
    static Session sessionObj;

    public static void createRecord(UserProfile userProifle) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            sessionObj.save(userProifle);
            sessionObj.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            logger.info("\n.......Unique Constraint Violated..........\n");
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
    public static List<UserProfile> displayRecords() {
        List<UserProfile> msgList = new ArrayList<UserProfile>();
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            msgList = (List<UserProfile>) sessionObj.createQuery("FROM UserProfile").list();
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

//    public static void updateRecord(int msgId, String message) {
//        try {
//            sessionObj = HibernateUtility.buildSessionFactory();
//            sessionObj.beginTransaction();
//            UserProfile userProfile = (UserProfile) sessionObj.get(UserProfile.class, msgId);
//            userProfile.setMessage(message);
//            sessionObj.getTransaction().commit();
//            logger.info("\nMessage With Id?= " + msgId + " Is Successfully Updated In The Database!\n");
//        } catch (Exception sqlException) {
//            if (null != sessionObj.getTransaction()) {
//                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
//                sessionObj.getTransaction().rollback();
//            }
//            sqlException.printStackTrace();
//        } finally {
//            if (sessionObj != null) {
//                sessionObj.close();
//            }
//        }
//    }
//
//    public static void deleteRecord(Integer msgId) {
//        try {
//            sessionObj = HibernateUtility.buildSessionFactory();
//            sessionObj.beginTransaction();
//
//            HelloWorld msg = findRecordById(msgId);
//            sessionObj.delete(msg);
//
//            sessionObj.getTransaction().commit();
//            logger.info("\nHelloWorld With Id?= " + msgId + " Is Successfully Deleted From The Database!\n");
//        } catch (Exception sqlException) {
//            if (null != sessionObj.getTransaction()) {
//                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
//                sessionObj.getTransaction().rollback();
//            }
//            sqlException.printStackTrace();
//        } finally {
//            if (sessionObj != null) {
//                sessionObj.close();
//            }
//        }
//    }
//
    public static UserProfile findRecordById(Integer userId) {
        UserProfile findObj = null;
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();

            findObj = (UserProfile) sessionObj.load(UserProfile.class, userId);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
    }
//
//    public static void deleteAllRecords() {
//        try {
//            sessionObj = HibernateUtility.buildSessionFactory();
//            sessionObj.beginTransaction();
//
//            Query queryObj = sessionObj.createQuery("DELETE FROM HelloWorld");
//            queryObj.executeUpdate();
//
//            sessionObj.getTransaction().commit();
//            logger.info("\nSuccessfully Deleted All Records From The Database Table!\n");
//        } catch (Exception sqlException) {
//            if (null != sessionObj.getTransaction()) {
//                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
//                sessionObj.getTransaction().rollback();
//            }
//            sqlException.printStackTrace();
//        } finally {
//            if (sessionObj != null) {
//                sessionObj.close();
//            }
//        }
//    }
}
