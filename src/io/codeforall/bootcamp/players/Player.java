package io.codeforall.bootcamp.players;

public interface Player {

    void init();
    void delete();

    void moveUp();
    void moveDown();

    boolean canMoveUp();
    boolean canMoveDown();

    void shoot();

    void update();
    void shootingFace();
    void normalFace();

    int getX();
    int getY();
}
