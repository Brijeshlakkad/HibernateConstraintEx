///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.argusoft.exercise5.operations;
//
//import com.argusoft.exercise5.model.Attachment;
//import com.argusoft.exercise5.utils.HibernateUtility;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.sql.Blob;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.hibernate.Hibernate;
//import org.hibernate.Session;
//
///**
// *
// * @author brijesh
// */
//public class AttachmentDbOperations {
//
//    public final static Logger logger = Logger.getLogger(AttachmentDbOperations.class);
//    static Session sessionObj;
//
//    public static void createRecord(Attachment attachment, String photoFilePath) throws IOException, SQLException {
//        try {
//            sessionObj = HibernateUtility.buildSessionFactory();
//            sessionObj.beginTransaction();
//            File file = new File(photoFilePath);
//            FileInputStream inputStream = new FileInputStream(file);
//            Blob blob = Hibernate.getLobCreator(sessionObj)
//                    .createBlob(inputStream, file.length());
//            sessionObj.save(attachment);
//            blob.free();
//            sessionObj.getTransaction().commit();
//        } catch (Exception sqlException) {
//            if (sessionObj.getTransaction() != null) {
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
//    @SuppressWarnings("unchecked")
//    public static List<Attachment> displayRecords(String photoFilePath) {
//        List<Attachment> msgList = new ArrayList<Attachment>();
//        try {
//            sessionObj = HibernateUtility.buildSessionFactory();
//            sessionObj.beginTransaction();
//            msgList = (List<Attachment>) sessionObj.createQuery("FROM Attachment").list();
//            int i = 0;
//            for (Attachment msg : msgList) {
//                Blob blob = msg.getAttachmentBytes();
//                byte[] blobBytes = blob.getBytes(1, (int) blob.length());
//                saveBytesToFile(photoFilePath + "-" + i, blobBytes);
//                blob.free();
//                i++;
//            }
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
//        return msgList;
//    }
//
//    private static void saveBytesToFile(String filePath, byte[] fileBytes) throws IOException {
//        FileOutputStream outputStream = new FileOutputStream(filePath);
//        outputStream.write(fileBytes);
//        outputStream.close();
//    }
//
//    public static Attachment findRecordById(Integer attachmentId, String photoFilePath) {
//        Attachment findObj = null;
//        try {
//            sessionObj = HibernateUtility.buildSessionFactory();
//            sessionObj.beginTransaction();
//
//            findObj = (Attachment) sessionObj.load(Attachment.class, attachmentId);
//            if (photoFilePath != null) {
//                Blob blob = findObj.getAttachmentBytes();
//                byte[] blobBytes = blob.getBytes(1, (int) blob.length());
//                saveBytesToFile(photoFilePath, blobBytes);
//                blob.free();
//            }
//        } catch (Exception sqlException) {
//            if (null != sessionObj.getTransaction()) {
//                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
//                sessionObj.getTransaction().rollback();
//            }
//            sqlException.printStackTrace();
//        }
//        return findObj;
//    }
//
//    public static void updateRecord(int attachmentId, String message) {
//        try {
//            sessionObj = HibernateUtility.buildSessionFactory();
//            sessionObj.beginTransaction();
//            Attachment msg = (Attachment) sessionObj.get(Attachment.class, attachmentId);
////            msg.setMessage(message);
//            sessionObj.getTransaction().commit();
//            logger.info("\nMessage With Id?= " + attachmentId + " Is Successfully Updated In The Database!\n");
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
//    public static void deleteRecord(Integer attachmentId) {
//        try {
//            sessionObj = HibernateUtility.buildSessionFactory();
//            sessionObj.beginTransaction();
//
//            Attachment msg = findRecordById(attachmentId, null);
//            sessionObj.delete(msg);
//
//            sessionObj.getTransaction().commit();
//            logger.info("\nAttachment With Id?= " + attachmentId + " Is Successfully Deleted From The Database!\n");
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
//}
