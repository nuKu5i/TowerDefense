package GameEntity.GameTile.Tower;

import javafx.scene.image.Image;

public class SniperTower extends Tower implements TowerProperty {
    public SniperTower() {

    }

    public SniperTower(double x, double y) {
        this.range = SNIPER_TOWER_RANGE;
        this.attackSpeed = SNIPER_TOWER_ATTACKRATE;
        this.setX(x);
        this.setY(y);
        this.reloadTime = 0;
        this.image = IMAGE_SNIPER;
    }
}
