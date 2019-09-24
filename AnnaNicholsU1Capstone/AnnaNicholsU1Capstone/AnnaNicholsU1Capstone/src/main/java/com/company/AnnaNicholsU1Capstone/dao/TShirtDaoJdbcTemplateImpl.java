package com.company.AnnaNicholsU1Capstone.dao;

import com.company.AnnaNicholsU1Capstone.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao{

    private static final String INSERT_T_SHIRT_SQL =
            "Insert into t_shirt(size, color, description, price, quantity) Values (?,?,?,?,?)";

    private static final String SELECT_T_SHIRT_SQL =
            "Select * From t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_T_SHIRTS_SQL =
            "Select * From t_shirt";

    private static final String UPDATE_T_SHIRT_SQL =
            "update t_shirt set size=?, color=?, description=?, price=?, quantity=?, t_shirt_id=?";

    private static final String DELETE_T_SHIRT_SQL =
            "delete from t_shirt where t_shirt_id=?";

    private static final String SELECT_T_SHIRTS_BY_COLOR_SQL =
            "select * from t_shirt where color = ?";

    private static final String SELECT_T_SHIRTS_BY_SIZE_SQL =
            "select * from t_shirt where size = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public TShirt addTShirt(TShirt tshirt) {

        jdbcTemplate.update(INSERT_T_SHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        tshirt.setId(id);

        return tshirt;
    }

    @Override
    public TShirt getTShirt(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_T_SHIRT_SQL, this::mapRowToTShirt, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<TShirt> getAllTShirts() {

        return jdbcTemplate.query(SELECT_ALL_T_SHIRTS_SQL, this::mapRowToTShirt);

    }

    @Override
    public void updateTShirt(TShirt tshirt) {

        jdbcTemplate.update(UPDATE_T_SHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity(),
                tshirt.getId());
    }

    @Override
    public void deleteTShirt(int id) {
        jdbcTemplate.update(DELETE_T_SHIRT_SQL, id);
    }

    @Override
    public List<TShirt> getByColor (String color){
        return jdbcTemplate.query(SELECT_T_SHIRTS_BY_COLOR_SQL, this::mapRowToTShirt, color);
    }

    @Override
    public List<TShirt> getBySize (String size){
        return jdbcTemplate.query(SELECT_T_SHIRTS_BY_SIZE_SQL, this::mapRowToTShirt, size);
    }

    private TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException {
        TShirt tshirt = new TShirt();

        tshirt.setId(rs.getInt("t_shirt_id"));
        tshirt.setSize(rs.getString("size"));
        tshirt.setColor(rs.getString("color"));
        tshirt.setDescription(rs.getString("description"));
        tshirt.setPrice(rs.getBigDecimal("price"));
        tshirt.setQuantity(rs.getBigDecimal("quantity"));

        return tshirt;
    }
}
