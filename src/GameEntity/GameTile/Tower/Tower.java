package GameEntity.GameTile.Tower;

import GameEntity.GameTile.Bullet.*;
import GameEntity.Enemy.Enemy;
import GameEntity.Enemy.EnemyManager;
import GameEntity.GameEntity;
import Main.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Tower extends GameEntity {
    protected Enemy target;
    private Player player;
    protected Image image;
    private MediaPlayer shoot;

    protected int range;
    protected int attackSpeed;
    protected int reloadTime;
    private boolean destroy = false;

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(image, getX(), getY(), 64, 64);
    }

    @Override
    public void update() {
        if (target != null) updateReloadTime();
        else reloadTime = 0;
        findEnemy();
        if (reloadTime > attackSpeed && target != null) {
            reloadTime = 0;
            BulletManager.addBullet(target, this);
            shootSound();
        }
    }

    public int getRange() {
        return this.range;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void doDestroy() {
        destroy = true;
    }

    public void shootSound(){
        try{
            Media media = new Media(getClass().getResource("file:/SND/shoot.wav").toURI().toString());
            shoot = new MediaPlayer(media);
            shoot.setAutoPlay(true);
            shoot.setVolume(1);
        }
        catch (Exception e){};
    }

    public void updateReloadTime() {
        reloadTime++;
    }

    public void findEnemy() {
        if (target != null) {
            if (target.isDestroy()) target = null;
            else {
                double distance = Math.sqrt(Math.sqrt(Math.pow(this.getX() - target.getX(), 2) + Math.pow(this.getY() - target.getY(), 2)));
                if (distance > range) target = null;
            }
        }
        if (target == null) {
            for (Enemy enemy : EnemyManager.listEnemy) {
                double distance = Math.sqrt(Math.sqrt(Math.pow(this.getX() - enemy.getX(), 2) + Math.pow(this.getY() - enemy.getY(), 2)));
                if (distance <= range) {
                    target = enemy;
                    break;
                }
            }
        }
    }

}
