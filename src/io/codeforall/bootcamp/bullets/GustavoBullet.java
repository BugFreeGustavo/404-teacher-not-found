package io.codeforall.bootcamp.bullets;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.screens.PlayArea;

public class GustavoBullet implements Bullet {

    private Picture bullet;
    private boolean collided = false;

    private int startX;
    private int startY;

    private int velocity = 10;

    public GustavoBullet(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;

        bullet = new Picture(startX, startY, "resources/Bullets/bullet-gustavo.png");
    }

    @Override
    public void delete() {
        bullet.delete();
    }

    @Override
    public boolean isCollided() {
        return collided;
    }

    @Override
    public void setCollided() {
        this.collided = true;
    }

    @Override
    public void shoot() {
        bullet.draw();
    }

    @Override
    public void move() {
        if(!isCollided() && getWidth() < PlayArea.getWIDTH()) {
            bullet.translate(velocity, 0);

        } else {
            setCollided();
            delete();
        }
    }

    @Override
    public void moveUp() {
        bullet.translate(0, -400);
    }

    @Override
    public void moveDown() {
        bullet.translate(0, 400);
    }

    @Override
    public int getX() {
        return bullet.getX();
    }

    @Override
    public int getY() {
        return bullet.getY();
    }

    @Override
    public int getWidth() {
        return bullet.getMaxX();
    }

    @Override
    public int getHeight() {
        return bullet.getHeight();
    }

    @Override
    public void setStartingX(int x) {
        int dx = x - this.startX;
        bullet.translate(dx, 0);
        this.startX = x;
    }

    @Override
    public void setStartingY(int y) {
        int dy = y - this.startY;
        bullet.translate(0, dy);
        this.startY = y;
    }
}
