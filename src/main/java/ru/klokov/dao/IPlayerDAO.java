package ru.klokov.dao;

import ru.klokov.model.Player;

import java.util.Optional;

public interface IPlayerDAO {
    Optional<Player> findByName(String name);
    void save(Player player);
}
