import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class UserScreen extends JPanel implements ActionListener, KeyListener {

    //image loading variables
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;

    //instance variables
    Player player;
    GameManager manager;
    Timer drawFrame;

    //constructor
    public UserScreen() {
        player = new Player(500, 900, 50, 50);
        manager = new GameManager(player);

        //timer that runs the "frame rate"
        drawFrame = new Timer(1000/144, this);
        drawFrame.start();

        if (needImage) {
            loadImage("space.jpg");
        }
    }

    //paint the screen (JPanel) with initial active objects
    @Override
    public void paintComponent(Graphics g) {
        drawLevelScreen(g);
    }

    //draws the initial level screen
    public void drawLevelScreen(Graphics g) {
        g.drawImage(image, 0, 0, null);
        manager.draw(g);
    }

    //updates current level screen periodically
    public void updateLevelScreen() {
        player.updatePlayer();
    }

    //key and action listener methods
    //action performed method runs at a certain frame rate
    @Override
    public void actionPerformed(ActionEvent e) {
        //update all objects then repaint the screen
        updateLevelScreen();
        repaint();
    }

    //reads when a key is typed by the user
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //reads when the user presses a key and translates into code
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moveRight();
        }
    }

    //stops movement upon release of a key
    @Override
    public void keyReleased(KeyEvent e) {
        player.setSpeedX(0);
    }

    //image loading method
    void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
                gotImage = true;
            } catch (Exception e) {}
            needImage = false;
        }
    }
}
