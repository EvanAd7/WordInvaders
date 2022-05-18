import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Player extends GameObject
{

    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;
    //constructor
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
        if(needImage){
            loadImage("player.png");
        }
    }
    //draw player object
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        if(gotImage) {
            g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
    }
    void loadImage(String imageFile)
    {
        if(needImage) {
            try {
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(imageFile)));
                gotImage = true;
            } catch (Exception e) {
                System.out.println("Error opening the file. " + e.getMessage());
            }
            needImage = false;
        }
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
        if ((getX() + getSpeedX()) >= 0 && (getX() + getWidth() + getSpeedX()) < WordInvadersDriver.WIDTH) {
        setX(getX()+getSpeedX());
        }

        super.update();
    }
}
