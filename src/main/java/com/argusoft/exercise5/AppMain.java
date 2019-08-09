/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.exercise5;

import com.argusoft.exercise5.model.Attachment;
import com.argusoft.exercise5.model.Personnel;
import com.argusoft.exercise5.model.Proposal;
import com.argusoft.exercise5.model.QualicaficationLevel;
import com.argusoft.exercise5.operations.ProposalDbOperations;
import com.argusoft.exercise5.utils.HibernateUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author brijesh
 */
public class AppMain {

    public static void main(String[] args) throws SQLException, IOException {
        Personnel personnel1 = new Personnel("Brijesh", QualicaficationLevel.Pro, "7046167267");
        Personnel personnel2 = new Personnel("Raj", QualicaficationLevel.Beginner, "7041167267");
        Date d = new Date();
        Timestamp t = new Timestamp(d.getTime());
        File file = new File("pic2.jpeg");
        FileInputStream inputStream = new FileInputStream(file);
        Session session = HibernateUtility.buildSessionFactory();
        session.beginTransaction();
        Blob blob = Hibernate.getLobCreator(session)
                .createBlob(inputStream, file.length());
        session.close();
        blob.free();
        Attachment att1 = new Attachment("pic1.png", "200", t,blob);
        Attachment att2 = new Attachment("pic2.jpeg", "300", t,blob);
        List<Personnel> personnelList = new ArrayList<Personnel>();
        List<Attachment> attList = new ArrayList<Attachment>();
        personnelList.add(personnel1);
        personnelList.add(personnel2);
        attList.add(att1);
        attList.add(att2);
        Proposal p1 = new Proposal();
        p1.setTitle("Title1");
        p1.setComment("Comment1");
        p1.setPersonnels(personnelList);
        p1.setAttachments(attList);
        ProposalDbOperations.createRecord(p1);
        System.out.println(p1);
    }

}
