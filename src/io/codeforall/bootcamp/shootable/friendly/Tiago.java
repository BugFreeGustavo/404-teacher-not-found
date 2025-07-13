package io.codeforall.bootcamp.shootable.friendly;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.shootable.ShootableType;
import io.codeforall.bootcamp.utils.PopupText;

public class Tiago implements Shootable {

    private final Picture tiago;

    private boolean hit = false;
    private boolean isDone = false;
    private int hitTimer = 0;

    public Tiago(int y) {

        tiago = new Picture(1000, y, "resources/Friendlies/Tiago/tiago-alive.png");
    }

    @Override
    public void init() {
        tiago.draw();
    }

    @Override
    public void delete() {
        tiago.delete();
    }

    @Override
    public void onHit() {

        if (!isHit()) {
            hit = true;
            hitTimer = 180;

            tiago.load("resources/Friendlies/Tiago/tiago-dead.png");
            tiago.draw();

            System.out.println("TIAGO WAS HIT!");

            PlayArea.getInstance().addScore(-50);

            PopupText redPopup = new PopupText(getX() + 300, getY() + 180, "-50");
            redPopup.setColorRed();
            PlayArea.addPopup(redPopup);
        }
    }

    @Override
    public void update() {

        if (!isHit()) {
            int playerX = PlayArea.getInstance().getPlayer().getX();

            if (tiago.getX() > playerX) {
                tiago.translate(-1, 0);

            } else {
                tiago.delete();
                isDone = true;
            }

        }

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
        return tiago.getX();
    }

    @Override
    public int getY() {
        return tiago.getY();
    }

    @Override
    public int getWidth() {
        return tiago.getWidth();
    }

    @Override
    public int getHeight() {
        return tiago.getHeight();
    }

    @Override
    public ShootableType getType() {
        return ShootableType.TIAGO;
    }
}
