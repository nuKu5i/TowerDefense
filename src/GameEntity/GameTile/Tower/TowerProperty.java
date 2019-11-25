package GameEntity.GameTile.Tower;

import javafx.scene.image.Image;

public interface TowerProperty {

    int NORMAL_TOWER_RANGE = 70;
    int NORMAL_TOWER_ATTACKRATE = 6;
    int NORMAL_TOWER_COST = 150;
    Image IMAGE_NORMAL = new Image("file:out/PNG/normal_tower.png");


    int MACHINEGUN_TOWER_RANGE = 80;
    int MACHINEGUN_TOWER_ATTACKRATE = 10;
    int MACHINEGUN_TOWER_COST = 100;
    Image IMAGE_MACHINEGUN = new Image("file:out/PNG/machinegun_tower.png");


    int SNIPER_TOWER_RANGE = 110;
    int SNIPER_TOWER_ATTACKRATE = 15;
    int SNIPER_TOWER_COST = 170;
    Image IMAGE_SNIPER = new Image("file:out/PNG/sniper_tower.png");
}
