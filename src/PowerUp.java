import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;

public class PowerUp extends GameObject
{

    //image loading variables
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;

    //constructor
    public PowerUp(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 6);

        if (needImage) {
            loadImage("ImagesAndText/powerup.png");
        }
    }

    //draws power up object
    public void draw(Graphics g) {
        if (gotImage) {
            g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.YELLOW);
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
    }

    //update the power-up's position according to the speed
    public void updatePowerUp() {
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
