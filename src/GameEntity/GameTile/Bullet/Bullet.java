package GameEntity.GameTile.Bullet;

import GameEntity.GameTile.Tower.Tower;
import GameEntity.Enemy.Enemy;
import GameEntity.GameEntity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet extends GameEntity {

    protected Enemy target;
    protected Tower tower;
    protected Color color;

    protected double speed;
    protected double damage;
    protected boolean destroy = false;


    public Bullet(Enemy target, Tower tower) {
        this.tower = tower;
        this.target = target;
        this.setX(tower.getX());
        this.setY(tower.getY());
    }

    public double getAngle() {
        return Math.atan2(target.getY() - getY(), target.getX() - getX());
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void update() {
        move();
        if (isHit()) {
            doDamage();
            doDestroy();
        } else if (Math.sqrt(Math.pow(this.getX() - tower.getX(), 2) + Math.pow(this.getY() - tower.getY(), 2)) > tower.getRange())
            doDestroy();
    }

    public void move() {
        setX(getX() + speed * Math.cos(getAngle()));
        setY(getY() + speed * Math.sin(getAngle()));
    }

    public void doDamage() {
        target.beAttacked(damage);
    }

    public void doDestroy() {
        destroy = true;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public boolean isHit() {
        return (Math.abs(getX() - target.getX() - 32) < target.getWITDH()/2 && Math.abs(getY() - target.getY() - 32) < target.getHEIGHT());
    }
}


