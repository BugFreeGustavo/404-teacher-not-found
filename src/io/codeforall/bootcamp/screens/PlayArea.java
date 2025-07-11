package io.codeforall.bootcamp.screens;

import com.codeforall.simplegraphics.graphics.Rectangle;
import com.codeforall.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.players.Gustavo;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.shootable.Shootable;
import io.codeforall.bootcamp.shootable.enemy.Rolo;
import io.codeforall.bootcamp.shootable.friendly.Afonso;
import io.codeforall.bootcamp.utils.CollisionChecker;
import io.codeforall.bootcamp.utils.MyKeyboardHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayArea {

    private Rectangle myScreenSize;
    private Picture background;
    private MyKeyboardHandler myKeyboardHandler;
    private Player gustavo;

    private static List<Bullet> bullets = new ArrayList<>();
    private static List<Shootable> targets = new ArrayList<>();

    private static final int PADDING = 10;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    public PlayArea(MyKeyboardHandler keyboardHandler) {
        this.myKeyboardHandler = keyboardHandler;

        myScreenSize = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        background = new Picture(PADDING, PADDING, "resources/Background/play-area.jpg");

        gustavo = new Gustavo(20, 650);


    }

    public void load() {
        myScreenSize.draw();
        System.out.println("LOADING PLAY AREA");
        background.draw();
        System.out.println("LOADING BACKGROUND");
        gustavo.init();
        System.out.println("LOADING GUSTAVO");

        addTarget(new Rolo());
        targets.getFirst().init();
        System.out.println("LOADING ROLO 1");

        if (targets.getFirst() == null) {
            addTarget(new Afonso());
            System.out.println("LOADING AFONSO 1");
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
        gustavo.update();

        Iterator<Bullet> iterator = bullets.iterator();

        while (iterator.hasNext()) {
            Bullet b = iterator.next();
            b.move();

            for (Shootable target : targets) {
                if (!b.isCollided() && CollisionChecker.isColliding(b, target)) {
                    b.setCollided();
                    target.onHit();
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
            }
        }
    }

    public void delete() {
        background.delete();
    }

    public Player getGustavo() {
        return gustavo;
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
        for (int i = 0; i < 10; i++) {
            targets.add(target);
        }
    }
}
