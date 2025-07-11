package io.codeforall.bootcamp.effects;

import java.util.Random;

public class ScreenShaker {

    private static final Random random = new Random();

    private static int framesLeft = 0;
    private static int amount = 5;

    private static int offsetX = 0;
    private static int offsetY = 0;

    public static void startShake(int durationFrames, int intensity) {
        framesLeft = durationFrames;
        amount = intensity;
    }

    public static void update() {
        if (framesLeft > 0) {
            offsetX = random.nextInt(2 * amount + 1) - amount;
            offsetY = random.nextInt(2 * amount + 1) - amount;
            framesLeft--;
        } else {
            offsetX = 0;
            offsetY = 0;
        }
    }

    public static int getOffsetX() {
        return offsetX;
    }

    public static int getOffsetY() {
        return offsetY;
    }
}
