package com.company.AnnaNicholsU1Capstone.controller;

import com.company.AnnaNicholsU1Capstone.dao.GameDao;
import com.company.AnnaNicholsU1Capstone.dto.Game;
import com.company.AnnaNicholsU1Capstone.service.GameServiceLayer;
import com.company.AnnaNicholsU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameServiceLayer gameService;

    @RequestMapping(value="/game", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody GameViewModel game){

        return gameService.addGameVm(game);
    }

    @RequestMapping(value="/game", method = RequestMethod.GET)
    public List<GameViewModel> getAllGames(){

        return gameService.getAllGamesVm();
    }

    @RequestMapping(value="/game/{gameId}", method = RequestMethod.GET)
    public GameViewModel getGameById(@PathVariable int gameId){

        return gameService.getGameVm(gameId);
    }

    @RequestMapping(value="/game/studio/{studio}", method = RequestMethod.GET)
    public List<GameViewModel> getAllGamesByStudio(@PathVariable String studio){

        return gameService.getAllGamesByStudioVm(studio);
    }

    @RequestMapping(value="/game/rating/{rating}", method = RequestMethod.GET)
    public List<GameViewModel> getAllGamesByRating(@PathVariable String rating){

        return gameService.getAllGamesByRatingVm(rating);
    }

    @RequestMapping(value="/game/title/{title}", method = RequestMethod.GET)
    public List<GameViewModel> getAllGamesByTitle(@PathVariable String title){

        return gameService.getAllGamesByTitleVm(title);
    }

    @RequestMapping(value="/game/{gameId}", method = RequestMethod.PUT)
    public void updateGame(@PathVariable int gameId, @RequestBody GameViewModel game){

        gameService.updateGameVm(game);
    }

    @RequestMapping(value = "/game/{gameId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int gameId){

        gameService.deleteGameVm(gameId);
    }
}
