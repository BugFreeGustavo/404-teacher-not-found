package io.codeforall.bootcamp.utils;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.shootable.Shootable;

public class CollisionChecker {

    public static boolean isColliding(Bullet bullet, Shootable target) {

        return bullet.getX() < target.getX() + target.getWidth() &&
                bullet.getWidth() - 100 > target.getX() &&
                bullet.getY() < target.getY() + target.getHeight() &&
                bullet.getY() + bullet.getHeight() > target.getY();

    }
}
