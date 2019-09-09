package com.company.reccolldao.dao;

import com.company.reccolldao.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArtistDaoJdbcTemplateImpl implements ArtistDao {

    private static final String INSERT_ARTIST_SQL =
            "Insert into artist(name, instagram, twitter) Values (?,?,?)";

    private static final String SELECT_ARTIST_SQL =
            "Select * From artist where artist_id = ?";

    private static final String SELECT_ALL_ARTISTS_SQL =
            "Select * From artist";

    private static final String UPDATE_ARTIST_SQL =
            "update artist set name=?, instagram=?, twitter=?, artist_id=?";

    private static final String DELETE_ARTIST_SQL =
            "delete from artist where artist_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArtistDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}


    @Override
    @Transactional
    public Artist addArtist(Artist artist) {

        jdbcTemplate.update(INSERT_ARTIST_SQL,
                artist.getName(),
                artist.getInstagram(),
                artist.getTwitter());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        artist.setId(id);
        return artist;
    }

    @Override
    public Artist getArtist(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_ARTIST_SQL, this::mapRowToArtist, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Artist> getAllArtists() {

        return jdbcTemplate.query(SELECT_ALL_ARTISTS_SQL, this::mapRowToArtist);
    }

    @Override
    public void updateArtist(Artist artist) {
        jdbcTemplate.update(UPDATE_ARTIST_SQL,
                artist.getName(),
                artist.getInstagram(),
                artist.getTwitter(),
                artist.getId());
    }

    @Override
    public void deleteArtist(int id) {
        jdbcTemplate.update(DELETE_ARTIST_SQL, id);
    }

    private Artist mapRowToArtist(ResultSet rs, int rowNum) throws SQLException {
        Artist artist = new Artist();

        artist.setId(rs.getInt("artist_id"));
        artist.setName(rs.getString("name"));
        artist.setInstagram(rs.getString("instagram"));
        artist.setTwitter(rs.getString("twitter"));

        return artist;
    }
}
