import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Laser extends GameObject {

    //image loading variables
    public static BufferedImage image;

    //constructor
    public Laser(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 10);

        loadImage("ImagesAndText/laser.png");
    }

    //draws laser object
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

    //update the laser's position according to the speed
    public void updateLaser() {
        setY(getY() - getSpeedY());
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
