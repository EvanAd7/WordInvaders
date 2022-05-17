import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level extends JPanel implements ActionListener, KeyListener {

    int levelNum;
    long time;
    int points;
    boolean cleared;
    Player player;
    ArrayList<Enemy> enemies;
    ArrayList<PowerUp> powerUps;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public int getTime()
    {
        long startTime = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - startTime;
        long elapsedSeconds = elapsedTime / 1000;
        return (int) elapsedSeconds % 60;
    }
}
