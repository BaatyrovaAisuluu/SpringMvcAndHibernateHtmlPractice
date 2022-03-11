package com.company.DaoClassImpl;
import com.company.DaoInterface.TeacherDao;
import com.company.dto.TeacherDto;
import com.company.model.Teacher;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoImpl  implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Teacher> getAllTeacher(long id) {
        return entityManager.createQuery
                ("select teacher from Teacher teacher where teacher.course.id=:idCourse" ,Teacher.class)
                .setParameter("idCourse",id).getResultList();
    }

    @Override
    public Teacher findByID(long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        entityManager.merge(teacher);
        return teacher;
    }

    @Override
    public void updateTeacher(long id,Teacher teacher) {
        Teacher teacher1=findByID(id);
        teacher1.setTeacherFirstName(teacher.getTeacherFirstName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setStudyFormat(teacher.getStudyFormat());
        entityManager.merge(teacher);
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Teacher.class,id));
    }

    @Override
    public Teacher TeacherRequestCourse(TeacherDto teacherDto) {
        Teacher teacher=new Teacher();
        teacher.setTeacherFirstName(teacherDto.getTeacherFirstName());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setStudyFormat(teacherDto.getStudyFormat());
        return teacher;
    }
}
