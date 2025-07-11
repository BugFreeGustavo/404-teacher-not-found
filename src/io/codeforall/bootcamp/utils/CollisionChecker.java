package io.codeforall.bootcamp.utils;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.shootable.Shootable;

public class CollisionChecker {

    public static boolean isColliding(Bullet bullet, Shootable target) {

        return !((bullet.getX() + bullet.getWidth() > target.getX() ||
                bullet.getX() > (target.getX() + target.getWidth()) ||
                (bullet.getY() + bullet.getHeight()) < target.getY() ||
                bullet.getY() > (target.getY()) + target.getHeight()));

    }
}
