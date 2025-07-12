package io.codeforall.bootcamp.players;

public interface Player {

    void init();
    void delete();

    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();

    boolean canMoveUp();
    boolean canMoveDown();
    boolean canMoveLeft();
    boolean canMoveRight();

    void shoot();

    void update();
    void shootingFace();
    void normalFace();

    int getX();
    int getY();
}
