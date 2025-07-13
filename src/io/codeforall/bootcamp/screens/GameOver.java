package io.codeforall.bootcamp.screens;

import com.codeforall.simplegraphics.graphics.Rectangle;

public class GameOver {

    private Rectangle gameOver;

    public GameOver() {
       gameOver = new Rectangle(PlayArea.getPADDING(), PlayArea.getPADDING(), PlayArea.getWIDTH(), PlayArea.getHEIGHT());
    }

    public void load() {
        gameOver.fill();
    }

    public void delete() {
        gameOver.delete();
    }
}
