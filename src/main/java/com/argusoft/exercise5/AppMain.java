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
import static com.argusoft.exercise5.operations.ProposalDbOperations.logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author brijesh
 */
public class AppMain {

    public final static Logger logger = Logger.getLogger(ProposalDbOperations.class);

    public static void main(String[] args) throws SQLException, IOException {
        Personnel personnel1 = new Personnel("Brijesh", QualicaficationLevel.Pro, "7046167267");
        Personnel personnel2 = new Personnel("Raj", QualicaficationLevel.Beginner, "7041167267");
        Date d = new Date();
        Timestamp t = new Timestamp(d.getTime());

        byte[] photoBytes = readBytesFromFile("pic2.jpeg");
        Attachment att1 = new Attachment("pic1.png", "200", t, photoBytes);
        Attachment att2 = new Attachment("pic2.jpeg", "300", t, photoBytes);
        List<Personnel> personnelList = new ArrayList<>();
        List<Attachment> attList = new ArrayList<>();
        personnelList.add(personnel1);
        personnelList.add(personnel2);
        attList.add(att1);
        attList.add(att2);
        Proposal p1 = new Proposal();
        p1.setTitle("Title1");
        p1.setComment("Comment1");
        p1.setPersonnels(personnelList);
        p1.setAttachments(attList);
        logger.info("\n.......Creating record.......\n");
        ProposalDbOperations.createRecord(p1);
        System.out.println(p1);
        logger.info("\n.......Updating record.......\n");
        p1.setTitle("changedTitle");
        ProposalDbOperations.updateRecord(p1);

        logger.info("\n.......Deleting record.......\n");
        ProposalDbOperations.deleteRecord(new Long(1));

    }

    private static byte[] readBytesFromFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(inputFile);

        byte[] fileBytes = new byte[(int) inputFile.length()];
        inputStream.read(fileBytes);
        inputStream.close();
        return fileBytes;
    }
}
