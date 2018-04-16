package ua.logic.study;

import java.util.List;

public class Game {
    private Player player;

    private List<String> opponents;

    public Game(Player player, List<String> opponents) {
        this.player = player;
        this.opponents = opponents;
    }

    public int numberOfEnemies() {
        return opponents.size();
    }

    public String attack() {
        return "Player attack with: " + player.getWeapon();
    }
}
