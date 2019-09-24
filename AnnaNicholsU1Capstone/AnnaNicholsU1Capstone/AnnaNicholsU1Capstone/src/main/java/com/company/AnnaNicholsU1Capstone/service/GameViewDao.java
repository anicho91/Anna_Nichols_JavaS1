package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.viewmodel.GameViewModel;

import java.util.List;

public interface GameViewDao {

    GameViewModel addGameVm(GameViewModel gameViewModel);

    GameViewModel getGameVm(int gameId);

    List<GameViewModel> getAllGamesVm();

    void updateGameVm(GameViewModel gameViewModel);

    void deleteGameVm(int gameId);

    List<GameViewModel> getAllGamesByStudioVm(String studio);

    List<GameViewModel> getAllGamesByRatingVm(String rating);

    List<GameViewModel> getAllGamesByTitleVm(String title);
}
