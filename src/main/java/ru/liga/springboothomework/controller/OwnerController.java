package ru.liga.springboothomework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.springboothomework.dao.OwnerDao;
import ru.liga.springboothomework.domain.Account;
import ru.liga.springboothomework.domain.Owner;
import ru.liga.springboothomework.services.AccountService;
import ru.liga.springboothomework.services.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private AccountService accountService;
    @GetMapping("/all")
    List<Owner> findAll(){
        return ownerService.getAll();
    }
	@GetMapping("/{id}")
    Owner findById(@PathVariable("id") Long id){
        return  ownerService.getById(id);
    }
	@PostMapping("/save")
    Owner save(@RequestBody Owner owner){
        return ownerService.save(owner);
    }
	@GetMapping("/{id}/accounts")
    List<Account> findAccountsByOwnerId(@PathVariable("id") Long id){
        return accountService.getAllByOwnerId(id);
    }
}
