import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class UserScreen extends JPanel implements ActionListener, KeyListener {

    //instance variables
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;

    Player player;
    GameManager manager;
    Timer drawFrame;

    //constructor
    public UserScreen() {
        player = new Player(500, 900, 50, 50);
        manager = new GameManager(player);

        drawFrame = new Timer(1000/60, this);
        drawFrame.start();

        if (needImage) {
            loadImage ("space.jpg");
        }
    }

    //paint the screen with active objects
    @Override
    public void paintComponent(Graphics g) {
        drawLevelScreen(g);
    }

    //draw current user screen
    public void drawLevelScreen(Graphics g) {
        g.drawImage(image, 0, 0, null);
        manager.draw(g);
    }

    //update current user screen
    public void updateLevelScreen() {
        player.updatePlayer();
    }

    //key and action listener methods
    @Override
    public void actionPerformed(ActionEvent e) {
        updateLevelScreen();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.setSpeedX(0);
    }

    void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
                gotImage = true;
            } catch (Exception e) {

            }
            needImage = false;
        }
    }
}
