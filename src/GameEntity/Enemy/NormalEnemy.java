package GameEntity.Enemy;

import Main.Player;
import GameEntity.GameTile.Road;

public class NormalEnemy extends Enemy implements EnemyProperty {
    public NormalEnemy(Player player) {
        super(NORMAL_ENEMY_HEALTH, NORMAL_ENEMY_ARMOR, NORMAL_ENEMY_SPEED, (int) NORMAL_ENEMY_REWARD, player);
        this.direction = Direction.UP;
        this.setX(Road.wayPoints[0].x);
        this.setY(Road.wayPoints[0].y);
        this.image = IMAGE_NORMAL_UP;
        this.setWITDH(EnemyProperty.NORMAL_ENEMY_WIDTH);
        this.setHEIGHT(EnemyProperty.NORMAL_ENEMY_HEIGHT);
    }
}
