package GameEntity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameEntity {
    private double x;
    private double y;


    private double width;
    private double height;

    public Image image;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    abstract public  void render(GraphicsContext gc);

    abstract public void update();
}
