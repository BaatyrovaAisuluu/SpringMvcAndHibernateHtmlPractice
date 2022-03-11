package com.company.model;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,generator = "teacher_sequence"
    )
    private long id;

    @Size(min = 1, max = 30, message = "firstName should be between 2 and 25 characters")
    private String TeacherFirstName;

    @Email(message = "email must follow the formatter: ***@*** ")
    private String email;

    @Size(min = 1, max = 25, message = "lastName should be between 2 and 25 characters")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private studyFormat studyFormat;

    @OneToOne(cascade = {MERGE, DETACH, REFRESH, PERSIST},fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Teacher() {
    }

    public Teacher(long id, String TeacherFirstName,
                   String email, String lastName,
                   com.company.model.studyFormat studyFormat) {
        this.id = id;
        this.TeacherFirstName = TeacherFirstName;
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

    public String getTeacherFirstName() {
        return TeacherFirstName;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public com.company.model.studyFormat getStudyFormat() {
        return studyFormat;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setTeacherFirstName(String firstName) {
        this.TeacherFirstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudyFormat(com.company.model.studyFormat studyFormat) {
        this.studyFormat = studyFormat;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + TeacherFirstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studyFormat=" + studyFormat +
                '}';
    }
}
