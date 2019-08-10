/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.exercise5.model;

import java.sql.Timestamp;
import java.util.Date;
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
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "fileSize")
    private String fileSize;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Column(name = "attachmentBytes",length=20000)
    private byte[] attachmentBytes;

//    @ManyToOne
//    private Proposal proposal;
    public Attachment() {

    }

    public Attachment(String fileName, String fileSize, Timestamp created, byte[] blob) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.created = created;
        this.attachmentBytes = blob;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public byte[] getAttachmentBytes() {
        return attachmentBytes;
    }

    public void setAttachmentBytes(byte[] attachmentBytes) {
        this.attachmentBytes = attachmentBytes;
    }

    @Override
    public String toString() {
        return "Attachment{" + "id=" + id + ", fileName=" + fileName + ", fileSize=" + fileSize + ", created=" + created + ", attachmentBytes=" + attachmentBytes + '}';
    }

}
