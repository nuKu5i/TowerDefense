package GameEntity.Enemy;

import javafx.scene.image.Image;

public interface EnemyProperty {
    public static int maxTotalEnemy = 100;

    static final double NORMAL_ENEMY_HEALTH = 50;
    static final double NORMAL_ENEMY_ARMOR= 10;
    static final int NORMAL_ENEMY_SPEED = 7;
    static final int NORMAL_ENEMY_WIDTH = 34;
    static final int NORMAL_ENEMY_HEIGHT = 32;
    static final int NORMAL_ENEMY_REWARD = 30;
    static final Image IMAGE_NORMAL_LEFT=new Image("file:out/PNG/enemy/normal_enemy_left.png");
    static final Image IMAGE_NORMAL_RIGHT=new Image("file:out/PNG/enemy/normal_enemy_right.png");
    static final Image IMAGE_NORMAL_UP=new Image("file:out/PNG/enemy/normal_enemy_up.png");
    static final Image IMAGE_NORMAL_DOWN=new Image("file:out/PNG/enemy/normal_enemy_down.png");

    static final double TANKER_ENEMY_HEALTH = 150;
    static final double TANKER_ENEMY_ARMOR= 15;
    static final int TANKER_ENEMY_SPEED = 8;
    static final int TANKER_ENEMY_WIDTH = 64;
    static final int TANKER_ENEMY_HEIGHT = 100;
    static final int TANKER_ENEMY_REWARD = 20;
    static final Image IMAGE_TANKER_LEFT=new Image("file:out/PNG/enemy/tanker_enemy_left.png");
    static final Image IMAGE_TANKER_RIGHT=new Image("file:out/PNG/enemy/tanker_enemy_right.png");
    static final Image IMAGE_TANKER_UP=new Image("file:out/PNG/enemy/tanker_enemy_up.png");
    static final Image IMAGE_TANKER_DOWN=new Image("file:out/PNG/enemy/tanker_enemy_down.png");

    static final double SMALLER_ENEMY_HEALTH = 20;
    static final double SMALLER_ENEMY_ARMOR= 6;
    static final int SMALLER_ENEMY_SPEED = 10;
    static final int SMALLER_ENEMY_WIDTH = 32;
    static final int SMALLER_ENEMY_HEIGHT = 30;
    static final int SMALLER_ENEMY_REWARD = 50;
    static final Image IMAGE_SMALLER_LEFT=new Image("file:out/PNG/enemy/smaller_enemy_left.png");
    static final Image IMAGE_SMALLER_RIGHT=new Image("file:out/PNG/enemy/smaller_enemy_right.png");
    static final Image IMAGE_SMALLER_UP=new Image("file:out/PNG/enemy/smaller_enemy_up.png");
    static final Image IMAGE_SMALLER_DOWN=new Image("file:out/PNG/enemy/smaller_enemy_down.png");

    static final double BOSS_ENEMY_HEALTH = 100;
    static final double BOSS_ENEMY_ARMOR= 25;
    static final int BOSS_ENEMY_SPEED = 3;
    static final int BOSS_ENEMY_WIDTH = 66;
    static final int BOSS_ENEMY_HEIGHT = 50;
    static final int BOSS_ENEMY_REWARD = 70;
    static final Image IMAGE_BOSS_LEFT=new Image("file:out/PNG/enemy/boss_enemy_left.png");
    static final Image IMAGE_BOSS_RIGHT=new Image("file:out/PNG/enemy/boss_enemy_right.png");
    static final Image IMAGE_BOSS_UP=new Image("file:out/PNG/enemy/boss_enemy_up.png");
    static final Image IMAGE_BOSS_DOWN=new Image("file:out/PNG/enemy/boss_enemy_down.png");
}
