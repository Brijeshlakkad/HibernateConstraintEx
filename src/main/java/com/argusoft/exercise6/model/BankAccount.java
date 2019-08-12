package com.argusoft.exercise6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author brijesh
 */
@Entity
public class BankAccount extends BillingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "bankName")
    private String bankName;

    @Column(name = "swift")
    private String swift;

    public BankAccount(String number, String bankName, String swift) {
        this.number = number;
        this.bankName = bankName;
        this.swift = swift;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id=" + id + ", number=" + number + ", bankName=" + bankName + ", swift=" + swift + '}';
    }

}
