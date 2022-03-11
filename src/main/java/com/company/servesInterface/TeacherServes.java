package com.company.servesInterface;


import com.company.dto.TeacherDto;
import com.company.model.Teacher;

import java.util.List;

public interface TeacherServes {
    List<Teacher> getAllTeacher(long id);
    Teacher findByID(long id);
    Teacher save(Teacher teacher);
    void updateTeacher(long id,Teacher teacher);
    void deleteById(long id);
    Teacher TeacherRequestCourse(TeacherDto teacherDto);


}
