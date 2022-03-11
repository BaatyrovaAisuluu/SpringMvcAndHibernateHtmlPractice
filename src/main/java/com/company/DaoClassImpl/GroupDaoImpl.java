package com.company.DaoClassImpl;
import com.company.DaoInterface.GroupDao;
import com.company.dto.GroupDto;
import com.company.model.Course;
import com.company.model.Group;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Group> getAllGroup(long id) {
//         return (entityManager.createQuery("select gro from Group as gro where gro.id>=(:idCourse)",Group.class)
//                 .setParameter("idCourse",id).getResultList());
    //  return entityManager.createQuery("select  gro from Group gro",Group.class).getResultList();
//        List<Group>groups=entityManager.find(Course.class,id).getGroupList();
//        return groups;
        return entityManager.createQuery("select c.groupList from Course c where c.id = ?1")
                .setParameter(1,id).getResultList();


    }

    @Override
    public Group findByID(long id) {
        return entityManager.find(Group.class,id);
    }

    @Override
    public Group save(Group group) {
        entityManager.merge(group);
        return group;
    }

    @Override
    public void updateGroup(Group group) {
     entityManager.merge(group);
    }



    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Group.class,id));
    }

    @Override
    public Group groupRequestGroup(GroupDto groupDto) {
        Group group=new Group();
        group.setGroupName(groupDto.getGroupName());
        group.setDateOfStart(groupDto.getDateOfStart());
        group.setDateOfFinish(groupDto.getDateOfFinish());
        return group;
    }
}
