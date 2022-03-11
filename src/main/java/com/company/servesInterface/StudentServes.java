package com.company.servesInterface;

import com.company.dto.StudentRequest;
import com.company.model.Student;

import java.util.List;

public interface StudentServes {

    List<Student> getAllStudent(long id);
    Student findByID(long id);
    Student save(Student student);
    void updateStudent(Student student);
    void deleteById(long id);
    Student studentRequestTo(StudentRequest studentRequest);
}
