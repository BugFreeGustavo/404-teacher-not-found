package io.codeforall.bootcamp.shootable.friendly;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.utils.PopupText;

public class Manel implements Shootable {

    private final Picture manel;

    private boolean hit = false;
    private boolean isDone = false;
    private int hitTimer = 0;

    public Manel() {
        int[] yPositions = {10, 330, 650};

        int randomY = yPositions[(int) (Math.random() * yPositions.length)];

        manel = new Picture(1000, randomY, "resources/Friendlies/Manel/manel-alive.png");
    }

    @Override
    public void init() {
        manel.draw();
    }

    @Override
    public void delete() {
        manel.delete();
    }

    @Override
    public void onHit() {

        if (!isHit()) {
            hit = true;
            hitTimer = 180;

            manel.load("resources/Friendlies/Manel/manel-dead.png");
            manel.draw();

            System.out.println("MANEL WAS HIT!");

            PlayArea.getInstance().addScore(-50);

            PopupText redPopup = new PopupText(getX() + 300, getY() + 180, "-50");
            redPopup.setColorRed();
            PlayArea.addPopup(redPopup);
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
        return manel.getX();
    }

    @Override
    public int getY() {
        return manel.getY();
    }

    @Override
    public int getWidth() {
        return manel.getWidth();
    }

    @Override
    public int getHeight() {
        return manel.getHeight();
    }
}