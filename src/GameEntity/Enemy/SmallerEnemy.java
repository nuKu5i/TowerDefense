package GameEntity.Enemy;

import Main.Player;
import GameEntity.GameTile.Road;

public class SmallerEnemy extends Enemy implements EnemyProperty {

    public SmallerEnemy(Player player) {
        super(SMALLER_ENEMY_HEALTH, SMALLER_ENEMY_ARMOR, SMALLER_ENEMY_SPEED, (int) SMALLER_ENEMY_REWARD, player);
        this.direction = Direction.UP;
        this.setX(Road.wayPoints[0].x);
        this.setY(Road.wayPoints[0].y);
        this.image = IMAGE_SMALLER_UP;
        this.setWITDH(EnemyProperty.SMALLER_ENEMY_WIDTH);
        this.setHEIGHT(EnemyProperty.SMALLER_ENEMY_HEIGHT);
    }
}
