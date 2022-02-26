package com.company.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

    @Column(name = "student_first_name")
    @NotEmpty(message = "firstName should not be empty")
    @Size(min = 1,max = 25,message = "firstName should be between 2 and 25 characters")
     private String firstName;

    @Column(name = "student_email")
    @Email(message = "email must follow the formatter: ***@*** ")
    @NotBlank(message = "Email must have a value")
     private String email;

    @Column(name = "student_last_name",unique = true)
    @NotEmpty(message = "lastName should not be empty")
    @Size(min = 1,max = 25,message = "lastName should be between 2 and 25 characters")
    private String lastName;

    @NotNull(message = "birthday is a required field. ")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
     private LocalDate birthOfDay;

    public Student() {
    }

    public Student(String firstName, String email, String lastName,LocalDate birthOfDay) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.birthOfDay=birthOfDay;
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

    public LocalDate getBirthOfDay() {
        return birthOfDay;
    }

    public void setBirthOfDay(LocalDate birthOfDay) {
        this.birthOfDay = birthOfDay;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthOfDay=" + birthOfDay +
                '}';
    }

}
