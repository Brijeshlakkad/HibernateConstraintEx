/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.exercise5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

/**
 *
 * @author brijesh
 */
@Entity
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", length = 60)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "qualicaficationLevel")
    private QualicaficationLevel qualicaficationLevel;
    @Column(name = "phone")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

//    @ManyToOne
//    private Proposal proposal;

    public Personnel() {

    }

    public Personnel(String name, QualicaficationLevel quaLevel, String phone) {
        this.name = name;
        this.qualicaficationLevel = quaLevel;
        this.phone = phone;
    }

//    public Proposal getProposal() {
//        return proposal;
//    }
//
//    public void setProposal(Proposal proposal) {
//        this.proposal = proposal;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QualicaficationLevel getQualicaficationLevel() {
        return qualicaficationLevel;
    }

    public void setQualicaficationLevel(QualicaficationLevel qualicaficationLevel) {
        this.qualicaficationLevel = qualicaficationLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Personnel{" + "id=" + id + ", name=" + name + ", qualicaficationLevel=" + qualicaficationLevel + ", phone=" + phone + '}';
    }

}
