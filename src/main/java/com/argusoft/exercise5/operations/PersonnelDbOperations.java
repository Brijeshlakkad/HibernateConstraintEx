/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.exercise5.operations;

import com.argusoft.exercise5.model.Personnel;
import com.argusoft.exercise5.utils.HibernateUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author brijesh
 */
public class PersonnelDbOperations {

    public final static Logger logger = Logger.getLogger(PersonnelDbOperations.class);
    static Session sessionObj;

    public static void createRecord(Personnel personnel) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            sessionObj.save(personnel);
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
    public static List<Personnel> displayRecords() {
        List<Personnel> msgList = new ArrayList<Personnel>();
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            msgList = (List<Personnel>) sessionObj.createQuery("FROM Personnel").list();
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

    public static Personnel findRecordById(Integer personnelId) {
        Personnel findObj = null;
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();

            findObj = (Personnel) sessionObj.get(Personnel.class, personnelId);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
    }

    public static void updateRecord(Personnel personnel) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            sessionObj.update(personnel);
            sessionObj.getTransaction().commit();
            logger.info("\nMessage With Id?= " + personnel.getId() + " Is Successfully Updated In The Database!\n");
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

    public static void deleteRecord(Integer personnelId) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            Personnel msg = findRecordById(personnelId);
            sessionObj.delete(msg);
            sessionObj.getTransaction().commit();
            logger.info("\nPersonnel With Id?= " + personnelId + " Is Successfully Deleted From The Database!\n");
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
