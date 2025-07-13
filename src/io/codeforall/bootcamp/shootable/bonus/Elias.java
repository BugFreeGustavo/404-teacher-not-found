package io.codeforall.bootcamp.shootable.bonus;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.shootable.ShootableType;
import io.codeforall.bootcamp.utils.PopupText;

public class Elias implements Shootable {

    private final Picture elias;

    private boolean hit = false;
    private boolean isDone = false;
    private int hitTimer = 0;

    private final int[] yPositions = {10, 330, 650};
    private int targetY;
    private final int speedY = 2;

    private String[] images = {
            "resources/BonusChar/Elias/elias-down.png",
            "resources/BonusChar/Elias/elias-up.png"
    };

    private int animationFrame = 0;
    private int animationCounter = 0;
    private final int ANIMATION_SPEED = 16;

    public Elias(int y) {

        elias = new Picture(1000, y, "resources/BonusChar/Elias/elias-down.png");
        targetY = getNextY(y);
    }

    private int getNextY(int currentY) {
        int closestIndex = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < yPositions.length; i++) {

            int diff = Math.abs(yPositions[i] - currentY);

            if (diff < minDiff) {
                minDiff = diff;
                closestIndex = i;
            }
        }

        if (closestIndex == -1) {
            return yPositions[0];
        }

        return yPositions[(closestIndex + 1) % yPositions.length];
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


            System.out.println("ELIAS WAS HIT!");

            PlayArea.getInstance().addScore(-9999);

            PopupText redPopup = new PopupText(getX() + 300, getY() + 180, "-9999");
            redPopup.setColorRed();
            PlayArea.addPopup(redPopup);
        }
    }

    @Override
    public void update() {

        if (!isHit()) {
            int playerX = PlayArea.getInstance().getPlayer().getX();

            if (elias.getX() > playerX) {
                elias.translate(-1, 0);

            } else {
                elias.delete();
                isDone = true;
            }

            int currentY = elias.getY();

            if (Math.abs(elias.getY() - targetY) <= 2) {
                elias.translate(0, targetY - elias.getY());
                targetY = getNextY(targetY);

            } else if (currentY < targetY) {
                elias.translate(0, Math.min(speedY, targetY - currentY));

            } else {
                elias.translate(0, -Math.min(speedY, currentY - targetY));
            }

            animationCounter++;

            if (animationCounter >= ANIMATION_SPEED) {
                animationCounter = 0;

                animationFrame = (animationFrame + 1) % images.length;
                elias.load(images[animationFrame]);
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

    @Override
    public ShootableType getType() {
        return ShootableType.ELIAS;
    }
}
