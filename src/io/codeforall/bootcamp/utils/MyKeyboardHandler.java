package io.codeforall.bootcamp.utils;

import com.codeforall.simplegraphics.keyboard.Keyboard;
import com.codeforall.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.simplegraphics.keyboard.KeyboardHandler;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.screens.StartingScreen;

public class MyKeyboardHandler implements KeyboardHandler {

    private enum GameState {
        START_SCREEN,
        CHOOSE_PLAYER,
        PLAY_AREA,
        GAME_OVER;
    }

    private GameState gameState = GameState.START_SCREEN;
    private StartingScreen myStartingScreen;
    private PlayArea myPlayArea;
    private Keyboard myKeyboard;

    private Player myPlayer;

    private boolean pressedSpace = false;

    public void init() {
        myKeyboard = new Keyboard(this);

        KeyboardEvent spaceKey = new KeyboardEvent();

        KeyboardEvent upKey = new KeyboardEvent();
        KeyboardEvent downKey = new KeyboardEvent();
        KeyboardEvent leftKey = new KeyboardEvent();
        KeyboardEvent rightKey = new KeyboardEvent();

        KeyboardEvent sKey = new KeyboardEvent();

        spaceKey.setKey(KeyboardEvent.KEY_SPACE);
        spaceKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        upKey.setKey(KeyboardEvent.KEY_UP);
        upKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKey.setKey(KeyboardEvent.KEY_DOWN);
        downKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKey.setKey(KeyboardEvent.KEY_LEFT);
        leftKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKey.setKey(KeyboardEvent.KEY_RIGHT);
        rightKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        sKey.setKey(KeyboardEvent.KEY_S);
        sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        myKeyboard.addEventListener(spaceKey);

        myKeyboard.addEventListener(upKey);
        myKeyboard.addEventListener(downKey);
        myKeyboard.addEventListener(leftKey);
        myKeyboard.addEventListener(rightKey);
        myKeyboard.addEventListener(sKey);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_SPACE:
                if (gameState == GameState.START_SCREEN && !pressedSpace) {
                    System.out.println("PRESSED SPACE");

                    myStartingScreen.stopBlinking();
                    myStartingScreen.delete();

                    gameState = GameState.PLAY_AREA;
                    pressedSpace = true;
                }
                break;
            case KeyboardEvent.KEY_S:
                if (gameState == GameState.PLAY_AREA) {
                    myPlayer.shoot();
                }
                break;

            case KeyboardEvent.KEY_UP:
                if (gameState == GameState.PLAY_AREA) {
                    myPlayer.moveUp();
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if (gameState == GameState.PLAY_AREA) {
                    myPlayer.moveDown();
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if (gameState == GameState.PLAY_AREA) {
                    myPlayer.moveLeft();
                }
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (gameState == GameState.PLAY_AREA) {
                    myPlayer.moveRight();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setMyPlayer(Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    public void setMyStartingScreen(StartingScreen myStartingScreen) {
        this.myStartingScreen = myStartingScreen;
    }

    public void setMyPlayArea(PlayArea myPlayArea) {
        this.myPlayArea = myPlayArea;
    }

    public boolean spaceWasPressed() {
        return pressedSpace;
    }
}
