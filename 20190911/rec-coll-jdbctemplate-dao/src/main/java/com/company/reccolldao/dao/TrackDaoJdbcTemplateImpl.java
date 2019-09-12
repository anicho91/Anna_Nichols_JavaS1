package com.company.reccolldao.dao;

import com.company.reccolldao.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TrackDaoJdbcTemplateImpl implements TrackDao {

    private static final String INSERT_TRACK_SQL =
            "Insert into track(album_id, title, runtime) Values (?,?,?)";

    private static final String SELECT_TRACK_SQL =
            "Select * From track where track_id = ?";

    private static final String SELECT_ALL_TRACKS_SQL =
            "Select * From track";

    private static final String UPDATE_TRACK_SQL =
            "update track set album_id=?, title=?, runtime=?, track_id=?";

    private static final String SELECT_TRACK_BY_ALBUM_SQL =
            "Select * From track where album_id=?";

    private static final String DELETE_TRACK_SQL =
            "delete from track where track_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrackDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}


    @Override
    public Track addTrack(Track track) {
        jdbcTemplate.update(INSERT_TRACK_SQL,
                track.getAlbumId(),
                track.getTitle(),
                track.getRunTime());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        track.setId(id);
        return track;
    }

    @Override
    public Track getTrack(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TRACK_SQL, this::mapRowToTrack, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Track> getAllTracks() {

        return jdbcTemplate.query(SELECT_ALL_TRACKS_SQL, this::mapRowToTrack);
    }

    @Override
    public List<Track> getTracksByAlbum(int albumId) {

        return jdbcTemplate.query(SELECT_TRACK_BY_ALBUM_SQL, this::mapRowToTrack, albumId);
    }

    @Override
    public void updateTrack(Track track) {
        jdbcTemplate.update(UPDATE_TRACK_SQL,
                track.getAlbumId(),
                track.getTitle(),
                track.getRunTime(),
                track.getId());
    }

    @Override
    public void deleteTrack(int id) {
        jdbcTemplate.update(DELETE_TRACK_SQL, id);
    }

    private Track mapRowToTrack(ResultSet rs, int rowNum) throws SQLException {
        Track track = new Track();

        track.setId(rs.getInt("track_id"));
        track.setAlbumId(rs.getInt("album_id"));
        track.setTitle(rs.getString("title"));
        track.setRunTime(rs.getInt("runtime"));

        return track;
    }
}