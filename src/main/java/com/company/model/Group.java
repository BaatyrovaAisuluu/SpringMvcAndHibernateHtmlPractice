package com.company.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
public class Group {

   @Id
   @SequenceGenerator(
           name = "group_sequence",
           sequenceName = "group_sequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "group_sequence"
   )
    private long id;
    @NotEmpty(message = "groupName should not be empty")
    @Size(min = 2,max = 10,message = "groupName should be between 2 and 10 characters")
    private String groupName;


    private String dateOfStart;
    private String dateOfFinish;

    @ManyToMany(cascade ={MERGE,REFRESH,PERSIST},fetch = FetchType.EAGER)
    @JoinTable(name = "courses_groups",
            joinColumns = @JoinColumn(name = "groups_id"),inverseJoinColumns
            = @JoinColumn(name = "course_id"))
    private List<Course>course;

    @OneToMany(cascade = ALL,mappedBy = "group")
    private List<Student>studentList;

    public Group() {
    }

    public Group( String groupName, String dateOfStart, String dateOfFinish) {

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

    public String getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(String dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfFinish(String dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setCourseList(List<Course> courseList) {
        this.course = courseList;
    }

    public List<Course> getCourseList() {
        return course;
    }
    public void getCourse(Course course){
        if(this.course==null){
            this.course=new ArrayList<>();
        }
        this.course.add(course);
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", dateOfStart='" + dateOfStart + '\'' +
                ", dateOfFinish='" + dateOfFinish + '\'' +
                '}';
    }
}
