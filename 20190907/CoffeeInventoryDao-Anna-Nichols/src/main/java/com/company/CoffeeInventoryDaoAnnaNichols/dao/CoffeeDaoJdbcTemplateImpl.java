package com.company.CoffeeInventoryDaoAnnaNichols.dao;

import com.company.CoffeeInventoryDaoAnnaNichols.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeDaoJdbcTemplateImpl implements CoffeeDao {

    private static final String INSERT_COFFEE_SQL =
            "Insert into coffee(roaster_id, name, count, unit_price, description, type) values (?,?,?,?,?,?)";

    private static final String SELECT_COFFEE_SQL =
            "Select * From coffee where coffee_id = ?";

    private static final String SELECT_ALL_COFFEES_SQL =
            "Select * From coffee";

    private static final String UPDATE_COFFEE_SQL =
            "update coffee set roaster_id=?, name=?, count=?, unit_price=?, description=?, type=?, coffee_id=?";

    private static final String SELECT_COFFEE_BY_TYPE_SQL =
            "Select * From coffee where type=?";

    private static final String SELECT_COFFEE_BY_ROASTER_SQL =
            "Select * From coffee where roaster_id=?";

    private static final String DELETE_COFFEE_SQL =
            "delete from coffee where coffee_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CoffeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Coffee addCoffee(Coffee coffee) {
        jdbcTemplate.update(INSERT_COFFEE_SQL,
                coffee.getRoasterId(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnitPrice(),
                coffee.getDescription(),
                coffee.getType());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        coffee.setId(id);
        return coffee;
    }

    @Override
    public Coffee getCoffee(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COFFEE_SQL, this::mapRowToCoffee, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Coffee> getCoffeeByRoaster(int roasterId) {

        return jdbcTemplate.query(SELECT_COFFEE_BY_ROASTER_SQL, this::mapRowToCoffee, roasterId);
    }

    @Override
    public List<Coffee> getCoffeeByType(String type) {

        return jdbcTemplate.query(SELECT_COFFEE_BY_TYPE_SQL, this::mapRowToCoffee, type);

    }

    @Override
    public List<Coffee> getAllCoffees() {

        return jdbcTemplate.query(SELECT_ALL_COFFEES_SQL, this::mapRowToCoffee);
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        jdbcTemplate.update(UPDATE_COFFEE_SQL,
                coffee.getRoasterId(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnitPrice(),
                coffee.getDescription(),
                coffee.getType(),
                coffee.getId());
    }

    @Override
    public void deleteCoffee(int id) {
        jdbcTemplate.update(DELETE_COFFEE_SQL, id);
    }

    private Coffee mapRowToCoffee(ResultSet rs, int rowNum) throws SQLException {
        Coffee coffee = new Coffee();

        coffee.setId(rs.getInt("coffee_id"));
        coffee.setRoasterId(rs.getInt("roaster_id"));
        coffee.setName(rs.getString("name"));
        coffee.setCount(rs.getInt("count"));
        coffee.setUnitPrice(rs.getDouble("unit_price"));
        coffee.setCount(rs.getInt("count"));

        return coffee;
    }
}
