package ru.klokov.model;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_one_id")
    private Player playerOne;
    @ManyToOne
    @JoinColumn(name = "player_two_id")
    private Player playerTwo;
    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Player winner;

    @Transient
    private MatchScore matchScore;

    public Match() {
    }

    public Match(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.matchScore = new MatchScore();
    }

    @Override
    public String toString() {
        return id + " " + playerOne + " " + playerTwo + " " + winner;
    }

    public Long getId() { return id; }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() { return winner; }

    public MatchScore getMatchScore() {
        return matchScore;
    }
}
