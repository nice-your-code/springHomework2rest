package ru.liga.springboothomework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.springboothomework.domain.Account;
import ru.liga.springboothomework.services.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/all")
    List<Account> findAll(){
        return accountService.getAll();
    }
	@GetMapping("/{id}")
    Account findById(@PathVariable("id") Long id){
        return accountService.getById(id);
    }
	@PostMapping("/save")
    Account save(@RequestBody Account person){
        return accountService.save(person);
    }
}
