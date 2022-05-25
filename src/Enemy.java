import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Enemy extends GameObject {

    //image loading variables
    public static BufferedImage image;
    public static BufferedImage image2;
    public static BufferedImage image3;
    public static BufferedImage image4;


    //constructor
    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 1);

        loadImage("ImagesAndText/enemy.png");
        loadImage2("ImagesAndText/enemy.png");
        loadImage3("ImagesAndText/enemy.png");
        loadImage4("ImagesAndText/enemy.png");

    }

    //draws enemy objects
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

    //update the enemy's position according to the speed
    public void updateEnemy() {
        setY(getY() + getSpeedY());
        super.update();
    }

    //image loading method
    private void loadImage(String imageFile) {
        try {
            image = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(imageFile)));
        } catch (Exception e) {
            System.out.println("Error at: " + e.getMessage());
        }
    }
    private void loadImage2(String imageFile) {
        try {
            image2 = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(imageFile)));
        } catch (Exception e) {
            System.out.println("Error at: " + e.getMessage());
        }
    }
    private void loadImage3(String imageFile) {
        try {
            image3 = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(imageFile)));
        } catch (Exception e) {
            System.out.println("Error at: " + e.getMessage());
        }
    }private void loadImage4(String imageFile) {
        try {
            image4 = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(imageFile)));
        } catch (Exception e) {
            System.out.println("Error at: " + e.getMessage());
        }
    }
}
