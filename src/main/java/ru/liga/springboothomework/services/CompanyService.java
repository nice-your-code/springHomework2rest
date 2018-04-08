package ru.liga.springboothomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.springboothomework.dao.CompanyDao;
import ru.liga.springboothomework.domain.Company;

import java.util.List;

@Component
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    // проверяет, есть ли Company с таким id в базе, если есть - вызывает update, если нет - insert
    public Company save(Company company){
        if(getById(company.getId()) != null){
            companyDao.update(company);
        }
        else{
            companyDao.insert(company);
        }
        return company;
    }
	public Company getById(Long id){
        return companyDao.getById(id);
    }
	public List<Company> getAll(){
        return companyDao.getAll();
    }
}
