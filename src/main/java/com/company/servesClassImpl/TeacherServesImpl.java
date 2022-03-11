package com.company.servesClassImpl;
import com.company.DaoInterface.TeacherDao;
import com.company.dto.TeacherDto;
import com.company.model.Teacher;
import com.company.servesInterface.TeacherServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServesImpl  implements TeacherServes {

    private final TeacherDao teacherDao;

    @Autowired
    public TeacherServesImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getAllTeacher(long id) {
        return teacherDao.getAllTeacher(id);
    }

    @Override
    public Teacher findByID(long id) {
        return teacherDao.findByID(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        teacherDao.save(teacher);
        return teacher;
    }

    @Override
    public void updateTeacher(long id,Teacher teacher) {
        teacherDao.updateTeacher(id,teacher);
    }

    @Override
    public void deleteById(long id) {
        teacherDao.deleteById(id);
    }

    @Override
    public Teacher TeacherRequestCourse(TeacherDto teacherDto) {
        return teacherDao.TeacherRequestCourse(teacherDto);
    }
}
