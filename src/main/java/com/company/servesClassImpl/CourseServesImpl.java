package com.company.servesClassImpl;

import com.company.DaoInterface.CourseDao;
import com.company.dto.CourseRequest;
import com.company.model.Course;
import com.company.servesInterface.CoursServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServesImpl implements CoursServes {


    private CourseDao courseDao;

    @Autowired
    public CourseServesImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourse( long id) {
        return courseDao.getAllCourse(id);
    }

    @Override
    public Course findByID(long id) {
        return courseDao.findByID(id);
    }

    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    public void updateCourse(Course course) {
          courseDao.updateCourse(course);
    }

    @Override
    public void deleteById(long id) {
       courseDao.deleteById(id);
    }
    @Override
    public Course courseRequestToCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        return course;
    }

}
