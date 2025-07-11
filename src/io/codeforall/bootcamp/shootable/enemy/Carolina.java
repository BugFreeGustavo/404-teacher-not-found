package io.codeforall.bootcamp.shootable.enemy;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.utils.PopupText;

public class Carolina implements Shootable {

    private final Picture carolina;

    private boolean hit;
    private boolean isDone;
    private int hitTimer;

    public Carolina() {
        int[] yPositions = {10, 330, 650};

        int randomY = yPositions[(int) (Math.random() * yPositions.length)];

        hit = false;
        isDone = false;
        hitTimer = 0;

        carolina = new Picture(1000,
                randomY,
                "resources/Enemies/Carolina/carolina-alive.png");
    }

    @Override
    public void init() {
        carolina.draw();
    }

    @Override
    public void delete() {
        carolina.delete();
    }

    @Override
    public void onHit() {

        if (!isHit()) {
            hit = true;
            hitTimer = 180;

            carolina.load("resources/Enemies/Carolina/carolina-dead.png");
            carolina.draw();

            System.out.println("CAROLINA WAS HIT!");

            PlayArea.getInstance().addScore(100);
            PlayArea.addPopup(new PopupText(getX() + 300 , getY() + 180, "+100"));
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
        return carolina.getX();
    }

    @Override
    public int getY() {
        return carolina.getY();
    }

    @Override
    public int getWidth() {
        return carolina.getWidth();
    }

    @Override
    public int getHeight() {
        return carolina.getHeight();
    }
}
