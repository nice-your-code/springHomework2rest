package ru.liga.springboothomework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.liga.springboothomework.domain.Account;

import java.util.List;

@Component
public class AccountDaoJdbc implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Account getById(Long id){
        try {
            return jdbcTemplate.query("SELECT * FROM account WHERE id = ?", new AccountRowMapper(), id).get(0);
        }
        catch (Exception exc){
            return null;
        }
    }
    public List<Account> getAll(){
        return jdbcTemplate.query("SELECT * FROM account", new AccountRowMapper());
    }
    public List<Account> getAllByOwnerId(Long ownerId){
        return jdbcTemplate.query("SELECT * FROM account WHERE owner_id = ?", new AccountRowMapper(), ownerId);
    }
    public Account insert(Account account){
        jdbcTemplate.update("INSERT INTO account (id, owner_id, name, rate) VALUES (?, ?, ?, ?)",
                account.getId(), account.getOwnerId(), account.getName(), account.getRate());
        return account;
    }
    public Account update(Account account){
        jdbcTemplate.update("UPDATE account SET owner_id = ?, name = ?, rate = ? WHERE id = ?",
                account.getOwnerId(), account.getName(), account.getRate(), account.getId());
        return  account;
    }
}
