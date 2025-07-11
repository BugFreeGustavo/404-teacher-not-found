package io.codeforall.bootcamp.utils;

import com.codeforall.simplegraphics.keyboard.Keyboard;
import com.codeforall.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.simplegraphics.keyboard.KeyboardHandler;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.screens.PlayArea;

public class MyKeyboardHandler implements KeyboardHandler {

    private enum GameState {
        START_SCREEN,
        CHOOSE_PLAYER,
        PLAY_AREA;
    }

    private GameState gameState = GameState.PLAY_AREA;
    private PlayArea myPlayArea;

    private Keyboard myKeyboard;

    private Player myPlayer;

    public void init() {
        myKeyboard = new Keyboard(this);

        KeyboardEvent upKey = new KeyboardEvent();
        KeyboardEvent downKey = new KeyboardEvent();

        KeyboardEvent sKey = new KeyboardEvent();

        upKey.setKey(KeyboardEvent.KEY_UP);
        upKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKey.setKey(KeyboardEvent.KEY_DOWN);
        downKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        sKey.setKey(KeyboardEvent.KEY_S);
        sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        myKeyboard.addEventListener(upKey);
        myKeyboard.addEventListener(downKey);

        myKeyboard.addEventListener(sKey);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
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
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setMyPlayer(Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    public void setMyPlayArea(PlayArea myPlayArea) {
        this.myPlayArea = myPlayArea;
    }
}
