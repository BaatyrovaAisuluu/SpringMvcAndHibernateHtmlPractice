package com.company.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private long id;

    @NotEmpty(message = "companyName should not be empty")
    @Size(min = 1, max = 25, message = "companyName should be between 2 and 25 characters")
    private String companyName;

    @NotEmpty(message = "LocatedCountry should not be empty")
    @Size(min = 1, max = 25, message = "locatedCountry should be between 2 and 25 characters")
    private String locatedCountry;

    @OneToMany(cascade ={ MERGE, REMOVE, REFRESH, DETACH, PERSIST},mappedBy = "company")
    private List<Course> courseList;

    public Company() {
    }

    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocatedCountry() {
        return locatedCountry;
    }

    public void setLocatedCountry(String locatedCountry) {
        this.locatedCountry = locatedCountry;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locatedCountry='" + locatedCountry + '\'' +
                '}';
    }
}