package ru.liga.springboothomework.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.springboothomework.domain.Company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRowMapper implements RowMapper <Company> {
    @Override
    public Company mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong(1);
        String title = resultSet.getString(2);
        return new Company(id, title);
    }
}
