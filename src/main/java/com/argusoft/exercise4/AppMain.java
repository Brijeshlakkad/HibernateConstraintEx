/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.exercise4;

import com.argusoft.exercise4.model.Address;
import com.argusoft.exercise4.model.Education;
import com.argusoft.exercise4.model.Student;
import com.argusoft.exercise4.operations.StudentDbOperations;

/**
 *
 * @author brijesh
 */
public class AppMain {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setFirstName("Brijesh");
        s1.setMiddleName("R");
        s1.setLastName("Lakkad");
        s1.setEmail("b@gmail.com");
        s1.setPhone("2112121");
        s1.setAddress(new Address("street1", "stree2", "surat", "gujarat", "india"));
        s1.setEducation(new Education("AB", "BDESC", "2019", "School"));
        StudentDbOperations.createRecord(s1);

        System.out.println(""+s1);
//        Scanner sc = new Scanner(System.in);
//        int option = 0;
//
//        while (option != 4) {
//            System.out.println("Choose option: ");
//            System.out.println("1. Enter an message");
//            System.out.println("2. Show an message");
//            System.out.println("3. Show all message details");
//            System.out.println("4. Exit");
//            option = sc.nextInt();
//            switch (option) {
//                case 1:
//                    createMessage(sc);
//                    break;
//                case 2:
//                    showMessage(sc);
//                    break;
//                case 3:
//                    showMessages();
//                case 4:
//                    return;
//                default:
//                    System.out.println("Wrong input!");
//                    break;
//            }
//        }
    }
//
//    private static void createMessage(Scanner sc) {
////        System.out.println("Enter first name: ");
////        String firstName = sc.next();
////        System.out.println("Enter middle name: ");
////        String middleName = sc.next();
////        System.out.println("Enter last name: ");
////        String lastName = sc.next();
////        System.out.println("Enter email: ");
////        String email = sc.next();
////        System.out.println("Enter phone: ");
////        String phone = sc.next();
////        System.out.println("Enter address: ");
////        String firstName = sc.next();
////        Student msg = new Student(text);
////        StudentDbOperations.createRecord(msg);
//    }
//
//    private static void showMessage(Scanner sc) {
//        System.out.println("Enter message id:  ");
//        int id = sc.nextInt();
//        Student helloWorld = StudentDbOperations.findRecordById(id);
//        System.out.println(helloWorld);
//    }
//
//    private static void showMessages() {
//        List<Student> msgList = StudentDbOperations.displayRecords();
//        msgList.forEach((msg) -> {
//            System.out.println(msg);
//        });
//    }
}
