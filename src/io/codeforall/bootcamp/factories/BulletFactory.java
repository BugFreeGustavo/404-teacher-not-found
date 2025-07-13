package io.codeforall.bootcamp.factories;

import io.codeforall.bootcamp.bullets.*;

public class BulletFactory {

    public static Bullet getNewBullet(BulletType bulletType, int x, int y) {

        switch (bulletType) {
            case GUSTAVO_BULLET:
                return new GustavoBullet(x,y);

            case MARIA_BULLET:
                return new MariaBullet(x,y);

            case DANIEL_BULLET:
                return new DanielBullet(x,y);

            default:
                return null;
        }
    }
}
