package io.codeforall.bootcamp.factories;

import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.shootable.ShootableType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ShootableFactory {

    private static final Random RANDOM = new Random();

    public static Shootable getShootableByType(ShootableType type) {
        return type.createInstance();
    }

    public static Shootable getWeightedRandomShootable() {
        double r = RANDOM.nextDouble();

        if(r < 0.7) {
            return getRandomByCategory(ShootableType.Category.ENEMY);

        } else if (r < 0.9) {
            return getRandomByCategory(ShootableType.Category.FRIENDLY);

        } else {
            return getRandomByCategory(ShootableType.Category.BONUS);
        }
    }

    public static Shootable getRandomByCategory(ShootableType.Category category) {
        List<ShootableType> filtered = Arrays.stream(ShootableType.values())
                .filter(type -> type.getCategory() == category)
                .toList();

        ShootableType chosen = filtered.get(RANDOM.nextInt(filtered.size()));

        return getShootableByType(chosen);
    }

    public static Shootable getRandomShootable() {
        ShootableType[] allTypes = ShootableType.values();
        return getShootableByType(allTypes[RANDOM.nextInt(allTypes.length)]);
    }
}
