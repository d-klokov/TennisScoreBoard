package ru.klokov.model;

import jakarta.persistence.*;

@Entity
@Table(name = "players", indexes = {@Index(columnList = "name", name = "player_name_idx")})
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
