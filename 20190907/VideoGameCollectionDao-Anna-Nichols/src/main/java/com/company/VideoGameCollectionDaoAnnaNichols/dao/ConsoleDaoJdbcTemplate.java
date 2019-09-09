package com.company.VideoGameCollectionDaoAnnaNichols.dao;

import com.company.VideoGameCollectionDaoAnnaNichols.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplate implements ConsoleDao {

    private static final String INSERT_CONSOLE_SQL =
            "Insert into console(name, year) Values (?,?)";

    private static final String SELECT_CONSOLE_SQL =
            "Select * From console where console_id = ?";

    private static final String SELECT_ALL_CONSOLES_SQL =
            "Select * From console";

    private static final String UPDATE_CONSOLE_SQL =
            "update console set name=?, year=?, console_id=?";

    private static final String DELETE_CONSOLE_SQL =
            "delete from console where console_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsoleDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Console addConsole(Console console) {

        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                console.getName(),
                console.getYear());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        console.setId(id);

        return console;
    }

    @Override
    public Console getConsole(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<Console> getAllConsoles() {

        return jdbcTemplate.query(SELECT_ALL_CONSOLES_SQL, this::mapRowToConsole);

    }

    @Override
    public void updateConsole(Console console) {

        jdbcTemplate.update(UPDATE_CONSOLE_SQL,
                console.getName(),
                console.getYear(),
                console.getId());
    }

    @Override
    public void deleteConsole(int id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, id);
    }

    private Console mapRowToConsole(ResultSet rs, int rowNum) throws SQLException {
        Console console = new Console();

        console.setId(rs.getInt("console_id"));
        console.setName(rs.getString("name"));
        console.setYear(rs.getString("year"));

        return console;
    }
}
