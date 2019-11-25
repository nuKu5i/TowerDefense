package Main;
import GameEntity.GameTile.Bullet.BulletManager;
import GameEntity.Enemy.EnemyManager;
import GameEntity.GameTile.Map;
import GameEntity.GameTile.Tower.*;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;

public class GameField extends AnimationTimer {
    public GraphicsContext graphicsContext;
    public Player player;
    public String actionType;
    public boolean actionTower = false;
    public static boolean STOP = false;

    public GameField(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        player = new Player();
        player.setHealth(10);
        player.setGold(500);
        EnemyManager.init(player, graphicsContext);
        TowerManager.init(player, graphicsContext);
        BulletManager.init(player, graphicsContext);
    }

    public void MouseHandling(MouseEvent mouseEvent) {
        int x = (int)mouseEvent.getX()/64 * 64;
        int y = (int)mouseEvent.getY()/64 * 64;
        if (actionTower) {
            actionTower = false;
            if (actionType.equals("NormalTower")) {
                if (player.getGold() >= TowerProperty.NORMAL_TOWER_COST) {
                    if(Map.grid_map[x/64][y/64] == 0 ){
                        TowerManager.addTower(new NormalTower(x, y));
                        //Map.grid_map[x/64][y/64] = 2;
                        player.setGold(player.getGold() - TowerProperty.NORMAL_TOWER_COST);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Attention");
                    alert.setHeaderText("Not enough money");
                    alert.show();
                }
            } else if (actionType.equals("MachineGunTower")) {
                if (player.getGold() >= TowerProperty.MACHINEGUN_TOWER_COST) {
                    if(Map.grid_map[x/64][y/64] == 0 ) {
                        TowerManager.addTower(new MachineGunTower(x, y));
                        //Map.grid_map[x/64][y/64] = 2;
                        player.setGold(player.getGold() - TowerProperty.MACHINEGUN_TOWER_COST);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Attention");
                    alert.setHeaderText("Not enough money");
                    alert.show();
                }
            } else if(actionType.equals("SniperTower")) {
                if (player.getGold() >= TowerProperty.SNIPER_TOWER_COST) {
                    if(Map.grid_map[x/64][y/64] == 0 ) {
                        TowerManager.addTower(new SniperTower(x, y));
                        
                        player.setGold(player.getGold() - TowerProperty.SNIPER_TOWER_COST);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Attention");
                    alert.setHeaderText("Not enough money");
                    alert.show();
                }
            }
            else if(actionType.equals("Sell")){
                /*
                    SELL TOWER
                 */
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Attention");
                alert.setHeaderText("Bọn em chưa làm xong");
                alert.show();
            }
            else {
                /*
                    UPGRADE TOWER
                 */
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Attention");
                alert.setHeaderText("Bọn em chưa làm xong");
                alert.show();
            }
        }
    }

    public void actionTower(ActionEvent event) {
        String id = ((Control) event.getSource()).getId();
        actionType = id;
        actionTower = !actionTower;
    }

    @Override
    public void handle(long now) {
        if (player.getHealth() <= 0) {
            EnemyManager.counter = 0;
            this.restart();
            player.setHealth(10);
            player.setGold(500);
            GameStage.window.setScene(GameStage.sceneExit);
            GameStage.window.show();
            return;
        } else if (EnemyManager.winGame()) {
            this.restart();
            EnemyManager.counter = 0;
            player.setHealth(10);
            player.setGold(500);
            GameStage.window.setScene(GameStage.sceneWin);
            GameStage.window.show();
            return;
        } else {
            update();
            render();
            String health = "" + player.getHealth();
            String coin = "" + player.getGold();
            GameStage.labelHealth.setText(health);
            GameStage.labelCoin.setText(coin);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void restart() {
        player.setHealth(10);
        player.setGold(500);
        EnemyManager.listEnemy.clear();
        TowerManager.towers.clear();
        BulletManager.bullets.clear();
    }

    public void start() {
        render();
        super.start();
    }

    public void render() {

        Map.draw(graphicsContext);
        TowerManager.render();
        EnemyManager.render();
        BulletManager.render();
    }

    public void update() {
        EnemyManager.update();
        TowerManager.update();
        BulletManager.update();
    }

    public void restartGame() {
        restart();
        GameStage.window.setScene(GameStage.sceneStart);
        GameStage.window.show();
    }

}

