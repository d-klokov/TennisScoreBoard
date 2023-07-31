package ru.klokov.service;

import ru.klokov.dao.IMatchDAO;
import ru.klokov.model.Match;
import ru.klokov.model.Page;

import java.util.List;

public class FinishedMatchesPersistenceService {
    private final IMatchDAO matchDAO;

    public FinishedMatchesPersistenceService(IMatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public void save(Match match) {
        matchDAO.save(match);
    }

    public Page<Match> getFinishedMatches(int pageNumber, int pageSize, String playerName) {
        if (playerName == null || playerName.isBlank()) return matchDAO.findAllPaginated(pageNumber, pageSize);
        else return matchDAO.findByPlayerNamePaginated(pageNumber, pageSize, playerName);
    }
}
