package io.codeforall.bootcamp.shootable.enemy;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.utils.PopupText;

public class Andreia implements Shootable {

    private final Picture andreia;

    private boolean hit;
    private boolean isDone;
    private int hitTimer;

    public Andreia() {
        int[] yPositions = {10, 330, 650};

        int randomY = yPositions[(int) (Math.random() * yPositions.length)];

        hit = false;
        isDone = false;
        hitTimer = 0;

        andreia = new Picture(1000,
                randomY,
                "resources/Enemies/Andreia/andreia-alive.png");
    }

    @Override
    public void init() {
        andreia.draw();
    }

    @Override
    public void delete() {
        andreia.delete();
    }

    @Override
    public void onHit() {

        if (!isHit()) {
            hit = true;
            hitTimer = 180;

            andreia.load("resources/Enemies/Andreia/andreia-dead.png");
            andreia.draw();

            System.out.println("ANDREIA WAS HIT!");

            PlayArea.getInstance().addScore(100);
            PlayArea.addPopup(new PopupText(getX() + 300, getY() + 180, "+100"));
        }
    }

    @Override
    public void update() {

        if (isHit() && hitTimer > 0) {
            hitTimer--;

            if (hitTimer == 0) {
                delete();
                isDone = true;
            }
        }
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    @Override
    public boolean isHit() {
        return hit;
    }

    @Override
    public int getX() {
        return andreia.getX();
    }

    @Override
    public int getY() {
        return andreia.getY();
    }

    @Override
    public int getWidth() {
        return andreia.getWidth();
    }

    @Override
    public int getHeight() {
        return andreia.getHeight();
    }
}

