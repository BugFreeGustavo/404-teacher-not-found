package io.codeforall.bootcamp.factories;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.bullets.BulletType;
import io.codeforall.bootcamp.bullets.GustavoBullet;

public class BulletFactory {

    public static Bullet getNewBullet(BulletType bulletType) {

        switch (bulletType) {
            case GUSTAVO_BULLET:
                return new GustavoBullet(10,10);

            default:
                return null;
        }
    }
}
