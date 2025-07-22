package io.codeforall.bootcamp.utils;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Text;

public class PopupText {

    private final Text text;
    private int framesToLive = 400;
    private final int dy = -2;
    private boolean dead = false;

    private int growthFrames = 10;
    private final int growthAmountPerFrame = 1;

    public PopupText(int x, int y, String value) {
        text = new Text(x, y, value);
        text.grow(10, 10);
        text.setColor(Color.YELLOW);
        text.draw();
    }

    public void update() {
        if (framesToLive-- > 0) {
            text.translate(0, dy);

            if (growthFrames-- > 0) {
                text.grow(growthAmountPerFrame, growthAmountPerFrame);
            }

        } else {
            text.delete();
            dead = true;
        }
    }

    public boolean isDone() {
        return dead;
    }

    public void setColorRed() {
        text.setColor(Color.RED);
    }
}
