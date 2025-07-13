package io.codeforall.bootcamp.utils;

import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.screens.ChoosePlayer;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.screens.StartingScreen;

public class Game {

    private StartingScreen myStartingScreen;
    private ChoosePlayer myChoosePlayer;
    private PlayArea myPlayArea;
    private MyKeyboardHandler myKeyboardHandler;

    private boolean runningStartScreen = true;
    private boolean runningChooseScreen = true;

    public Game() {
        System.out.println("STARTING 404 - TEACHER NOT FOUND");

        myKeyboardHandler = new MyKeyboardHandler();

        myStartingScreen = new StartingScreen(myKeyboardHandler);
        myChoosePlayer = new ChoosePlayer(myKeyboardHandler);

        myKeyboardHandler.setMyStartingScreen(myStartingScreen);
        myKeyboardHandler.setMyChoosePlayer(myChoosePlayer);

        myKeyboardHandler.init();
    }

    public void start() {
        myStartingScreen.load();
        runStartScreen();

        myChoosePlayer.load();
        runChooseScreen();

        Player selected = myChoosePlayer.getChosenPlayer();

        myPlayArea = new PlayArea(myKeyboardHandler, selected);
        myKeyboardHandler.setMyPlayArea(myPlayArea);
        myKeyboardHandler.setMyPlayer(myPlayArea.getPlayer());

        myPlayArea.load();
    }

    private void runStartScreen() {
        while (!myKeyboardHandler.spaceWasPressed()) {
            myStartingScreen.update();

            try {
                Thread.sleep(16);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void runChooseScreen() {
        while (myChoosePlayer.getChosenPlayer() == null) {
            myChoosePlayer.update();

            try {
                Thread.sleep(16);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        myChoosePlayer.stopBlinking();
        myChoosePlayer.delete();
    }
}
