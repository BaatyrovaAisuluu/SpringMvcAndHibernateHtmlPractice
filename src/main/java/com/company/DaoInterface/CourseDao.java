package com.company.DaoInterface;
import com.company.model.Course;
import java.util.List;
public interface CourseDao {
    List<Course> getAllCourse(long companyId);
    Course findByID(long id);
    Course save(Course course);
    void updateCourse(Course course);
     void deleteById(long id);

}
