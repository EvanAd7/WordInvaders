import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserScreen extends JPanel implements ActionListener, KeyListener {

    //instance variables
    Player player;
    GameManager manager;
    Timer drawFrame;
    int inc;
    int x = -1;

    //constructor
    public UserScreen() {
        player = new Player(500, 900, 50, 50);
        manager = new GameManager(player);

        drawFrame = new Timer(1000/60, this);
        drawFrame.start();
        Timer timer = new Timer(1000/60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              UserScreen.this.repaint();
            }
        });
        timer.start();
    }
    //paint the screen with active objects
    @Override
    public void paintComponent(Graphics g) {
        if(x > getWidth()) inc = -5;
        if(x < 0) inc = 5;

        x += inc;

        // here we clear everything
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        drawLevelScreen(g);
    }

    //draw current user screen
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
        player.setSpeedX(0);
    }
}
