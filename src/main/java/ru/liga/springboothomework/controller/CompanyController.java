package ru.liga.springboothomework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.springboothomework.domain.Company;
import ru.liga.springboothomework.domain.Owner;
import ru.liga.springboothomework.services.CompanyService;
import ru.liga.springboothomework.services.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private OwnerService ownerService;
    @GetMapping("/all")
    public List<Company> findAll(){
        return companyService.getAll();
    }
	@GetMapping("/{id}")
    public Company findById(@PathVariable("id") Long id){
	    return companyService.getById(id);
    }
	@PostMapping("/save")
    public Company save(@RequestBody Company company){
	    return companyService.save(company);
    }
	@GetMapping("/{id}/owners")
    public List<Owner> findOwnersByCompanyId(@PathVariable("id") Long id){
        return ownerService.getAllByCompanyId(id);
    }
}
