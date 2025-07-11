package io.codeforall.bootcamp.shootable.bonus;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.utils.PopupText;

public class Elias implements Shootable {

    private final Picture elias;

    private boolean hit = false;
    private boolean isDone = false;
    private int hitTimer = 0;

    public Elias() {
        int[] yPositions = {10, 330, 650};

        int randomY = yPositions[(int) (Math.random() * yPositions.length)];

        elias = new Picture(1000, randomY, "resources/BonusChar/Elias/elias-down.png");
    }

    @Override
    public void init() {
        elias.draw();
    }

    @Override
    public void delete() {
        elias.delete();
    }

    @Override
    public void onHit() {

        if (!isHit()) {
            hit = true;
            hitTimer = 180;

            elias.load("resources/Friendlies/Afonso/afonso-dead.png");
            elias.draw();

            System.out.println("ELIAS WAS HIT!");

            PlayArea.getInstance().addScore(-9999);

            PopupText redPopup = new PopupText(getX() + 300, getY() + 180, "-9999");
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
        return elias.getX();
    }

    @Override
    public int getY() {
        return elias.getY();
    }

    @Override
    public int getWidth() {
        return elias.getWidth();
    }

    @Override
    public int getHeight() {
        return elias.getHeight();
    }
}
