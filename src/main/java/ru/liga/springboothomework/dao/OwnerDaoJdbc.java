package ru.liga.springboothomework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.liga.springboothomework.domain.Owner;

import java.util.List;

@Component
public class OwnerDaoJdbc implements OwnerDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Owner getById(Long id){
        try {
            return jdbcTemplate.query("SELECT * FROM owner WHERE id = ?", new OwnerRowMapper(), id).get(0);
        }
        catch (Exception exc){
            return null;
        }
    }
    public List<Owner> getAll(){
        return jdbcTemplate.query("SELECT * FROM owner", new OwnerRowMapper());
    }
    public List<Owner> getAllByCompanyId(Long companyId){
        return jdbcTemplate.query("SELECT * FROM owner WHERE company_id = ?", new OwnerRowMapper(), companyId);
    }
    public void insert(Owner owner){
        jdbcTemplate.update("INSERT INTO owner (id, company_id, first_name, second_name) VALUES (?,?,?,?)",
                owner.getId(), owner.getCompanyId(), owner.getFirstName(), owner.getSecondName());
    }
    public void update(Owner owner){
        jdbcTemplate.update("UPDATE owner SET company_id = ?, first_name = ?, second_name = ? WHERE id = ?",
                owner.getCompanyId(), owner.getFirstName(), owner.getSecondName(), owner.getId());
    }
}
