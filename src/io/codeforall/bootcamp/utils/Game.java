package io.codeforall.bootcamp.utils;

import io.codeforall.bootcamp.screens.PlayArea;

public class Game {

    private PlayArea myPlayArea;

    private MyKeyboardHandler myKeyboardHandler;

    public Game() {
        System.out.println("STARTING 404 - TEACHER NOT FOUND");

        myKeyboardHandler = new MyKeyboardHandler();

        myPlayArea = new PlayArea(myKeyboardHandler);
        myPlayArea.load();
    }

    public void start() {
        myKeyboardHandler.setMyPlayArea(myPlayArea);
        myKeyboardHandler.setMyPlayer(myPlayArea.getGustavo());

        myKeyboardHandler.init();
    }
}
