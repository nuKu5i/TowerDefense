package GameEntity.Enemy;

import GameEntity.GameEntity;
import GameEntity.GameTile.Map;
import Main.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Enemy extends GameEntity implements EnemyProperty {
    private double health;
    private double armor;
    private double speed;
    private int reward;

    public Image image;
    private int WITDH;
    private int HEIGHT;
    private boolean destroy;

    private Player player;

    public Direction direction = Direction.UP;

    public Enemy(double health, double armor, double speed, int reward, Player player) {
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        this.direction = Direction.UP;
        this.player = player;
    }

    public void render(GraphicsContext gc) {

        switch (direction) {
            case UP:
                if(this instanceof NormalEnemy){
                    image = IMAGE_NORMAL_UP;
                }
                else if(this instanceof  SmallerEnemy){
                    image = IMAGE_SMALLER_UP;
                }
                else if(this instanceof  TankerEnemy){
                    image = IMAGE_TANKER_UP;
                    setWITDH(TANKER_ENEMY_WIDTH);
                    setHEIGHT(TANKER_ENEMY_HEIGHT);
                }
                else {
                    image = IMAGE_BOSS_UP;
                    setHEIGHT(BOSS_ENEMY_HEIGHT);
                    setWITDH(BOSS_ENEMY_WIDTH);
                }
                break;
            case DOWN:
                if(this instanceof NormalEnemy){
                    image = IMAGE_NORMAL_DOWN;
                }
                else if(this instanceof  SmallerEnemy){
                    image = IMAGE_SMALLER_DOWN;
                }
                else if(this instanceof  TankerEnemy){
                    image = IMAGE_TANKER_DOWN;
                    setWITDH(TANKER_ENEMY_WIDTH);
                    setHEIGHT(TANKER_ENEMY_HEIGHT);
                }
                else {
                    image = IMAGE_BOSS_DOWN;
                    setHEIGHT(BOSS_ENEMY_HEIGHT);
                    setWITDH(BOSS_ENEMY_WIDTH);
                }
                break;
            case LEFT:
                if(this instanceof NormalEnemy){
                    image = IMAGE_NORMAL_LEFT;
                }
                else if(this instanceof  SmallerEnemy){
                    image = IMAGE_SMALLER_LEFT;
                }
                else if(this instanceof  TankerEnemy){
                    image = IMAGE_TANKER_LEFT;
                    setWITDH(TANKER_ENEMY_HEIGHT);
                    setHEIGHT(TANKER_ENEMY_WIDTH);
                }
                else {
                    image = IMAGE_BOSS_LEFT;
                    setHEIGHT(BOSS_ENEMY_WIDTH);
                    setWITDH(BOSS_ENEMY_HEIGHT);
                }
                break;
            case RIGHT:
                if(this instanceof NormalEnemy){
                    image = IMAGE_NORMAL_RIGHT;
                }
                else if(this instanceof  SmallerEnemy){
                    image = IMAGE_SMALLER_RIGHT;
                }
                else if(this instanceof  TankerEnemy){
                    image = IMAGE_TANKER_RIGHT;
                    setWITDH(TANKER_ENEMY_HEIGHT);
                    setHEIGHT(TANKER_ENEMY_WIDTH);
                }
                else {
                    image = IMAGE_BOSS_RIGHT;
                    setHEIGHT(BOSS_ENEMY_WIDTH);
                    setWITDH(BOSS_ENEMY_HEIGHT);
                }
                break;
        }
        gc.drawImage(image, getX(), getY(), WITDH, HEIGHT);
    }

    private void calculateDirection() {
        int currentX = (int)getX()/64 ;
        int currentY = (int)getY()/64 ;
        //System.out.println(currentX + ", " +currentY);
        if(currentX == 1 && currentY == 3) direction = Direction.RIGHT;
        else if(currentX == 3 && currentY == 3) direction = Direction.UP;
        else if(currentX == 3 && currentY == 0) direction = Direction.RIGHT;
        else if(currentX == 7 && currentY == 0) direction = Direction.DOWN;
        else if(currentX == 7 && currentY == 5) direction = Direction.RIGHT;
        else if(currentX == 10 && currentY == 5) direction = Direction.UP;
        else if(currentX == 10 && currentY == 3) direction = Direction.RIGHT;
        /*if(direction == Direction.RIGHT && Map.grid_map[currentX + 1][currentY] != 1 ){
            if(Map.grid_map[currentX][currentY - 1] == 1 ){
                direction = Direction.UP;
            }
            if(Map.grid_map[currentX][currentY + 1] == 1 ){
                direction = Direction.DOWN;
            }
        }
        if(direction == Direction.LEFT && Map.grid_map[currentX - 1][currentY] != 1 ){
            if(Map.grid_map[currentX][currentY - 1] == 1 ){
                direction = Direction.UP;
            }
            if(Map.grid_map[currentX][currentY + 1] == 1 ){
                direction = Direction.DOWN;
            }
        }
        if(direction == Direction.UP && Map.grid_map[currentX][currentY - 1] != 1 ){
            if(Map.grid_map[currentX - 1][currentY] == 1 ){
                direction = Direction.LEFT;
            }
            if(Map.grid_map[currentX + 1][currentY] == 1 ){
                direction = Direction.RIGHT;
            }
        }
        if(direction == Direction.DOWN && Map.grid_map[currentX][currentY + 1] != 1 ){
            if(Map.grid_map[currentX + 1][currentY] == 1 ){
                direction = Direction.RIGHT;
            }
            if(Map.grid_map[currentX - 1][currentY] == 1 ){
                direction = Direction.LEFT;
            }
        }*/
    }

    @Override
    public void update() {
        if (health <= 0) {
            doDestroy();
        } else if (endRoad()) {
            doDamage();
            doDestroy();
        } else {
            calculateDirection();
            switch (direction) {
                case UP:
                    setY(getY() - speed);
                    break;
                case DOWN:
                    setY(getY() + speed);
                    break;
                case LEFT:
                    setX(getX() - speed);
                    break;
                case RIGHT:
                    setX(getX() + speed);
                    break;
            }
        }
    }

    enum Direction {
        LEFT(180), UP(90), RIGHT(0), DOWN(270);

        public int degree;

        Direction(int i) {
            degree = i;
        }

        public int getDegree() {
            return degree;
        }
    }

    public void doDestroy() {
        destroy = true;
    }

    public boolean endRoad(){
        int tempX = (int)getX()/64;
        if(tempX == 15) {
            return true;
        }
        return false;
    }

    public void doDamage() {
        player.beAttacked();
    }


    public void beAttacked(final double damage) {
        this.health -= damage;
        if (this.health <= 0) {
            doDestroy();
            player.earnMoney(this.reward);
        }
    }

    public boolean isDestroy() {
        return destroy;
    }

    public void setWITDH(int WITDH) {
        this.WITDH = WITDH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWITDH() {
        return WITDH;
    }
}
