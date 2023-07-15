package ru.klokov.service;

import ru.klokov.dao.IPlayerDAO;
import ru.klokov.model.Match;
import ru.klokov.model.Player;

import java.util.Optional;

public class NewMatchService {
    private final IPlayerDAO playerDAO;

    public NewMatchService(IPlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public Match createNewMatch(String playerOneName, String playerTwoName) {
        Optional<Player> playerOneOpt = playerDAO.findByName(playerOneName);
        Optional<Player> playerTwoOpt = playerDAO.findByName(playerTwoName);

        Player playerOne;
        Player playerTwo;

        if (playerOneOpt.isEmpty()) {
            playerOne = new Player(playerOneName);
            playerDAO.save(playerOne);
        } else playerOne = playerOneOpt.get();

        if (playerTwoOpt.isEmpty()) {
            playerTwo = new Player(playerTwoName);
            playerDAO.save(playerTwo);
        } else playerTwo = playerTwoOpt.get();

        return new Match(playerOne, playerTwo);
    }
}
