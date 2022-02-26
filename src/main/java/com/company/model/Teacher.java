package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotEmpty(message = "firstName should not be empty")
    @Size(min = 1,max = 25,message = "firstName should be between 2 and 25 characters")
    @Column(name = "teacher_first_name")
    private String firstName;

    @Column(name = "teacher_email")
    @Email(message = "email must follow the formatter: ***@*** ")
    @NotBlank(message = "Email must have a value")
    private String email;

    @NotEmpty(message = "lastName should not be empty")
    @Size(min = 1,max = 25,message = "lastName should be between 2 and 25 characters")
    @Column(name = "teacher_last_name")
    private String lastName;


    @Enumerated(EnumType.STRING)
    private studyFormat studyFormat;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    public Teacher() {
    }

    public Teacher(String firstName, String email, String lastName,
                   com.company.model.studyFormat studyFormat) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.studyFormat = studyFormat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public com.company.model.studyFormat getStudyFormat() {
        return studyFormat;
    }

    public void setStudyFormat(com.company.model.studyFormat studyFormat) {
        this.studyFormat = studyFormat;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studyFormat=" + studyFormat +
                '}';
    }
}
