package com.company.VideoGameCollectionDaoAnnaNichols.dao;

import com.company.VideoGameCollectionDaoAnnaNichols.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcTemplate implements PublisherDao {

    private static final String INSERT_PUBLISHER_SQL =
            "Insert into publisher(name, website) Values (?,?)";

    private static final String SELECT_PUBLISHER_SQL =
            "Select * From publisher where publisher_id = ?";

    private static final String SELECT_ALL_PUBLISHERS_SQL =
            "Select * From publisher";

    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set name=?, website=?, publisher_id=?";

    private static final String DELETE_PUBLISHER_SQL =
            "delete from publisher where publisher_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PublisherDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Publisher addPublisher(Publisher publisher) {

        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getWebsite());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        publisher.setId(id);

        return publisher;
    }

    @Override
    public Publisher getPublisher(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<Publisher> getAllPublishers() {

        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL, this::mapRowToPublisher);

    }

    @Override
    public void updatePublisher(Publisher publisher) {

        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getWebsite(),
                publisher.getId());
    }

    @Override
    public void deletePublisher(int id) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, id);
    }

    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();

        publisher.setId(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setWebsite(rs.getString("website"));

        return publisher;
    }
    
}
