package com.company.DaoInterface;
import com.company.dto.GroupDto;
import com.company.model.Group;

import java.util.List;


public interface GroupDao {
    List<Group> getAllGroup(long id);
    Group findByID(long id);
    Group save(Group group);
    void updateGroup(Group group);
    void deleteById(long id);
    Group groupRequestGroup(GroupDto groupDto);


}
