package io.codeforall.bootcamp.factories;

import io.codeforall.bootcamp.players.Gustavo;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.players.PlayerType;

public class PlayerFactory {

    public static Player getPlayer(PlayerType players) {
        return switch (players) {
            case DANIEL -> null;
            case MARIA -> null;
            case GUSTAVO -> new Gustavo(20, 650);
        };
    }
}
