package io.codeforall.bootcamp.players;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.bullets.BulletType;
import io.codeforall.bootcamp.factories.BulletFactory;
import io.codeforall.bootcamp.screens.PlayArea;

public class Daniel implements Player {

    private Picture daniel;
    private int posX;
    private int posY;

    private int shootingTimer = 0;
    private boolean isShooting = false;

    public Daniel(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

        daniel = new Picture(posX, posY, "resources/Player/Daniel/daniel-still.png");
    }

    @Override
    public void init() {
        daniel.draw();
    }

    @Override
    public void delete() {
        System.out.println("DELETED DANIEL");
        daniel.delete();
    }

    @Override
    public void moveUp() {
        if (canMoveUp()) {
            System.out.println("DANIEL MOVING UP");
            daniel.translate(0, -320);
        }
    }

    @Override
    public void moveDown() {
        if (canMoveDown()) {
            System.out.println("DANIEL MOVING DOWN");
            daniel.translate(0, 320);
        }
    }

    @Override
    public void moveLeft() {
        if (canMoveLeft()) {
            System.out.println("DANIEL MOVING LEFT");
            daniel.translate(-30, 0);
        }
    }

    @Override
    public void moveRight() {
        if (canMoveRight()) {
            System.out.println("DANIEL MOVING RIGHT");
            daniel.translate(30, 0);
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
        Bullet bullet = BulletFactory.getNewBullet(BulletType.DANIEL_BULLET, 10, 10);

        bullet.setStartingX(getX() + 200);
        bullet.setStartingY(getY() + 100);

        bullet.shoot();
        PlayArea.addBullet(bullet);

        shootingFace();
        shootingTimer = 10;
        isShooting = true;
        System.out.println("DANIEL SHOOTS");
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
        daniel.load("resources/Player/Daniel/daniel-shooting.png");
    }

    @Override
    public void normalFace() {
        daniel.load("resources/Player/Daniel/daniel-still.png");
    }

    @Override
    public int getX() {
        return daniel.getX();
    }

    @Override
    public int getY() {
        return daniel.getY();
    }
}
