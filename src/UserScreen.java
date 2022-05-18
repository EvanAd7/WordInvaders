import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserScreen extends JPanel implements ActionListener, KeyListener {

    //instance variables
    Player player;
    GameManager manager;

    //constructor
    public UserScreen() {
        player = new Player(500, 900, 50, 50);
        manager = new GameManager(player);
    }

    //paint the screen with active objects
    @Override
    public void paintComponent(Graphics g) {
        drawLevelScreen(g);
    }

    //draw current user scree
    public void drawLevelScreen(Graphics g) {
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

    }
}
