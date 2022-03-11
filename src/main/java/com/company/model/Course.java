package com.company.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private long id;

    @NotEmpty(message = "courseName  should not be empty")
    @Size(min = 3, max = 15, message = "courseName should be between 3 and 15 characters")
    private String courseName;

    @NotEmpty(message = "format mm")
    private String duration;

    @ManyToMany(cascade = {MERGE,REMOVE,PERSIST,REFRESH,DETACH},fetch = FetchType.LAZY,mappedBy = "course")
//    @JoinTable(name = "courses_groups",
//            joinColumns = @JoinColumn(name = "groups_id"),inverseJoinColumns
//            = @JoinColumn(name = "course_id"))

    private List<Group> groupList;

    @OneToOne(cascade = {MERGE,REMOVE,DETACH,MERGE},mappedBy = "course",fetch = FetchType.EAGER)
    private Teacher teacher;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "company_id")
    private Company company;

    public Course() {
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}

