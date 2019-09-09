package com.company.VideoGameCollectionDaoAnnaNichols.dao;

import com.company.VideoGameCollectionDaoAnnaNichols.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TypeDaoJdbcTemplate implements TypeDao {
    private static final String INSERT_TYPE_SQL =
            "Insert into type(name, description) Values (?,?)";

    private static final String SELECT_TYPE_SQL =
            "Select * From type where type_id = ?";

    private static final String SELECT_ALL_TYPES_SQL =
            "Select * From type";

    private static final String UPDATE_TYPE_SQL =
            "update type set name=?, description=?, type_id=?";

    private static final String DELETE_TYPE_SQL =
            "delete from type where type_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TypeDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Type addType(Type type) {

        jdbcTemplate.update(INSERT_TYPE_SQL,
                type.getName(),
                type.getDescription());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        type.setId(id);

        return type;
    }

    @Override
    public Type getType(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_TYPE_SQL, this::mapRowToType, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<Type> getAllTypes() {

        return jdbcTemplate.query(SELECT_ALL_TYPES_SQL, this::mapRowToType);

    }

    @Override
    public void updateType(Type type) {

        jdbcTemplate.update(UPDATE_TYPE_SQL,
                type.getName(),
                type.getDescription(),
                type.getId());
    }

    @Override
    public void deleteType(int id) {
        jdbcTemplate.update(DELETE_TYPE_SQL, id);
    }

    private Type mapRowToType(ResultSet rs, int rowNum) throws SQLException {
        Type type = new Type();

        type.setId(rs.getInt("type_id"));
        type.setName(rs.getString("name"));
        type.setDescription(rs.getString("description"));


        return type;
    }
}
