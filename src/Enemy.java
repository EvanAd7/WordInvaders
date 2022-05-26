import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Enemy extends GameObject {

    //image loading variables
    private static BufferedImage image;

    //constructor
    public Enemy(int x, int y, int width, int height, int imageNumber) {
        super(x, y, width, height, 0, 1);
        if(imageNumber == 1) {
            loadImage("ImagesAndText/enemyShip1.png");
        } else if(imageNumber == 2) {
            loadImage("ImagesAndText/enemy.png");
        } else if(imageNumber == 3) {
            loadImage("ImagesAndText/enemy.png");
        } else if(imageNumber == 4) {
            loadImage("ImagesAndText/demonShip.png");
        } else {
            System.out.println("ImageFile invalid");
        }
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
}
