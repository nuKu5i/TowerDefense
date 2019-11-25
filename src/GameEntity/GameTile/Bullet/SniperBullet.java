package GameEntity.GameTile.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.GameTile.Tower.Tower;

public class SniperBullet extends Bullet implements BulletProperty {
    public SniperBullet(Enemy target, Tower tower) {
        super(target, tower);
        this.damage = SNIPER_BULLET_DAMAGE;
        this.speed = SNIPER_BULLET_SPEED;
        this.setWidth(SNIPER_BULLET_WIDTH);
        this.setHeight(SNIPER_BULLET_HEIGHT);
        this.color = SNIPER_BULLET_COLOR;
    }
}
