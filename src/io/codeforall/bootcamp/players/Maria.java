package io.codeforall.bootcamp.players;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.bullets.BulletType;
import io.codeforall.bootcamp.factories.BulletFactory;
import io.codeforall.bootcamp.screens.PlayArea;

public class Maria implements Player {

    private Picture maria;
    private int posX;
    private int posY;

    private int shootingTimer = 0;
    private boolean isShooting = false;

    public Maria(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

        maria = new Picture(posX, posY, "resources/Player/Maria/maria-still.png");
    }

    @Override
    public void init() {
        maria.draw();
    }

    @Override
    public void delete() {
        System.out.println("DELETED MARIA");
        maria.delete();
    }

    @Override
    public void moveUp() {
        if (canMoveUp()) {
            System.out.println("MARIA MOVING UP");
            maria.translate(0, -320);
        }
    }

    @Override
    public void moveDown() {
        if (canMoveDown()) {
            System.out.println("MARIA MOVING DOWN");
            maria.translate(0, 320);
        }
    }

    @Override
    public void moveLeft() {
        if (canMoveLeft()) {
            System.out.println("MARIA MOVING LEFT");
            maria.translate(-30, 0);
        }
    }

    @Override
    public void moveRight() {
        if (canMoveRight()) {
            System.out.println("MARIA MOVING RIGHT");
            maria.translate(30, 0);
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
        Bullet bullet = BulletFactory.getNewBullet(BulletType.MARIA_BULLET, 10, 10);

        bullet.setStartingX(getX() + 200);
        bullet.setStartingY(getY() + 100);

        bullet.shoot();
        PlayArea.addBullet(bullet);

        shootingFace();
        shootingTimer = 10;
        isShooting = true;
        System.out.println("MARIA SHOOTS");
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
        maria.load("resources/Player/Maria/maria-shooting.png");
    }

    @Override
    public void normalFace() {
        maria.load("resources/Player/Maria/maria-still.png");
    }

    @Override
    public int getX() {
        return maria.getX();
    }

    @Override
    public int getY() {
        return maria.getY();
    }
}
