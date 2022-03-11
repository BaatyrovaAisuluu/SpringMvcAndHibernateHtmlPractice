package com.company.DaoClassImpl;
import com.company.DaoInterface.CompanyDao;
import com.company.model.Company;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompany() {
        return entityManager.createQuery("select s from Company s", Company.class).getResultList();
    }

    @Override
    public Company findByID(long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public Company save(Company company) {
        entityManager.persist(company);
        return company;
    }

    @Override
    public void updateCompany(Company company) {
        entityManager.merge(company);
    }

    @Override
    public Company deleteCompany(Company company) {
        entityManager.remove(company);
        return company;
    }

    @Override
    public void deleteById(long id) {
        deleteCompany(findByID(id));
    }
}
