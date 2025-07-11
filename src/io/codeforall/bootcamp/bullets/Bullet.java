package io.codeforall.bootcamp.bullets;

public interface Bullet {

    void delete();

    boolean isCollided();
    void setCollided();

    void shoot();

    void move();
    void moveUp();
    void moveDown();

    int getX();
    int getY();
    int getWidth();
    int getHeight();

    void setStartingX(int x);
    void setStartingY(int y);
}
