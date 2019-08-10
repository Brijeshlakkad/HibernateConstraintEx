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
import com.argusoft.exercise5.operations.AttachmentDbOperations;
import com.argusoft.exercise5.operations.PersonnelDbOperations;
import com.argusoft.exercise5.operations.ProposalDbOperations;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *
 * @author brijesh
 */
public class AppMain {

    public final static Logger logger = Logger.getLogger(ProposalDbOperations.class);

    public static void main(String[] args) throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        int option = 1;
        while (option != 0) {
            System.out.println("Enter operation: ");
            String operation = sc.next();
            System.out.println("Enter entity: ");
            String entity = sc.next();
            if (null == entity) {
                System.out.println("Wrong entity!");
            } else {
                switch (entity) {
                    case "proposal": {

                        if (null == operation) {
                            System.out.println("Wrong operation!");
                        } else {
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
                            logger.info("\n......." + operation + " " + entity + " record.......\n");
                            switch (operation) {
                                case "create":
                                    ProposalDbOperations.createRecord(p1);
                                    System.out.println(p1);
                                    break;
                                case "update":
                                    p1.setTitle("changedTitle");
                                    ProposalDbOperations.updateRecord(p1);
                                    break;
                                case "delete":
                                    System.out.println("Enter id: ");
                                    int id = sc.nextInt();
                                    ProposalDbOperations.deleteRecord(new Long(id));
                                    break;
                                default:
                                    System.out.println("Wrong operation!");
                                    break;
                            }
                        }
                        break;
                    }
                    case "personnel": {
                        if (null == operation) {
                            System.out.println("Wrong operation!");
                        } else {
                            Personnel personnel2 = new Personnel("Raj", QualicaficationLevel.Beginner, "7041167267");
                            logger.info("\n......." + operation + " " + entity + " record.......\n");
                            switch (operation) {
                                case "create":
                                    PersonnelDbOperations.createRecord(personnel2);
                                    break;
                                case "update":
                                    personnel2.setName("ChangedName");
                                    PersonnelDbOperations.updateRecord(personnel2);
                                    break;
                                case "delete":
                                    System.out.println("Enter id: ");
                                    int id = sc.nextInt();
                                    PersonnelDbOperations.deleteRecord(new Integer(id));
                                    break;
                                default:
                                    System.out.println("Wrong operation!");
                                    break;
                            }
                        }
                        break;
                    }
                    case "attachment":
                        if (null == operation) {
                            System.out.println("Wrong operation!");
                        } else {
                            Date d = new Date();
                            Timestamp t = new Timestamp(d.getTime());
                            byte[] photoBytes = readBytesFromFile("pic2.jpeg");
                            Attachment att = new Attachment("pic1.png", "200", t, photoBytes);
                            logger.info("\n......." + operation + " " + entity + " record.......\n");
                            switch (operation) {
                                case "create":
                                    AttachmentDbOperations.createRecord(att);
                                    break;
                                case "update":
                                    att.setFileName("changedName.png");
                                    AttachmentDbOperations.updateRecord(att);
                                    break;
                                case "delete":
                                    System.out.println("Enter id: ");
                                    int id = sc.nextInt();
                                    AttachmentDbOperations.deleteRecord(id);
                                    break;
                                default:
                                    System.out.println("Wrong operation!");
                                    break;
                            }
                        }
                        break;

                    default:
                        System.out.println("Wrong entity!");
                        break;
                }
            }
            System.out.println("Enter 0 to exit or any key to continue:");
            option = sc.nextInt();
        }
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
