package ru.klokov.service;

import ru.klokov.model.Match;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class OnGoingMatchesService {
    private final HashMap<String, Match> onGoingMatches;

    public OnGoingMatchesService() {
        onGoingMatches = new HashMap<>();
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
