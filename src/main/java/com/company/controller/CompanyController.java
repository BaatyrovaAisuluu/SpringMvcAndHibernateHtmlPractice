package com.company.controller;

import com.company.model.Company;
import com.company.servesInterface.CompanyServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyServes companyDao;

    @Autowired
    public CompanyController(CompanyServes companyDao) {
        this.companyDao = companyDao;
    }

    @GetMapping
    public String getAllCompany(Model model) {
        model.addAttribute("getAllCompany", companyDao.getAllCompany());
        return "company/getAllCompany";
    }

    @GetMapping("/show/{id}")
    public String showCompany(@PathVariable("id") long id, Model model) {
        model.addAttribute("showCompany", companyDao.findByID(id));
        return "company/showCompany";
    }

    @GetMapping("/newCompany")
    public String newCompany(Model model) {
        model.addAttribute("newCompany", new Company());
        return "company/newCompany";
    }

    @PostMapping("/save")
    public String createCompany(@ModelAttribute("newCompany") @Valid Company company, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "company/newCompany";

        companyDao.save(company);
        return "redirect:/companies";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("updateCompany", companyDao.findByID(id));
        return "company/updateCompany";
    }

    @PatchMapping("edit/{id}")
    public String updateCompany(@ModelAttribute("updateCompany") Company company, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "company/updateCompany";

        companyDao.updateCompany(company);
        return "redirect:/companies";
    }

    @DeleteMapping("delete/{id}")
    public String deleteCompany(@PathVariable("id") long id) {
        companyDao.deleteById(id);
        return "redirect:/companies";
    }

}
