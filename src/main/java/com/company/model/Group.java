package com.company.model;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotEmpty(message = "groupName should not be empty")
    @Size(min = 2,max = 10,message = "groupName should be between 2 and 10 characters")
    private String groupName;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Past(message = "Date field is mandatory / format dd-mm-yyyy")
    private Date dateOfStart;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Past(message = "Date field is mandatory / format dd-mm-yyyy")
    private Date dateOfFinish;

    @ManyToMany(cascade ={DETACH,REFRESH,MERGE, PERSIST},fetch = FetchType.LAZY,mappedBy = "groupList")
    private List<Course>courseList;

    public Group() {
    }

    public Group(String groupName, Date dateOfStart, Date dateOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Date getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfFinish(Date dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateOfFinish=" + dateOfFinish +
                '}';
    }
}
