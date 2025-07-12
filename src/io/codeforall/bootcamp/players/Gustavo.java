package io.codeforall.bootcamp.players;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.bullets.GustavoBullet;
import io.codeforall.bootcamp.screens.PlayArea;

public class Gustavo implements Player {

    private Picture gustavo;
    private int posX;
    private int posY;

    private int shootingTimer = 0;
    private boolean isShooting = false;

    public Gustavo(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

        gustavo = new Picture(posX, posY, "resources/Player/Gustavo/gustavo-still.png");
    }

    @Override
    public void init() {
        gustavo.draw();
    }

    @Override
    public void delete() {
        System.out.println("DELETED GUSTAVO");
        gustavo.delete();
    }

    @Override
    public void moveUp() {
        if (canMoveUp()) {
            System.out.println("GUSTAVO MOVING UP");
            gustavo.translate(0, -320);
        }
    }

    @Override
    public void moveDown() {
        if (canMoveDown()) {
            System.out.println("GUSTAVO MOVING DOWN");
            gustavo.translate(0, 320);
        }
    }

    @Override
    public void moveLeft() {
        if (canMoveLeft()) {
            System.out.println("GUSTAVO MOVING LEFT");
            gustavo.translate(-30, 0);
        }
    }

    @Override
    public void moveRight() {
        if (canMoveRight()) {
            System.out.println("GUSTAVO MOVING RIGHT");
            gustavo.translate(30, 0);
        }
    }

    @Override
    public boolean canMoveUp() {
        return getY() > 10;
    }

    @Override
    public boolean canMoveDown() {
        return getY() < 620;
    }

    @Override
    public boolean canMoveLeft() {
        return getX() > 10;
    }

    @Override
    public boolean canMoveRight() {
        return getX() < 1200;
    }

    @Override
    public void shoot() {
        GustavoBullet bullet = new GustavoBullet(10, 10);

        bullet.setStartingX(getX() + 200);
        bullet.setStartingY(getY() + 100);

        bullet.shoot();
        PlayArea.addBullet(bullet);

        shootingFace();
        shootingTimer = 10;
        isShooting = true;
        System.out.println("GUSTAVO SHOOTS");
    }

    @Override
    public void update() {
        if (isShooting) {
            shootingTimer--;

            if (shootingTimer <= 0) {
                normalFace();
                isShooting = false;
            }
        }
    }

    @Override
    public void shootingFace() {
        gustavo.load("resources/Player/Gustavo/gustavo-shooting.png");
    }

    @Override
    public void normalFace() {
        gustavo.load("resources/Player/Gustavo/gustavo-still.png");
    }

    @Override
    public int getX() {
        return gustavo.getX();
    }

    @Override
    public int getY() {
        return gustavo.getY();
    }
}
