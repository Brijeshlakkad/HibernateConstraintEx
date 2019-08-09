/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.exercise5.operations;

import com.argusoft.exercise5.model.Proposal;
import com.argusoft.exercise5.utils.HibernateUtility;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author brijesh
 */
public class ProposalDbOperations {

    public final static Logger logger = Logger.getLogger(ProposalDbOperations.class);
    static Session sessionObj;

    public static void createRecord(Proposal proposal)  {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            sessionObj.save(proposal);
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
    public static List<Proposal> displayRecords() {
        List<Proposal> msgList = new ArrayList<Proposal>();
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            msgList = (List<Proposal>) sessionObj.createQuery("FROM Proposal").list();
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

    public static Proposal findRecordById(Integer proposalId) {
        Proposal findObj = null;
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();

            findObj = (Proposal) sessionObj.load(Proposal.class, proposalId);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
    }

    public static void updateRecord(int proposalId, String message) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();
            Proposal msg = (Proposal) sessionObj.get(Proposal.class, proposalId);
//            msg.setMessage(message);
            sessionObj.getTransaction().commit();
            logger.info("\nMessage With Id?= " + proposalId + " Is Successfully Updated In The Database!\n");
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

    public static void deleteRecord(Integer proposalId) {
        try {
            sessionObj = HibernateUtility.buildSessionFactory();
            sessionObj.beginTransaction();

            Proposal msg = findRecordById(proposalId);
            sessionObj.delete(msg);

            sessionObj.getTransaction().commit();
            logger.info("\nProposal With Id?= " + proposalId + " Is Successfully Deleted From The Database!\n");
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
