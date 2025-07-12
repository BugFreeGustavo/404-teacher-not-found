package io.codeforall.bootcamp.factories;

import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.shootable.ShootableType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ShootableFactory {

    private static final Random RANDOM = new Random();
    private static final int[] LANES_Y = {10, 330, 650};

    public static Shootable getShootableByType(ShootableType type, int y) {
        return type.createInstance(y);
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

        List<Integer> freeLanes = getFreeLanes();
        if(freeLanes.isEmpty()) {
            return null;
        }

        int y = freeLanes.get(RANDOM.nextInt(freeLanes.size()));
        ShootableType chosen = filtered.get(RANDOM.nextInt(filtered.size()));

        return getShootableByType(chosen, y);
    }

    public static Shootable getRandomShootable() {
        ShootableType[] allTypes = ShootableType.values();

        List<Integer> freeLanes = getFreeLanes();
        if(freeLanes.isEmpty()) {
            return null;
        }

        int y = freeLanes.get(RANDOM.nextInt(freeLanes.size()));
        return getShootableByType(allTypes[RANDOM.nextInt(allTypes.length)], y);
    }

    private static List<Integer> getFreeLanes() {
        List<Integer> free = new ArrayList<>();

        for(int y: LANES_Y) {
            boolean occupied = false;

            for(Shootable target: PlayArea.getTargets()) {
                if(!target.isDone() && Math.abs(target.getY() - y) < 10) {
                    occupied = true;
                    break;
                }
            }

            if(!occupied) {
                free.add(y);
            }
        }

        return free;
    }
}
