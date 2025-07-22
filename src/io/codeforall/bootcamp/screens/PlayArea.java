package io.codeforall.bootcamp.screens;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;
import com.codeforall.simplegraphics.graphics.Text;
import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.factories.ShootableFactory;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.shootable.ShootableType;
import io.codeforall.bootcamp.utils.CollisionChecker;
import io.codeforall.bootcamp.utils.MyKeyboardHandler;
import io.codeforall.bootcamp.utils.PopupText;

import java.util.*;

public class PlayArea {

    private static PlayArea instance;

    private final Rectangle myScreenSize;
    private final Picture background;
    private final Player player;

    private static final List<Bullet> bullets = new ArrayList<>();
    private static final List<Shootable> targets = new ArrayList<>();
    private static final List<PopupText> popups = new ArrayList<>();

    private boolean spawnNextTarget = false;

    private static final int PADDING = 10;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    private int score = 0;
    private Text scoreText;
    private Text pauseOverlay;

    private Rectangle dimPauseOverlay;

    private boolean paused = false;
    private boolean gameOver = false;

    public PlayArea(MyKeyboardHandler keyboardHandler, Player player) {
        instance = this;

        myScreenSize = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        background = new Picture(PADDING, PADDING, "resources/Background/play-area.jpg");

        this.player = player;
    }

    public void load() {
        myScreenSize.draw();
        System.out.println("LOADING PLAY AREA");
        background.draw();
        System.out.println("LOADING BACKGROUND");


        scoreText = new Text(PlayArea.WIDTH - 400, 50, "Score: 0");
        scoreText.grow(20, 20);
        scoreText.setColor(Color.WHITE);
        scoreText.draw();

        player.init();
        System.out.println("LOADING GUSTAVO");

        for (int i = 0; i < 3; i++) {
            addTarget(ShootableFactory.getWeightedRandomShootable());
            System.out.println("LOADING " + targets.getFirst().getType().toString());
        }

        new Thread(this::gameLoop).start();
    }

    private void gameLoop() {
        while (true) {
            update();

            try {
                Thread.sleep(8);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        if (paused || gameOver) {
            return;
        }

        player.update();

        Iterator<Bullet> iterator = bullets.iterator();

        while (iterator.hasNext()) {
            Bullet b = iterator.next();
            b.move();

            for (Shootable target : targets) {
                if (!b.isCollided() && CollisionChecker.isColliding(b, target)) {
                    b.setCollided();

                    if (target.getType() == ShootableType.ELIAS) {
                        triggerGameOver();
                        return;
                    }

                    target.onHit();

//                    if(target.getType().getCategory() == ShootableType.Category.ENEMY) {
//                       ScreenShaker.startShake(6, 5);
//                    }
                }
            }

            if (b.isCollided()) {
                b.delete();
                iterator.remove();
            }
        }

        Iterator<Shootable> targetIterator = targets.iterator();

        while (targetIterator.hasNext()) {
            Shootable target = targetIterator.next();
            target.update();

            if (target.isDone()) {
                targetIterator.remove();
                spawnNextTarget = true;
            }
        }

        Iterator<PopupText> popupIterator = popups.iterator();
        while (popupIterator.hasNext()) {
            PopupText p = popupIterator.next();
            p.update();

            if (p.isDone()) {
                popupIterator.remove();
            }
        }


        if (spawnNextTarget) {
            spawnNextTarget = false;

            addTarget(ShootableFactory.getWeightedRandomShootable());
        }
    }

    public void togglePause() {
        paused = !paused;

        if (paused) {
            showPauseOverlay();

        } else {
            hidePauseOverlay();
        }
    }

    private void showPauseOverlay() {
        int boxWidth = 400;
        int boxHeight = 150;

        int boxX = (background.getWidth() / 2) - (boxWidth / 2);
        int boxY = (background.getHeight() / 2) - (boxHeight / 2);

        dimPauseOverlay = new Rectangle(boxX, boxY, boxWidth, boxHeight);
        dimPauseOverlay.setColor(new Color(37, 150, 190));
        dimPauseOverlay.fill();
        dimPauseOverlay.draw();

        pauseOverlay = new Text((double) background.getMaxX() / 2 - 50,
                (double) background.getMaxY() / 2 - 10, "GAME PAUSED");
        pauseOverlay.grow(50, 20);
        pauseOverlay.setColor(Color.YELLOW);
        pauseOverlay.draw();
    }

    private void hidePauseOverlay() {
        if (pauseOverlay != null) {
            pauseOverlay.delete();
        }

        if (dimPauseOverlay != null) {
            dimPauseOverlay.delete();
        }
    }

    public void triggerGameOver() {
        gameOver = true;
        delete();
        GameOver gameOver = new GameOver();
        gameOver.load();
    }

    public void delete() {
        background.delete();
    }

    public Player getPlayer() {
        return player;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getPADDING() {
        return PADDING;
    }

    public static void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }

    public static void addTarget(Shootable target) {
        targets.add(target);
        target.init();
    }

    public void addScore(int amount) {
        score += amount;

        scoreText.setText("Score: " + score);

    }

    public static PlayArea getInstance() {
        return instance;
    }

    public static void addPopup(PopupText popup) {
        popups.add(popup);
    }

    public static List<Shootable> getTargets() {
        return Collections.unmodifiableList(targets);
    }
}
