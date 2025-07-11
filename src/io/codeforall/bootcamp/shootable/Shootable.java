package io.codeforall.bootcamp.shootable;

public interface Shootable {

    void init();
    void delete();
    void onHit();
    void update();
    boolean isDone();
    boolean isHit();

    int getX();
    int getY();
    int getWidth();
    int getHeight();

    ShootableType getType();


}
