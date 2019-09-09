package com.company.VideoGameCollectionDaoAnnaNichols.dao;

import com.company.VideoGameCollectionDaoAnnaNichols.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int id);


}
