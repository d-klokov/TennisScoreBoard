package ru.klokov.dao;

import ru.klokov.model.Match;
import ru.klokov.model.Page;

import java.util.List;

public interface IMatchDAO {
    Long findMatchesQuantity();
    Long findMatchesQuantityByPlayerName(String name);
    List<Match> findAll();
    Page<Match> findAllPaginated(int pageNumber, int pageSize);
    List<Match> findByPlayerName(String name);
    Page<Match> findByPlayerNamePaginated(int pageNumber, int pageSize, String name);
    void save(Match match);
}
