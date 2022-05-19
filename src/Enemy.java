import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Enemy extends GameObject {
    //image loading variables
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;

    //constructor
    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 1);

        if (needImage) {
            loadImage("enemy1.png");
        }
    }

    //draw initial enemy objects
    public void draw(Graphics g) {
        if (gotImage) {
            g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.GREEN);
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
    }

    //update the enemy's position according to the speed
    public void updateEnemy() {
        setY(getY() + getSpeedY());
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
