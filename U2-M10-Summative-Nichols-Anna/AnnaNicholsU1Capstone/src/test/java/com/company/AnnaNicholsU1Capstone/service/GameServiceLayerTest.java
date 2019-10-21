package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.dao.GameDao;
import com.company.AnnaNicholsU1Capstone.dto.Game;
import com.company.AnnaNicholsU1Capstone.viewmodel.GameViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameServiceLayerTest {

    private GameDao gameDao;
    private GameServiceLayer gameService;

    private void setupGameMock(){
        gameDao = mock(GameDao.class);

        Game game = new Game();
        game.setId(3);
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));

        Game game2 = new Game();
        game2.setTitle("God of War");
        game2.setEsrbRating("M");
        game2.setDescription("Action Adventure");
        game2.setPrice(new BigDecimal("30.00"));
        game2.setStudio("Santa Monica");
        game2.setQuantity(new BigDecimal("6"));

        List<Game> games = new ArrayList<>();
        games.add(game);

        doReturn(game).when(gameDao).addGame(game2);
        doReturn(game).when(gameDao).getGame(3);
        doReturn(games).when(gameDao).getAllGames();
    }

    @Before
    public void setUp() throws Exception {
        setupGameMock();

        gameService = new GameServiceLayer(gameDao);
    }

    @Test
    public void addGetGetAllGameVm() {

        GameViewModel game = new GameViewModel();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));
        game = gameService.addGameVm(game);

        GameViewModel fromService = gameService.getGameVm(game.getId());
        assertEquals(game, fromService);

        List<GameViewModel> games = gameService.getAllGamesVm();
        assertEquals(1, games.size());
        assertEquals(game, games.get(0));

    }

    @Test
    public void updateGameVm() {
        GameViewModel game = new GameViewModel();
        game.setId(3);
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));

        ArgumentCaptor<Game> gameCaptor = ArgumentCaptor.forClass(Game.class);

        doNothing().when(gameDao).updateGame(gameCaptor.capture());

        gameService.updateGameVm(game);
        verify(gameDao, times(1)).updateGame(gameCaptor.getValue());

        Game game2 = gameCaptor.getValue();

        assertEquals(game.getStudio(), game2.getStudio());
        
    }

    @Test
    public void deleteGameVm() {
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(gameDao).deleteGame(integerCaptor.capture());

        gameService.deleteGameVm(2);
        verify(gameDao, times(1)).deleteGame(integerCaptor.getValue());
        assertEquals(2, integerCaptor.getValue().intValue());
    }

    @Test
    public void getAllGamesByStudioVm() {
       GameViewModel game = new GameViewModel();
        game.setId(3);
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));

        List<GameViewModel> games = gameService.getAllGamesVm();
        gameService.getAllGamesByStudioVm(game.getStudio());
        assertEquals("Santa Monica", games.get(0).getStudio());
        assertEquals(game, games.get(0));
    }

    @Test
    public void getAllGamesByRatingVm() {
       GameViewModel game = new GameViewModel();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));
        game = gameService.addGameVm(game);

        List<GameViewModel> games = gameService.getAllGamesVm();
        gameService.getAllGamesByRatingVm(games.get(0).getEsrbRating());
        assertEquals("M", games.get(0).getEsrbRating());
        assertEquals(game, games.get(0));
    }

    @Test
    public void getAllGamesByTitleVm() {
        GameViewModel game = new GameViewModel();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));
        game = gameService.addGameVm(game);

        List<GameViewModel> games = gameService.getAllGamesVm();
        gameService.getAllGamesByTitleVm(games.get(0).getTitle());
        assertEquals("God of War", games.get(0).getTitle());
        assertEquals(game, games.get(0));
    }
}