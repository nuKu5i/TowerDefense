package GameEntity.GameTile.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.GameTile.Tower.Tower;

public class MachineGunBullet extends Bullet implements BulletProperty {
    public MachineGunBullet(Enemy target, Tower tower) {
        super(target, tower);
        this.damage = MACHINEGUN_BULLET_DAMAGE;
        this.speed = MACHINEGUN_BULLET_SPEED;
        this.setWidth(MACHINEGUN_BULLET_WIDTH);
        this.setHeight(MACHINEGUN_BULLET_HEIGHT);
        this.color = MACHINEGUN_BULLET_COLOR;
    }
}
