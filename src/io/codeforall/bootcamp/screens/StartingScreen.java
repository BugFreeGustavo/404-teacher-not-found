package io.codeforall.bootcamp.screens;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.utils.MyKeyboardHandler;

public class StartingScreen {

    private Picture startingScreen;
    private Picture pressStart;

    private boolean isVisible = true;
    private int blinkCounter = 0;
    private final int blinkInterval = 16;
    private boolean blinking = true;

    public StartingScreen(MyKeyboardHandler keyboardHandler) {
        startingScreen = new Picture(10, 10, "resources/Background/starting-screen.png");
        pressStart = new Picture(430, 550, "resources/Buttons/press-start.png");
    }

    public void load() {
        startingScreen.draw();
        pressStart.draw();
    }

    public void update() {
        if(!blinking) {
            return;
        }

        blinkCounter++;

        if(blinkCounter >= blinkInterval) {
            blinkCounter = 0;

            if(isVisible) {
                pressStart.delete();

            } else {
                pressStart.draw();
            }

            isVisible = !isVisible;
        }
    }

    public void stopBlinking() {
        blinking = false;
        pressStart.draw();
    }

    public void delete() {
        startingScreen.delete();
        pressStart.delete();
    }
}