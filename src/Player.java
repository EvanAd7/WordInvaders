import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends GameObject {

    //image loading variables
    public static BufferedImage image;

    //instance variables
    private int lives;

    //constructor
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
        lives = 3;

        loadImage("ImagesAndText/player.png");
    }

    //draws player object
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
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

    //getters
    public int getLives() {
        return lives;
    }

    //setters
    public void setLives(int lives) {
        this.lives = lives;
    }

    //image loading method
    private void loadImage(String imageFile) {
        try {
            image = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(imageFile)));
        } catch (Exception e) {
            System.out.println("Error at: " + e.getMessage());
        }
    }
}
