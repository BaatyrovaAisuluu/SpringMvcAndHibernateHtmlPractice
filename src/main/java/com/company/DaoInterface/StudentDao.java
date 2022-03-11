package com.company.DaoInterface;

import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent(long id);
     Student findByID(long id);
    Student save(Student student);
    void updateStudent(Student student);
    void deleteById(long id);
}
