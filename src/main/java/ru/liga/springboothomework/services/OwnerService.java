package ru.liga.springboothomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.springboothomework.dao.OwnerDao;
import ru.liga.springboothomework.domain.Owner;

import java.util.List;

@Component
public class OwnerService {
    @Autowired
    private OwnerDao ownerDao;
    //проверяет, есть ли Owner с таким id в базе, если есть - вызывает update, если нет - insert
    public Owner save(Owner owner){
        if(getById(owner.getId()) != null){
            ownerDao.update(owner);
        }
        else{
            ownerDao.insert(owner);
        }
        return owner;
    }
	public Owner getById(Long id){
        return ownerDao.getById(id);
    }
	public List<Owner> getAll(){
        return ownerDao.getAll();
    }
	public List<Owner> getAllByCompanyId(Long companyId){
        return ownerDao.getAllByCompanyId(companyId);
    }
}
