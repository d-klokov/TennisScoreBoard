package ru.klokov.service;

import ru.klokov.dao.IMatchDAO;
import ru.klokov.model.Match;

import java.util.List;

public class FinishedMatchesPersistenceService {
    private final IMatchDAO matchDAO;

    public FinishedMatchesPersistenceService(IMatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public void save(Match match) {
        matchDAO.save(match);
    }

    public List<Match> getFinishedMatches(String playerName) {
        if (playerName == null || playerName.isBlank()) return matchDAO.findAll();
        else return matchDAO.findByPlayerName(playerName);
    }
}
