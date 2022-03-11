package com.company.controller;
import com.company.dto.CourseRequest;
import com.company.model.Course;
import com.company.servesInterface.CompanyServes;
import com.company.servesInterface.CoursServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course/{id}")
public class CourseController {

    private final CoursServes courseService;
    private final CompanyServes companyService;

    @Autowired
    public CourseController(CoursServes courseService, CompanyServes companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping
    public String coursesOfCompany(@PathVariable("id") long id, Model model) {
        model.addAttribute("getAllCourse", courseService.getAllCourse(id));
        model.addAttribute("idCompany", id);
        return "course/getAllCourse";
    }

    @GetMapping("/newCourse")
    public String addCourses(Model model) {
        model.addAttribute("newCourse", new Course());
        return "course/newCourse";
    }

    @PostMapping("/saveCourse")
    public String createCourses(@ModelAttribute("newCourse") CourseRequest course, @PathVariable("id") long id) {
        Course course1 = courseService.courseRequestToCourse(course);
        course1.setCompany(companyService.findByID(id));
        courseService.save(course1);
        return "redirect:/course/{id}";
    }

    @DeleteMapping("/delete/{idDelete}")
    public String deleteCourse(@PathVariable("idDelete") long idDelete) {
        courseService.deleteById(idDelete);
        return "redirect:/course/{id}";
    }

    @GetMapping("{idUpdate}/idUpdate")
    public String updateCourse(Model model, @PathVariable("idUpdate") long id, @PathVariable("id") long id1) {
        model.addAttribute("updateCourse", courseService.findByID(id));
        model.addAttribute("idCompany", id1);
        return "course/updateCourse";
    }

    @PatchMapping("/update/{idMerge}")
    public String mergeCourse(@ModelAttribute("updateCourse") Course course, @PathVariable("idMerge") long id, @PathVariable("id") long companyId) {
        course.setId(id);
        course.setCompany(companyService.findByID(companyId));
        courseService.updateCourse(course);
        return "redirect:/course/{id}";
    }

}





