import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Level extends JPanel implements ActionListener, KeyListener {

    int levelNum;
    long time;
    int points;
    boolean cleared;
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<PowerUp> powerUps;
    private String wordTyped;

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    // reads when a letter is typed and adds it to an empty string
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
