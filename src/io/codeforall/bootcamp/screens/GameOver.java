package io.codeforall.bootcamp.screens;

import com.codeforall.simplegraphics.graphics.Rectangle;
import com.codeforall.simplegraphics.pictures.Picture;

public class GameOver {

    private Picture gameOver;

    public GameOver() {
        gameOver = new Picture(10, 10, "resources/Background/game-over-screen.jpg");
    }

    public void load() {
        gameOver.draw();
    }

    public void delete() {
        gameOver.delete();
    }
}
