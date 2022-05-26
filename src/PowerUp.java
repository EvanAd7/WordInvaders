import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;

public class PowerUp extends GameObject {

    //image loading variables
    public static BufferedImage image;

    //constructor
    public PowerUp(int x, int y, int width, int height, int imageNumber) {
        super(x, y, width, height, 0, 5);

        if(imageNumber == 1) {
            loadImage("ImagesAndText/powerup.png");
        } else if(imageNumber == 2) {
            loadImage("ImagesAndText/powerup.png");
        } else if(imageNumber == 3) {
            loadImage("ImagesAndText/shield2.png");
        } else if(imageNumber == 4) {
            loadImage("ImagesAndText/powerup.png");
        } else {
            System.out.println("ImageFile invalid");
        }
    }

    //draws power up object
    public void draw(Graphics g) {
            g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

    //update the power-up's position according to the speed
    public void updatePowerUp() {
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
