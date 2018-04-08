package ru.liga.springboothomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.springboothomework.dao.AccountDao;
import ru.liga.springboothomework.domain.Account;

import java.util.List;

@Component
public class AccountService {
    @Autowired
    private AccountDao accountDao;
    //проверяет, есть ли Account с таким id в базе, если есть - вызывает update, если нет - insert
    public Account save(Account account){
        if(getById(account.getId()) != null){
            accountDao.update(account);
        }
        else{
            accountDao.insert(account);
        }
        return account;
    }
	public Account getById(Long id){
        return accountDao.getById(id);
    }
	public List<Account> getAll(){
        return accountDao.getAll();
    }
	public List<Account> getAllByOwnerId(Long ownerId){
        return accountDao.getAllByOwnerId(ownerId);
    }
}
