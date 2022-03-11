package com.company.servesClassImpl;

import com.company.DaoInterface.GroupDao;
import com.company.dto.GroupDto;
import com.company.model.Group;
import com.company.servesInterface.GroupServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GroupServesImpl  implements GroupServes {

    private final GroupDao groupDao;

    @Autowired
    public GroupServesImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Group> getAllGroup(long id) {
        return groupDao.getAllGroup(id);
    }

    @Override
    public Group findByID(long id) {
        return groupDao.findByID(id);
    }

    @Override
    public Group save(Group group) {
        return groupDao.save(group);
    }

    @Override
    public void updateGroup(Group group) {
        groupDao.updateGroup(group);
    }

    @Override
    public void deleteById(long id) {
        groupDao.deleteById(id);
    }

    @Override
    public Group groupRequestGroup(GroupDto groupDto) {
        return groupDao.groupRequestGroup(groupDto);
    }
}
