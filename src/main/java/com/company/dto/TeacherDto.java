package com.company.dto;

import com.company.model.studyFormat;

public class TeacherDto {

    private String TeacherFirstName;
    private String email;
    private String lastName;
    private studyFormat studyFormat;

    public com.company.model.studyFormat getStudyFormat() {
        return studyFormat;
    }

    public void setStudyFormat(com.company.model.studyFormat studyFormat) {
        this.studyFormat = studyFormat;
    }

    public String getTeacherFirstName() {
        return TeacherFirstName;
    }

    public void setTeacherFirstName(String TeacherFirstName) {
        this.TeacherFirstName = TeacherFirstName;
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
}
