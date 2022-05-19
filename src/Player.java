import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends GameObject {
    //image loading variables
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;

    //constructor
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);

        if (needImage) {
            loadImage("player.png");
        }
    }

    //draw initial player object
    public void draw(Graphics g) {
        if (gotImage) {
            g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
    }

    //movement methods (moves player by incrementing the x-position by a "speed" value)
    public void moveLeft() {
        setSpeedX(-13);
    }

    public void moveRight() {
        setSpeedX(13);
    }

    //update the player's position according to the speed
    public void updatePlayer() {
        //check if player remains within bounds
        if ((getX() + getSpeedX() + 13) >= 0 && (getX() + getWidth() + getSpeedX()) < WordInvadersDriver.WIDTH) {
            setX(getX() + getSpeedX());
        }
        super.update();
    }

    //image loading method
    private void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(imageFile)));
                gotImage = true;
            } catch (Exception e) {
                System.out.println("Error at: " + e.getMessage());
            }
            needImage = false;
        }
    }
}
