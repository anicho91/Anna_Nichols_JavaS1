package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.dao.GameDao;
import com.company.AnnaNicholsU1Capstone.dto.Game;
import com.company.AnnaNicholsU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameServiceLayer implements GameViewDao{

    private GameDao gameDao;

    public GameServiceLayer(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public GameViewModel addGameVm(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        game = gameDao.addGame(game);

        gameViewModel.setId(game.getId());

        return gameViewModel;
    }

    @Override
    public GameViewModel getGameVm(int gameId) {
        Game game = gameDao.getGame(gameId);
        return buildGameViewModel(game);
    }

    @Override
    public List<GameViewModel> getAllGamesVm() {
        List<Game> games = gameDao.getAllGames();

        List<GameViewModel> gameViewModels = new ArrayList<>();

        for (Game game : games){
            GameViewModel gvm = buildGameViewModel(game);
            gameViewModels.add(gvm);
        }

        return gameViewModels;
    }

    @Override
    public void updateGameVm(GameViewModel gameViewModel) {

        Game game = new Game();
        game.setId(gameViewModel.getId());
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        gameDao.updateGame(game);

    }

    @Override
    public void deleteGameVm(int gameId) {
        gameDao.deleteGame(gameId);
    }

    @Override
    public List<GameViewModel> getAllGamesByStudioVm(String studio) {
        List<Game> games = gameDao.getByStudio(studio);

        List<GameViewModel> gameViewModels = new ArrayList<>();

        for (Game game : games){
            GameViewModel gvm = buildGameViewModel(game);
            gameViewModels.add(gvm);
        }

        return gameViewModels;
    }

    @Override
    public List<GameViewModel> getAllGamesByRatingVm(String rating) {
        List<Game> games = gameDao.getByEsrbRating(rating);

        List<GameViewModel> gameViewModels = new ArrayList<>();

        for (Game game : games){
            GameViewModel gvm = buildGameViewModel(game);
            gameViewModels.add(gvm);
        }

        return gameViewModels;
    }

    @Override
    public List<GameViewModel> getAllGamesByTitleVm(String title) {
        List<Game> games = gameDao.getByTitle(title);

        List<GameViewModel> gameViewModels = new ArrayList<>();

        for (Game game : games){
            GameViewModel gvm = buildGameViewModel(game);
            gameViewModels.add(gvm);
        }

        return gameViewModels;
    }

    private GameViewModel buildGameViewModel(Game game){
        GameViewModel gvm = new GameViewModel();
        gvm.setId(game.getId());
        gvm.setTitle(game.getTitle());
        gvm.setEsrbRating(game.getEsrbRating());
        gvm.setDescription(game.getDescription());
        gvm.setPrice(game.getPrice());
        gvm.setStudio(game.getStudio());
        gvm.setQuantity(game.getQuantity());

        return gvm;
    }
}
