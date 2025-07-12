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
        public Shootable createInstance(int y) {
            return new Rolo(y);
        }
    },
    CAROLINA(Category.ENEMY) {
        @Override
        public Shootable createInstance(int y) {
            return new Carolina(y);
        }
    },
    ANDREIA(Category.ENEMY) {
        @Override
        public Shootable createInstance(int y) {
            return new Andreia(y);
        }
    },
    AFONSO(Category.FRIENDLY) {
        @Override
        public Shootable createInstance(int y) {
            return new Afonso(y);
        }
    },
    MANEL(Category.FRIENDLY) {
        @Override
        public Shootable createInstance(int y) {
            return new Manel(y);
        }
    },
    TIAGO(Category.FRIENDLY) {
        @Override
        public Shootable createInstance(int y) {
            return new Tiago(y);
        }
    },
    ELIAS(Category.BONUS) {
        @Override
        public Shootable createInstance(int y) {
            return new Elias(y);
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

    public abstract Shootable createInstance(int y);

}
