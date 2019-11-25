package GameEntity.GameTile.Tower;

import Main.Player;
import javafx.scene.canvas.GraphicsContext;

import java.util.HashSet;
import java.util.Set;

public class TowerManager {
    public static Set<Tower> towers;
    private static Player player;
    private static GraphicsContext graphicsContext;

    public static boolean init(Player _player, GraphicsContext _graphicsContext) {
        player = _player;
        towers = new HashSet<Tower>();
        graphicsContext = _graphicsContext;
        return true;
    }

    public static void update() {
        if (!towers.isEmpty())
            for (Tower tower : towers)
                tower.update();
    }

    public static void render() {
        if (!towers.isEmpty())
            for (Tower tower : towers)
                tower.render(graphicsContext);

    }
    public static void addTower(Tower tower) {
        towers.add(tower);
    }

    public static void removeTower(Tower tower){
        towers.remove(tower);
    }
}
