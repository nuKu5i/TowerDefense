package GameEntity.GameTile.Tower;
import javafx.scene.image.Image;

public class NormalTower extends Tower implements TowerProperty {

    public NormalTower(double x, double y) {
        this.range = NORMAL_TOWER_RANGE;
        this.attackSpeed = NORMAL_TOWER_ATTACKRATE;
        this.setX(x);
        this.setY(y);
        this.reloadTime = 0;
        this.image = IMAGE_NORMAL;
    }
}
