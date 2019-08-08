/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.hibernate.ex.main;

import com.argusoft.hibernate.ex.model.UserProfile;
import com.argusoft.hibernate.ex.operations.DbOperations;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author brijesh
 */
public class AppMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            System.out.println("Choose option: ");
            System.out.println("1. Add an User");
            System.out.println("2. Show an user");
            System.out.println("3. Show all users");
            System.out.println("4. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    createUser(sc);
                    break;
                case 2:
                    showUser(sc);
                    break;
                case 3:
                    showUsers();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }

    private static void createUser(Scanner sc) {
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();
        System.out.println("Enter phone number: ");
        String phone = sc.next();
        UserProfile userProfile = new UserProfile(name,email,phone);
        DbOperations.createRecord(userProfile);
    }

    private static void showUser(Scanner sc) {
        System.out.println("Enter message id:  ");
        int id = sc.nextInt();
        UserProfile userProfile = DbOperations.findRecordById(id);
        System.out.println(userProfile);
    }

    private static void showUsers() {
        List<UserProfile> userProifleList = DbOperations.displayRecords();
        userProifleList.forEach((userProifle) -> {
            System.out.println(userProifle);
        });
    }
//
//    private static void updateMessage(Scanner sc) {
//        System.out.println("Enter message id: ");
//        int id = sc.nextInt();
//        System.out.println("Enter a message: ");
//        String text = sc.next();
//        DbOperations.updateRecord(id, text);
//    }
//
//    private static void deleteMessage(Scanner sc) {
//        System.out.println("Enter message id: ");
//        int id = sc.nextInt();
//        DbOperations.deleteRecord(id);
//    }
//
//    private static void deleteMessages() {
//        DbOperations.deleteAllRecords();
//    }
}
