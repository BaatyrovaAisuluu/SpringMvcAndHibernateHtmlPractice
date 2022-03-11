package com.company.DaoClassImpl;

import com.company.DaoInterface.StudentDao;
import com.company.model.Student;
import com.company.servesInterface.StudentServes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudent(long id) {
        return entityManager.createQuery(
                "select stu from Student stu where stu.group.id=:id",Student.class).
                setParameter("id",id).getResultList();
    }

    @Override
    public Student findByID(long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void updateStudent(Student student) {
     entityManager.merge(student);
    }

    @Override
    public void deleteById(long id) {
    entityManager.remove(entityManager.find(Student.class,id));
    }
}
