package GameEntity.GameTile.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.GameTile.Tower.MachineGunTower;
import GameEntity.GameTile.Tower.NormalTower;
import GameEntity.GameTile.Tower.SniperTower;
import GameEntity.GameTile.Tower.Tower;
import Main.Player;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BulletManager {
    public static List<Bullet> bullets;
    public static GraphicsContext graphicsContext;
    public static Player player;

    public static boolean init(Player _player, GraphicsContext _graphicsContext) {
        player = _player;
        graphicsContext = _graphicsContext;
        bullets = new ArrayList<Bullet>();
        return true;
    }

    public static void addBullet(Enemy enemy, Tower tower) {
        if (tower instanceof NormalTower) {
            bullets.add(new NormalBullet(enemy, tower));
        } else if (tower instanceof SniperTower) {
            bullets.add(new SniperBullet(enemy, tower));
        } else if (tower instanceof MachineGunTower) {
            bullets.add(new MachineGunBullet(enemy, tower));
        }
    }

    public static void deleteBullet(Bullet bullet) {
        bullets.remove(bullet);
    }

    public static void reset() {
        bullets.clear();
    }

    public static void update() {
        if (!bullets.isEmpty()) {
            for (Bullet bullet : bullets) bullet.update();
            bullets.removeIf(Bullet::isDestroy);
        }
    }

    public static void render() {
        for (Bullet bullet : bullets) {
            bullet.render(graphicsContext);
        }

    }
}
