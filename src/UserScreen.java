import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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

    //paint the screen (JPanel) with active objects
    @Override
    public void paintComponent(Graphics g) {
        drawLevelScreen(g);
    }

    //draws the level screen
    public void drawLevelScreen(Graphics g) {
        g.drawImage(image, 0, 0, null);
        manager.drawObjects(g);

        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.setColor(Color.GREEN);
        g.drawString("Score: " + manager.getPoints(), 10, 30);

        /*
        Graphics2D g3 = (Graphics2D) g;
        Font currentFont2 = g3.getFont(); //getting the current font snd setting it to a temporary Font variable
        Font newFont2 = currentFont2.deriveFont(currentFont2.getSize() * 1.8F); //making a new font bigger
        g3.setFont(newFont2); //setting font to new bigger font
        g3.setColor(Color.WHITE); //changing color so it stands out
        String[] parts;
        if(manager.checkForEnemy()) {
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\tobyp_8bbjnrg\\OneDrive\\Desktop\\strings.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();

                }
                String everything = sb.toString();
                parts = everything.split(" ");


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(wordUsed())
            {
                g3.drawString(parts[((int) (Math.random() * parts.length))], 415, 50);
            }
        }

        */

    }




    //updates current level's objects at a certain rate
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
