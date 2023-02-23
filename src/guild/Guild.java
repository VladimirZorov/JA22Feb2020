package guild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private Collection<Player> players;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (players.size() < capacity) {
            players.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                players.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
            }
        }
    }

    public Player [] kickPlayersByClass(String clazz) {
        Player [] removed = new Player[0];
        for (Player player : players) {
            if (player.getClazz().equals(clazz)) {
                Arrays.stream(removed).distinct();
                players.remove(player);
            }
        }
        return removed;
    }

    public int count() {
        return players.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:", name)).append(System.lineSeparator());

        for (Player player : players) {
            sb.append(player.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
