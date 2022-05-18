import java.awt.*;

public class Player extends GameObject
{
    //constructor
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
    }

    //draw player object
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    //movement methods
    public void moveLeft() {
        setSpeedX(-10);
    }
    public void moveRight() {
        setSpeedX(10);
    }

    //update the player
    public void updatePlayer() {
        //if ((getX() + getSpeedX()) >= 0 && (getX() + getWidth() + getSpeedX()) < WordInvadersDriver.WIDTH) {
        setX(getX()+getSpeedX());
        //}

        super.update();
    }
}
