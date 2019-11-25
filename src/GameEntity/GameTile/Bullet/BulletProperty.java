package GameEntity.GameTile.Bullet;

import javafx.scene.paint.Color;

public interface BulletProperty {
    double NORMAL_BULLET_SPEED = 20;
    double NORMAL_BULLET_DAMAGE = 10;
    double NORMAL_BULLET_RANGE = 30;
    double NORMAL_BULLET_WIDTH = 9;
    double NORMAL_BULLET_HEIGHT = 9;
    Color NORMAL_BULLET_COLOR = Color.RED;

    double MACHINEGUN_BULLET_SPEED = 10;
    double MACHINEGUN_BULLET_DAMAGE = 20;
    double MACHINEGUN_BULLET_RANGE = 15;
    double MACHINEGUN_BULLET_WIDTH = 6;
    double MACHINEGUN_BULLET_HEIGHT = 6;
    Color MACHINEGUN_BULLET_COLOR = Color.BLUE;

    double SNIPER_BULLET_SPEED = 30;
    double SNIPER_BULLET_DAMAGE = 40;
    double SNIPER_BULLET_RANGE = 50;
    double SNIPER_BULLET_WIDTH = 10;
    double SNIPER_BULLET_HEIGHT = 10;
    Color SNIPER_BULLET_COLOR = Color.GREEN;
}
