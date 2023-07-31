package ru.klokov.service;

import ru.klokov.model.Match;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OnGoingMatchesService {
    private final Map<String, Match> onGoingMatches;

    public OnGoingMatchesService() {
        onGoingMatches = new ConcurrentHashMap<>();
    }

    public String add(Match match) {
        String uuid = UUID.randomUUID().toString();
        while (onGoingMatches.containsKey(uuid)) uuid = UUID.randomUUID().toString();
        onGoingMatches.put(uuid, match);
        return uuid;
    }

    public Optional<Match> get(String uuid) {
        return onGoingMatches.containsKey(uuid) ? Optional.of(onGoingMatches.get(uuid)) : Optional.empty();
    }

    public void remove(String uuid) {
        onGoingMatches.remove(uuid);
    }
}
