package com.company.DaoClassImpl;
import com.company.DaoInterface.CourseDao;
import com.company.model.Course;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Course> getAllCourse(long companyId) {
        return entityManager.createQuery("select s from Course s where s.company.id=:companyId",Course.class).setParameter("companyId",companyId).getResultList();

    }

    @Override
    public Course findByID(long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    public Course save(Course course) {
        entityManager.merge(course);
        return course;
    }

    @Override
    public void updateCourse(Course course) {

       entityManager.merge(course);
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }

    }