import java.awt.*;

public class GameObject {

    //instance variables
    private int x;
    private int y;
    private int width;
    private int height;

    private int speedX;
    private int speedY;

    private Rectangle collisionBox;
    private boolean active;

    //constructor
    GameObject(int x, int y, int width, int height, int speedX, int speedY) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speedX = speedX;
        this.speedY = speedY;

        active = true;
        collisionBox = new Rectangle(x, y, width, height);
    }

    //superclass update method updates the collision box
    void update() {
        collisionBox.setBounds(x, y, width, height);
    }

    //getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public boolean isActive() {
        return active;
    }

    public Rectangle getCollisionBox() {
        return collisionBox;
    }

    //setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
