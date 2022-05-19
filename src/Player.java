import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends GameObject
{
    //instance variables
    int speedVal = 14;
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;
    //constructor
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
        if (needImage) {
            loadImage("player.png");
        }
        setSpeedX(0);
    }
    private void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(imageFile)));
                gotImage = true;
            } catch (Exception e) {
                System.out.println("Error at at: " + e.getMessage());
            }
            needImage = false;
        }
    }
    //draw initial player object
    public void draw(Graphics g) {
        if (gotImage) {
            g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.BLUE);
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
    }

    //movement methods (moves player by incrementing the x-position by a "speed" value)
    public void moveLeft() {
        setSpeedX(-speedVal);
    }
    public void moveRight() {
        setSpeedX(speedVal);
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
