package com.company.model;
import javax.persistence.*;
import javax.validation.constraints.*;
import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "students")
public class Student {

   @Id
  @SequenceGenerator(
           name = "student_sequence",
          sequenceName = "student_sequence",
         allocationSize = 1
   )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,generator = "student_sequence"
    )
    private long id;

    @NotEmpty(message = "firstName should not be empty")
    @Size(min = 1, max = 25, message = "firstName should be between 2 and 25 characters")
    private String firstName;

    @Column(name = "student_email")
    @Email(message = "email must follow the formatter: ***@*** ")
    @NotBlank(message = "Email must have a value")
    private String email;

    @Column(name = "student_last_name")
    @NotEmpty(message = "lastName should not be empty")
    @Size(min = 1, max = 25, message = "lastName should be between 2 and 25 characters")
    private String lastName;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE,PERSIST})
    private Group group;

    public Student() {
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
