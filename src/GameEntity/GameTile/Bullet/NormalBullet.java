package GameEntity.GameTile.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.GameTile.Tower.Tower;

public class NormalBullet extends Bullet implements BulletProperty {
    public NormalBullet(Enemy target, Tower tower) {
        super(target, tower);
        this.damage = NORMAL_BULLET_DAMAGE;
        this.speed = NORMAL_BULLET_SPEED;
        this.setWidth(NORMAL_BULLET_WIDTH);
        this.setHeight(NORMAL_BULLET_HEIGHT);
        this.color = NORMAL_BULLET_COLOR;
    }

}
