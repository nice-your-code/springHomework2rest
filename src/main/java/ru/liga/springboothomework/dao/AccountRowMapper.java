package ru.liga.springboothomework.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.springboothomework.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong(1);
        Long ownerId = resultSet.getLong(2);
        String name = resultSet.getString(3);
        Double rate = resultSet.getDouble(4);
        return new Account(id, ownerId, name, rate);
    }
}
