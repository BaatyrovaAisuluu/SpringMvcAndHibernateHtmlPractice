package com.company.servesInterface;

import com.company.model.Company;

import java.util.List;

public interface CompanyServes {

    List<Company> getAllCompany();
    Company findByID(long id);
    Company save(Company company);
    void updateCompany(Company company);
    public void deleteById(long id);
}
