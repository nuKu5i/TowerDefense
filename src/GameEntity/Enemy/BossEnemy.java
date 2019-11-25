package GameEntity.Enemy;

import Main.Player;
import GameEntity.GameTile.Road;

public class BossEnemy extends Enemy implements EnemyProperty {

    public BossEnemy(Player player) {
        super(BOSS_ENEMY_HEALTH, BOSS_ENEMY_ARMOR, BOSS_ENEMY_SPEED, (int) BOSS_ENEMY_REWARD, player);
        this.direction = Direction.UP;
        this.setX(Road.wayPoints[0].x);
        this.setY(Road.wayPoints[0].y);
        this.image = IMAGE_BOSS_UP;
        this.setWITDH(EnemyProperty.BOSS_ENEMY_WIDTH);
        this.setHEIGHT(EnemyProperty.BOSS_ENEMY_HEIGHT);
    }
}
