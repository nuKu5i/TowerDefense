package GameEntity.Enemy;

import Main.Player;
import GameEntity.GameTile.Road;

public class TankerEnemy extends Enemy implements EnemyProperty {
    public TankerEnemy(Player player) {
        super(TANKER_ENEMY_HEALTH, TANKER_ENEMY_ARMOR, TANKER_ENEMY_SPEED, (int) TANKER_ENEMY_REWARD, player);
        this.direction = Direction.UP;
        this.setX(Road.wayPoints[0].x);
        this.setY(Road.wayPoints[0].y);
        this.image = IMAGE_TANKER_UP;
        this.setWITDH(EnemyProperty.TANKER_ENEMY_WIDTH);
        this.setHEIGHT(EnemyProperty.TANKER_ENEMY_HEIGHT);
    }
}
