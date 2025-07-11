package io.codeforall.bootcamp.shootable;

import io.codeforall.bootcamp.shootable.bonus.Elias;
import io.codeforall.bootcamp.shootable.enemy.Andreia;
import io.codeforall.bootcamp.shootable.enemy.Carolina;
import io.codeforall.bootcamp.shootable.enemy.Rolo;
import io.codeforall.bootcamp.shootable.friendly.Afonso;
import io.codeforall.bootcamp.shootable.friendly.Manel;
import io.codeforall.bootcamp.shootable.friendly.Tiago;

public enum ShootableType {

    ROLO(Category.ENEMY) {
        @Override
        public Shootable createInstance() {
            return new Rolo();
        }
    },
    CAROLINA(Category.ENEMY) {
        @Override
        public Shootable createInstance() {
            return new Carolina();
        }
    },
    ANDREIA(Category.ENEMY) {
        @Override
        public Shootable createInstance() {
            return new Andreia();
        }
    },
    AFONSO(Category.FRIENDLY) {
        @Override
        public Shootable createInstance() {
            return new Afonso();
        }
    },
    MANEL(Category.FRIENDLY) {
        @Override
        public Shootable createInstance() {
            return new Manel();
        }
    },
    TIAGO(Category.FRIENDLY) {
        @Override
        public Shootable createInstance() {
            return new Tiago();
        }
    },
    ELIAS(Category.BONUS) {
        @Override
        public Shootable createInstance() {
            return new Elias();
        }
    };

    public enum Category {ENEMY, FRIENDLY, BONUS}

    private final Category category;

    ShootableType(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public abstract Shootable createInstance();

}
