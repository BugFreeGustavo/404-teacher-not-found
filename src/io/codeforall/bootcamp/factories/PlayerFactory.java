package io.codeforall.bootcamp.factories;

import io.codeforall.bootcamp.players.*;

public class PlayerFactory {

    public static Player getPlayer(PlayerType players, int x, int y) {
        return switch (players) {
            case DANIEL -> new Daniel(x, y);
            case MARIA -> new Maria(x, y);
            case GUSTAVO -> new Gustavo(x, y);
        };
    }
}
