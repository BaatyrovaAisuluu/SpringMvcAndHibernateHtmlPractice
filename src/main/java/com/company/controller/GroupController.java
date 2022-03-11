package com.company.controller;
import com.company.dto.GroupDto;
import com.company.model.Group;
import com.company.servesInterface.CoursServes;
import com.company.servesInterface.GroupServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("groups/{id}")
public class GroupController {

    private final GroupServes groupServes;
    private final CoursServes coursServes;

    @Autowired
    public GroupController(GroupServes groupServes, CoursServes coursServes) {
        this.groupServes = groupServes;
        this.coursServes = coursServes;
    }

    @GetMapping
    public String getAllGroup(@PathVariable("id") long id, Model model) {
        model.addAttribute("getAllGroup", groupServes.getAllGroup(id));
        model.addAttribute("course_Id", id);
        return "group/getAllGroup";
    }

    @GetMapping("/newGroup")
    public String createGroups( Model model) {
        model.addAttribute("courseGroup", new Group());
        return "group/newGroup";
    }

    @PostMapping("/saveGroup")
    public String createGroup(@ModelAttribute("courseGroup") GroupDto groupDto, @PathVariable("id") long id) {
        Group group = groupServes.groupRequestGroup(groupDto);
        group.setCourseList(coursServes.getAllCourse(id));
        groupServes.save(group);
        return "redirect:/groups/{id}";
    }

    @GetMapping("/{id1}/edit")
    public String edit(Model model, @PathVariable("id1") long id , @PathVariable("id") long id1) {
        model.addAttribute("updateGroup", groupServes.findByID(id));
        model.addAttribute("updateIdCourse", id1);
        return "group/updateGroup";
    }

    @PatchMapping("/edit/{idUpdate}")
    public String updateGroup(@ModelAttribute("updateGroup")
                                         GroupDto groupDto,@PathVariable("idUpdate")long id,
                              @PathVariable("id")long idCourse) {
        Group group=groupServes.groupRequestGroup(groupDto);
       group.setCourseList(coursServes.getAllCourse(idCourse));
        groupServes.updateGroup(group);
        return "redirect:/groups/{id}";
    }

    @DeleteMapping("delete/{id}")
    public String deleteGroup(@PathVariable("id") long id) {
        groupServes.deleteById(id);
        return "redirect:/groups/{id}";
    }

}
