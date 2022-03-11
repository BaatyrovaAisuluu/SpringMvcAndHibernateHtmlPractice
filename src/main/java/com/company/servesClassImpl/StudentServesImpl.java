package com.company.servesClassImpl;
import com.company.DaoInterface.StudentDao;
import com.company.dto.StudentRequest;
import com.company.model.Student;
import com.company.servesInterface.StudentServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServesImpl  implements StudentServes {

    private final StudentDao studentDao;

    @Autowired
    public StudentServesImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudent(long id) {
        return studentDao.getAllStudent(id) ;
    }

    @Override
    public Student findByID(long id) {
        return studentDao.findByID(id);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void updateStudent(Student student) {
     studentDao.updateStudent(student);
    }

    @Override
    public void deleteById(long id) {
    studentDao.deleteById(id);
    }

    @Override
    public Student studentRequestTo(StudentRequest studentRequest) {
        Student student=new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setEmail(studentRequest.getEmail());
        student.setLastName(studentRequest.getLastName());
        return student;
    }
}
