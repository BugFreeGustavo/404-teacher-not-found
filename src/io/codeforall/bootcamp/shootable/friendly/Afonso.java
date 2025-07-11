package io.codeforall.bootcamp.shootable.friendly;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.shootable.Shootable;

public class Afonso implements Shootable {

    private final Picture afonso;

    private boolean hit = false;
    private boolean isDone = false;
    private int hitTimer = 0;

    public Afonso() {
        int[] yPositions = {10, 330, 650};

        int randomY = yPositions[(int) (Math.random() * yPositions.length)];

        afonso = new Picture(1000, randomY, "resources/Friendlies/Afonso/afonso-alive.png");
    }

    @Override
    public void init() {
        afonso.draw();
    }

    @Override
    public void delete() {
        afonso.delete();
    }

    @Override
    public void onHit() {

        if (!isHit()) {
            hit = true;
            hitTimer = 180;

            afonso.load("resources/Friendlies/Afonso/afonso-dead.png");
            afonso.draw();

            System.out.println("AFONSO WAS HIT!");
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
        return afonso.getX();
    }

    @Override
    public int getY() {
        return afonso.getY();
    }

    @Override
    public int getWidth() {
        return afonso.getWidth();
    }

    @Override
    public int getHeight() {
        return afonso.getHeight();
    }
}
