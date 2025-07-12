package io.codeforall.bootcamp.utils;

import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.screens.StartingScreen;

public class Game {

    private StartingScreen myStartingScreen;
    private PlayArea myPlayArea;
    private MyKeyboardHandler myKeyboardHandler;

    private boolean runningStartScreen = true;

    public Game() {
        System.out.println("STARTING 404 - TEACHER NOT FOUND");

        myKeyboardHandler = new MyKeyboardHandler();
        myStartingScreen = new StartingScreen(myKeyboardHandler);
        myPlayArea = new PlayArea(myKeyboardHandler);

        myKeyboardHandler.setMyStartingScreen(myStartingScreen);
        myKeyboardHandler.setMyPlayArea(myPlayArea);
        myKeyboardHandler.setMyPlayer(myPlayArea.getGustavo());

        myKeyboardHandler.init();

        myStartingScreen.load();
    }

    public void start() {
        run();
    }

    private void run() {
        while (runningStartScreen) {
            myStartingScreen.update();

            if(myKeyboardHandler.spaceWasPressed()) {
                runningStartScreen = false;
            }

            try {
                Thread.sleep(16);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        myPlayArea.load();
    }
}
