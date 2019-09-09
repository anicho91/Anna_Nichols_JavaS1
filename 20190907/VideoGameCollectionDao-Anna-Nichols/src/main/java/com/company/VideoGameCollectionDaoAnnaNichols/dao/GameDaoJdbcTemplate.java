package com.company.VideoGameCollectionDaoAnnaNichols.dao;

import com.company.VideoGameCollectionDaoAnnaNichols.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplate implements GameDao {

    private static final String INSERT_GAME_SQL =
            "Insert into game(console_id, publisher_id, type_id) Values (?,?,?)";

    private static final String SELECT_GAME_SQL =
            "Select * From game where game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "Select * From game";

    private static final String UPDATE_GAME_SQL =
            "update game set console_id=?, publisher_id=?, type_id=?, game_id=?";

    private static final String DELETE_GAME_SQL =
            "delete from game where game_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Game addGame(Game game) {

        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getConsoleId(),
                game.getPublisherId(),
                game.getTypeId());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        game.setId(id);

        return game;
    }

    @Override
    public Game getGame(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<Game> getAllGames() {

        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);

    }

    @Override
    public void updateGame(Game game) {

        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getConsoleId(),
                game.getPublisherId(),
                game.getTypeId(),
                game.getId());
    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);
    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();

        game.setId(rs.getInt("game_id"));
        game.setConsoleId(rs.getInt("console_id"));
        game.setPublisherId(rs.getInt("publisher_id"));
        game.setTypeId(rs.getInt("type_id"));


        return game;
    }
}
