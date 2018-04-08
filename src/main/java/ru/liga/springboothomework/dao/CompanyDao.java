package ru.liga.springboothomework.dao;

import ru.liga.springboothomework.domain.Company;

import java.util.List;

public interface CompanyDao {
    Company getById(Long id);
	List<Company> getAll();
	void insert(Company company);
	void update(Company company);
}
