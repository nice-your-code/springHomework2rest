package ru.liga.springboothomework.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.springboothomework.domain.Owner;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerRowMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong(1);
        Long companyId = resultSet.getLong(2);
        String firstName = resultSet.getString(3);
        String secondName = resultSet.getString(4);
        return new Owner(id, companyId, firstName, secondName);
    }
}
