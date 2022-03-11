package com.company.controller;
import com.company.dto.TeacherDto;
import com.company.model.Teacher;
import com.company.servesInterface.CoursServes;
import com.company.servesInterface.TeacherServes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("teacher/{id}")
public class TeacherController {

    private final CoursServes courseService;
    private final TeacherServes teacherServes;

    public TeacherController(CoursServes courseService, TeacherServes teacherServes) {
        this.courseService = courseService;
        this.teacherServes = teacherServes;
    }

    @GetMapping
    public String coursesOfTeacher(@PathVariable("id") long id, Model model) {

        model.addAttribute("getAllTeacher", teacherServes.getAllTeacher(id));
        model.addAttribute("idCourse", id);
        return "teacher/getAllTeacher";
    }

    @GetMapping("/newTeacher")
    public String mewTeacher(Model model) {
        model.addAttribute("newTeacher", new Teacher());
        return "teacher/newTeacher";
    }

    @PostMapping("/saveTeacher")
    public String createTeacher(@ModelAttribute("newTeacher")TeacherDto teacherDto, @PathVariable("id") long id) throws Exception {
        if(courseService.findByID(id).getTeacher()==null) {
            Teacher teacher = teacherServes.TeacherRequestCourse(teacherDto);
            teacher.setCourse(courseService.findByID(id));
            teacherServes.save(teacher);
        }else {
            throw new Exception("not found");
        }
        return "redirect:/teacher/{id}";
    }

    @DeleteMapping("/delete/{idTeacher}")
    public String deleteTeacher(@PathVariable("idTeacher") long idDelete) {
        courseService.deleteById(idDelete);
        return "redirect:/teacher/{id}";
    }

    @GetMapping("{idTeacher}/idUpdate")
    public String updateCourse(Model model, @PathVariable("idTeacher") long id, @PathVariable("id") long id1) {
        model.addAttribute("updateTeacher", teacherServes.findByID(id));
        model.addAttribute("idCourse", id1);
        return "teacher/updateTeacher";
    }

    @PatchMapping("/idUpdate/{idTeacher}")
    public String mergeCourse(@ModelAttribute("updateTeacher") Teacher teacher,@PathVariable("id") long idCourse) {
        teacher.setCourse(courseService.findByID(idCourse));
        teacherServes.updateTeacher(idCourse,teacher);
        return "redirect:/teacher/{id}";
    }

}
