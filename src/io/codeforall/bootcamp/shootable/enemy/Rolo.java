package io.codeforall.bootcamp.shootable.enemy;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.effects.ScreenShaker;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.shootable.ShootableType;
import io.codeforall.bootcamp.utils.PopupText;

public class Rolo implements Shootable {

    private final Picture rolo;

    private boolean hit;
    private boolean isDone;
    private int hitTimer;

    public Rolo() {
        int[] yPositions = {10, 330, 650};

        int randomY = yPositions[(int) (Math.random() * yPositions.length)];

        hit = false;
        isDone = false;
        hitTimer = 0;

        rolo = new Picture(1000,
                randomY,
                "resources/Enemies/Rolo/rolo-alive.png");
    }

    @Override
    public void init() {
        rolo.draw();
    }

    @Override
    public void delete() {
        rolo.delete();
    }

    @Override
    public void onHit() {

        if (!isHit()) {
            hit = true;
            hitTimer = 180;

            rolo.load("resources/Enemies/Rolo/rolo-dead.png");
            rolo.draw();

            System.out.println("ROLO WAS HIT!");

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
        return rolo.getX();
    }

    @Override
    public int getY() {
        return rolo.getY();
    }

    @Override
    public int getWidth() {
        return rolo.getWidth();
    }

    @Override
    public int getHeight() {
        return rolo.getHeight();
    }

    @Override
    public ShootableType getType() {
        return ShootableType.ROLO;
    }
}
