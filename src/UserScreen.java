import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class UserScreen extends JPanel implements ActionListener, KeyListener {

    //image loading variables
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;

    //instance variables
    private Player player;
    private GameManager manager;
    private Timer drawFrame;
    private Timer enemySpawner;

    //constructor
    public UserScreen() {
        player = new Player(500, 860, 90, 90);
        manager = new GameManager(player);

        //timer that runs the "frame rate"
        drawFrame = new Timer(1000 / 90, this);
        drawFrame.start();

        //timer that spawns enemies at a "spawn rate"
        enemySpawner = new Timer(2000, manager);
        enemySpawner.start();

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
        manager.drawObjects(g);
    }

    //updates current level screen at a certain rate
    public void updateLevelScreen() {
        player.updatePlayer();
        manager.updateObjects();
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

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            manager.shootLaser();
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
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(imageFile)));
                gotImage = true;
            } catch (Exception e) {
                System.out.println("Error at: " + e.getMessage());
            }
            needImage = false;
        }
    }
}
