package com.company.DaoInterface;

import com.company.dto.GroupDto;
import com.company.dto.TeacherDto;
import com.company.model.Course;
import com.company.model.Group;
import com.company.model.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeacher(long id);
    Teacher findByID(long id);
    Teacher save(Teacher teacher);
    void updateTeacher(long id,Teacher teacher);
    void deleteById(long id);
    Teacher TeacherRequestCourse(TeacherDto teacherDto);

}
