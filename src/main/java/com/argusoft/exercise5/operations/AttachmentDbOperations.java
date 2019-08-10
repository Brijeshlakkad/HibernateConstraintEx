/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.exercise5.operations;

import com.argusoft.exercise5.model.Attachment;
import com.argusoft.exercise5.utils.HibernateUtility;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author brijesh
 */
public class AttachmentDbOperations {

    public final static Logger logger = Logger.getLogger(AttachmentDbOperations.class);
    static Session sessionObj;

    public static void createRecord(Attachment attachment) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            sessionObj.save(attachment);
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
    public static List<Attachment> displayRecords() {
        List<Attachment> msgList = new ArrayList<Attachment>();
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            msgList = (List<Attachment>) sessionObj.createQuery("FROM Attachment").list();
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

    public static Attachment findRecordById(Integer attachmentId) {
        Attachment findObj = null;
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            findObj = (Attachment) sessionObj.get(Attachment.class, attachmentId);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
    }

    public static void updateRecord(Attachment attachment) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            sessionObj.update(attachment);
            sessionObj.getTransaction().commit();
            logger.info("\nMessage With Id?= " + attachment.getId() + " Is Successfully Updated In The Database!\n");
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

    public static void deleteRecord(Integer attachmentId) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            Attachment msg = findRecordById(attachmentId);
            sessionObj.delete(msg);
            sessionObj.getTransaction().commit();
            logger.info("\nAttachment With Id?= " + attachmentId + " Is Successfully Deleted From The Database!\n");
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
