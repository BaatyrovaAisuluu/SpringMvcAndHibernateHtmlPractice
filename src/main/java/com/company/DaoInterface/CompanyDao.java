package com.company.DaoInterface;

import com.company.model.Company;

import java.util.List;

public interface  CompanyDao  {
    List<Company> getAllCompany();
    Company findByID(long id);
    Company save(Company company);
    void updateCompany(Company company);
    Company deleteCompany(Company company);
    public void deleteById(long id);


}
