package com.company.servesClassImpl;

import com.company.DaoInterface.CompanyDao;
import com.company.model.Company;
import com.company.servesInterface.CompanyServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyServesImpl implements CompanyServes {

   private final CompanyDao companyDao;

   @Autowired
    public CompanyServesImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }


    @Override
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Override
    public Company findByID(long id) {
        return companyDao.findByID(id);
    }

    @Override
    public Company save(Company company) {
        return companyDao.save(company);

    }

    @Override
    public void updateCompany(Company company) {
         companyDao.updateCompany(company);
    }

    @Override
    public void deleteById(long id) {
        companyDao.deleteById(id);
    }


}
