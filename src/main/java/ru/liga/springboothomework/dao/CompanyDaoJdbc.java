package ru.liga.springboothomework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.liga.springboothomework.domain.Company;

import java.util.List;

@Component
public class CompanyDaoJdbc implements CompanyDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Company getById(Long id){
        try {
            return jdbcTemplate.query("SELECT * FROM company WHERE id = ?", new CompanyRowMapper(), id).get(0);
        }
        catch(Exception exc){
            return null;
        }
    }
    public List<Company> getAll(){
        return jdbcTemplate.query("SELECT * FROM company", new CompanyRowMapper());
    }
    public void insert(Company company){
        jdbcTemplate.update("INSERT INTO company (id, title) VALUES (?,?)",
                company.getId(), company.getTitle());
    }
    public void update(Company company){
        jdbcTemplate.update("UPDATE company SET title = ? WHERE id = ?",
                company.getTitle(), company.getId());
    }
}
