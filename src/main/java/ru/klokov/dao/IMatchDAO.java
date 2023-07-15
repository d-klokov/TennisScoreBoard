package ru.klokov.dao;

import ru.klokov.model.Match;

import java.util.List;

public interface IMatchDAO {
    List<Match> findAll();
    List<Match> findByPlayerName(String name);
    void save(Match match);
}
