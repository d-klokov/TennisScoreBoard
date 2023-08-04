package ru.klokov.service;

import ru.klokov.dao.IPlayerDAO;
import ru.klokov.exception.DatabaseException;
import ru.klokov.model.Match;
import ru.klokov.model.Player;

import java.util.Optional;

public class NewMatchService {
    private final IPlayerDAO playerDAO;

    public NewMatchService(IPlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public Match createNewMatch(String playerOneName, String playerTwoName) {
        Player playerOne;
        Player playerTwo;

        playerOne = createOrGetPlayer(playerOneName);
        playerTwo = createOrGetPlayer(playerTwoName);

        return new Match(playerOne, playerTwo);
    }

    private Player createOrGetPlayer(String playerName) {
        Player player;

        try {
            player = new Player(playerName);
            playerDAO.save(player);
        } catch (DatabaseException e) {
            player = playerDAO.findByName(playerName);
        }

        return player;
    }
}
