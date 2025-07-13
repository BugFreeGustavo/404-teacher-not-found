package io.codeforall.bootcamp.screens;

import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.factories.PlayerFactory;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.players.PlayerType;
import io.codeforall.bootcamp.utils.MyKeyboardHandler;

public class ChoosePlayer {

    private Picture cp;

    private Picture danielTitle;
    private Picture mariaTitle;
    private Picture gustavoTitle;

    private Picture daniel;
    private Picture maria;
    private Picture gustavo;

    private Picture press1;
    private Picture press2;
    private Picture press3;

    private Player chosenPlayer;
    private boolean playerChosen = false;

    public ChoosePlayer(MyKeyboardHandler keyboardHandler) {
        cp = new Picture(10, 10, "resources/Background/choose-player-screen.png");

        danielTitle = new Picture(65, 100, "resources/Buttons/daniel-title.png");
        mariaTitle = new Picture(490, 100, "resources/Buttons/maria-title.png");
        gustavoTitle = new Picture(890, 100, "resources/Buttons/gustavo-title.png");

        daniel = new Picture(110, 280, "resources/Player/Daniel/daniel-still-choose.png");
        maria = new Picture(530, 290, "resources/Player/Maria/maria-still-choose.png");
        gustavo = new Picture(930, 290, "resources/Player/Gustavo/gustavo-still-choose.png");

        press1 = new Picture(120, 500, "resources/Buttons/press-1.png");
        press2 = new Picture(530, 500, "resources/Buttons/press-2.png");
        press3 = new Picture(930, 500, "resources/Buttons/press-3.png");
    }

    public void selectPlayer(int number) {
        switch (number) {
            case 1:
                chosenPlayer = PlayerFactory.getPlayer(PlayerType.DANIEL, 20, 10);
                break;

            case 2:
                chosenPlayer = PlayerFactory.getPlayer(PlayerType.MARIA, 20, 330);
                break;

            case 3:
                chosenPlayer = PlayerFactory.getPlayer(PlayerType.GUSTAVO, 20, 650);
                break;
        }

        playerChosen = true;
    }

    public boolean isPlayerChosen() {
        return playerChosen;
    }

    public Player getChosenPlayer() {
        return chosenPlayer;
    }

    public void load() {
        cp.draw();

        drawTitles();
        drawFaces();
        drawButtons();
    }

    public void delete() {
        cp.delete();

        deleteTitles();
        deleteFaces();
        deleteButtons();
    }

    private void drawFaces() {
        daniel.draw();
        maria.draw();
        gustavo.draw();
    }

    private void deleteFaces() {
        daniel.delete();
        maria.delete();
        gustavo.delete();
    }

    private void drawTitles() {
        danielTitle.draw();
        mariaTitle.draw();
        gustavoTitle.draw();
    }

    private void deleteTitles() {
        danielTitle.delete();
        mariaTitle.delete();
        gustavoTitle.delete();
    }

    private void drawButtons() {
        press1.draw();
        press2.draw();
        press3.draw();
    }

    private void deleteButtons() {
        press1.delete();
        press2.delete();
        press3.delete();
    }
}