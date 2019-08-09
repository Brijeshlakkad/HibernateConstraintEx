package com.argusoft.exercise4.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "graduationYear")
    private String graduationYear;
    @Column(name = "school")
    private String school;
    
    @OneToOne(mappedBy = "education")
    private Student student;

    public Education(String type, String description, String graduationYear, String school) {
        this.type = type;
        this.description = description;
        this.graduationYear = graduationYear;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Education{" + "id=" + id + ", type=" + type + ", desc=" + description + ", graduationYear=" + graduationYear + ", school=" + school + ", student=" + student + '}';
    }
}
