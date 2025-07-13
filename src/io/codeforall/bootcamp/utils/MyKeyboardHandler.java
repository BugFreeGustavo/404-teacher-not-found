package io.codeforall.bootcamp.utils;

import com.codeforall.simplegraphics.keyboard.Keyboard;
import com.codeforall.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.simplegraphics.keyboard.KeyboardHandler;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.screens.ChoosePlayer;
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
    private ChoosePlayer myChoosePlayer;
    private PlayArea myPlayArea;
    private Keyboard myKeyboard;

    private Player myPlayer;

    private boolean pressedSpace = false;
    private boolean playerChosen = false;
    private boolean paused = false;

    public void init() {
        myKeyboard = new Keyboard(this);

        KeyboardEvent spaceKey = new KeyboardEvent();

        KeyboardEvent oneKey = new KeyboardEvent();
        KeyboardEvent twoKey = new KeyboardEvent();
        KeyboardEvent threeKey = new KeyboardEvent();

        KeyboardEvent upKey = new KeyboardEvent();
        KeyboardEvent downKey = new KeyboardEvent();
        KeyboardEvent leftKey = new KeyboardEvent();
        KeyboardEvent rightKey = new KeyboardEvent();

        KeyboardEvent sKey = new KeyboardEvent();

        KeyboardEvent pKey = new KeyboardEvent();

        spaceKey.setKey(KeyboardEvent.KEY_SPACE);
        spaceKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        oneKey.setKey(KeyboardEvent.KEY_1);
        oneKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        twoKey.setKey(KeyboardEvent.KEY_2);
        twoKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        threeKey.setKey(KeyboardEvent.KEY_3);
        threeKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

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

        pKey.setKey(KeyboardEvent.KEY_P);
        pKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        myKeyboard.addEventListener(spaceKey);

        myKeyboard.addEventListener(oneKey);
        myKeyboard.addEventListener(twoKey);
        myKeyboard.addEventListener(threeKey);

        myKeyboard.addEventListener(upKey);
        myKeyboard.addEventListener(downKey);
        myKeyboard.addEventListener(leftKey);
        myKeyboard.addEventListener(rightKey);
        myKeyboard.addEventListener(sKey);

        myKeyboard.addEventListener(pKey);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_SPACE:
                if (gameState == GameState.START_SCREEN && !pressedSpace) {
                    System.out.println("PRESSED SPACE");

                    myStartingScreen.stopBlinking();
                    myStartingScreen.delete();

                    gameState = GameState.CHOOSE_PLAYER;
                    pressedSpace = true;
                }
                break;

            case KeyboardEvent.KEY_P:
                if(gameState == GameState.PLAY_AREA) {
                    myPlayArea.togglePause();
                    paused = !paused;
                }
                break;

            case KeyboardEvent.KEY_1:
                if (gameState == GameState.CHOOSE_PLAYER && !playerChosen) {
                    System.out.println("PRESSED 1");
                    myChoosePlayer.selectPlayer(1);


                    gameState = GameState.PLAY_AREA;
                    playerChosen = true;
                }
                break;

            case KeyboardEvent.KEY_2:
                if (gameState == GameState.CHOOSE_PLAYER && !playerChosen) {
                    System.out.println("PRESSED 2");
                    myChoosePlayer.selectPlayer(2);

                    gameState = GameState.PLAY_AREA;
                    playerChosen = true;
                }
                break;

            case KeyboardEvent.KEY_3:
                if (gameState == GameState.CHOOSE_PLAYER && !playerChosen) {
                    System.out.println("PRESSED 3");
                    myChoosePlayer.selectPlayer(3);

                    gameState = GameState.PLAY_AREA;
                    playerChosen = true;
                }
                break;

            case KeyboardEvent.KEY_S:
                if (gameState == GameState.PLAY_AREA && !paused) {
                    myPlayer.shoot();
                }
                break;

            case KeyboardEvent.KEY_UP:
                if (gameState == GameState.PLAY_AREA && !paused) {
                    myPlayer.moveUp();
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if (gameState == GameState.PLAY_AREA && !paused) {
                    myPlayer.moveDown();
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if (gameState == GameState.PLAY_AREA && !paused) {
                    myPlayer.moveLeft();
                }
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (gameState == GameState.PLAY_AREA && !paused) {
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

    public void setMyChoosePlayer(ChoosePlayer myChoosePlayer) {
        this.myChoosePlayer = myChoosePlayer;
    }

    public void setMyPlayArea(PlayArea myPlayArea) {
        this.myPlayArea = myPlayArea;
    }

    public boolean spaceWasPressed() {
        return pressedSpace;
    }
}
