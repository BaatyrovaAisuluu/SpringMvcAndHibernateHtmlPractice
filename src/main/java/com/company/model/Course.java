package com.company.model;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotEmpty(message = "courseName  should not be empty")
    @Size(min = 3,max = 15,message = "courseName should be between 3 and 15 characters")
    private String courseName;

    @DateTimeFormat(pattern = "mm")
    @Past(message = "duration field is mandatory / format mm")
    @Size(min = 1,max =12,message = "duration should be between 1 and 12 months")
    private Date duration;

    @ManyToMany(cascade ={DETACH,REFRESH,MERGE, PERSIST})
    private List<Group> groupList;

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Student> studentList;

    @OneToOne(mappedBy = "course")
    private Teacher teacher;

    public Course() {
    }

    public Course(String courseName, Date duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                '}';
    }
}
