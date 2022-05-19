import java.awt.*;

public class Player extends GameObject {

    //constructor
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
    }

    //draw initial player object
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    //movement methods (moves player by incrementing the x-position by a "speed" value)
    public void moveLeft() {
        setSpeedX(-14);
    }
    public void moveRight() {
        setSpeedX(14);
    }

    //update the player's position according to the speed
    public void updatePlayer() {
        //check if player remains within bounds
        if ((getX() + getSpeedX()) >= 0 && (getX() + getWidth() + getSpeedX()) < WordInvadersDriver.WIDTH) {
            setX(getX()+getSpeedX());
        }
        super.update();
    }
}
