package com.company.servesInterface;

import com.company.dto.CourseRequest;
import com.company.model.Course;

import java.util.List;

public interface CoursServes {
    List<Course> getAllCourse(long id);
    Course findByID(long id);
    Course save(Course course);
    void updateCourse(Course course);
    void deleteById(long id);
    Course courseRequestToCourse(CourseRequest courseRequest);

}
