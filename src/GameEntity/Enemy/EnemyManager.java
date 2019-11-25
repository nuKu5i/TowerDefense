package GameEntity.Enemy;

import Main.Config;
import Main.Player;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class EnemyManager implements EnemyProperty {
    public static ArrayList<Enemy> listEnemy;
    private static Player player;
    public static int counter;
    private static int currentTotalEnemy = 0;
    private static int currentEnemyId;
    private static GraphicsContext graphicsContext;

    public int getCounter() {
        return counter;
    }

    private static void addEnemy(Enemy enemy) {
        listEnemy.add(enemy);
    }

    public static void init(Player _player, GraphicsContext _graphicsContext) {
        player = _player;
        graphicsContext = _graphicsContext;
        listEnemy = new ArrayList<>();
    }

    public static void update() {
        counter++;
        if (!listEnemy.isEmpty()) {
            for (Enemy enemy : listEnemy) {
                enemy.update();
            }
            listEnemy.removeIf(Enemy::isDestroy);
        }
        spawEnemy();
    }

    public static void render() {
        if (!listEnemy.isEmpty()) {
            for (Enemy enemy : listEnemy) {
                enemy.render(graphicsContext);
            }
        }
    }
    public static void spawEnemy(){
        if(currentTotalEnemy < 40 && counter > 50){
            currentEnemyId = (int) (Math.random() * 2);
            if(currentEnemyId == 0){
                listEnemy.add(new SmallerEnemy(player));
                currentTotalEnemy++;
            }
            else {
                listEnemy.add(new NormalEnemy(player));
                currentTotalEnemy++;
            }

            counter = 0;
        }
        else if(currentTotalEnemy < 60 && counter > 60){
            currentEnemyId = (int) (Math.random() * 3);
            if(currentEnemyId == 0){
                listEnemy.add(new SmallerEnemy(player));
                currentTotalEnemy++;
            }
            else if(currentEnemyId == 1){
                listEnemy.add(new NormalEnemy(player));
                currentTotalEnemy++;
            }
            else {
                listEnemy.add(new TankerEnemy(player));
                currentTotalEnemy++;
            }
            counter = 0;
        }
        else if(currentTotalEnemy > 70 && counter >70) {
            currentEnemyId = (int) (Math.random() * 5);
            if(currentEnemyId == 0){
                listEnemy.add(new SmallerEnemy(player));
                currentTotalEnemy++;
            }
            else if(currentEnemyId == 1){
                listEnemy.add(new NormalEnemy(player));
                currentTotalEnemy++;
            }
            else if(currentEnemyId == 2){
                listEnemy.add(new TankerEnemy(player));
                currentTotalEnemy++;
            }
            else {
                listEnemy.add(new BossEnemy(player));
                currentTotalEnemy++;
            }
            counter = 0;
        }
    }

    public static boolean winGame() {
        return currentTotalEnemy ==  maxTotalEnemy && listEnemy.size() == 0;
    }

}
