package com.company.controller;
import com.company.dto.StudentRequest;
import com.company.model.Student;
import com.company.servesInterface.GroupServes;
import com.company.servesInterface.StudentServes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("student/{id}")
public class StudentController {

    private final GroupServes groupServes;
    private final StudentServes studentServes;

    public StudentController(GroupServes groupServes, StudentServes studentServes) {
        this.groupServes = groupServes;
        this.studentServes = studentServes;
    }

    @GetMapping
    public String getAllStudent(@PathVariable("id") long id, Model model) {
        model.addAttribute("getAllStudent", studentServes.getAllStudent(id));
        model.addAttribute("idGroup", id);
        return "student/getAllStudent";
    }

    @GetMapping("/newStudent")
    public String addStudent(Model model) {
        model.addAttribute("newStudent", new Student());
        return "student/newStudent";
    }

    @PostMapping("/saveStudent")
    public String createStudent(
            @ModelAttribute("newStudent") StudentRequest request, @PathVariable("id") long id) {
        Student student = studentServes.studentRequestTo(request);
        student.setGroup(groupServes.findByID(id));
        studentServes.save(student);
        return "redirect:/student/{id}";
    }

    @DeleteMapping("/delete/{idStudent}")
    public String deleteStudent(@PathVariable("idStudent") long idDelete) {
        studentServes.deleteById(idDelete);
        return "redirect:/student/{id}";
    }

    @GetMapping("{idStudent}/idUpdate")
    public String updateStudent(Model model, @PathVariable("idStudent") long id, @PathVariable("id") long idGroup) {
        model.addAttribute("updateStudent", studentServes.findByID(id));
        model.addAttribute("idGroup", idGroup);
        return "student/updateStudent";
    }

    @PatchMapping("/idUpdate/{idStudent}")
    public String mergeStudent(@ModelAttribute("updateStudent") Student student
            ,@PathVariable("id") long idGroup) {
        student.setGroup(groupServes.findByID(idGroup));
        studentServes.updateStudent(student);
        return "redirect:/student/{id}";
    }
}
