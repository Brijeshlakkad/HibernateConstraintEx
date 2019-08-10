package com.argusoft.exercise5.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "comment", length = 100)
    private String comment;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id")
    List<Personnel> personnels;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id")
    List<Attachment> attachments;

    public Proposal() {

    }

    public Proposal(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "Proposal{" + "id=" + id + ", title=" + title + ", comment=" + comment + ", personnels=" + personnels + ", attachments=" + attachments + '}';
    }

}
