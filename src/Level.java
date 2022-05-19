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
        wordTyped = "";
        if (e.getKeyCode() == KeyEvent.VK_A) {
            wordTyped += "a";
        } else if (e.getKeyCode() == KeyEvent.VK_B) {
            wordTyped += "b";
        } else if (e.getKeyCode() == KeyEvent.VK_C) {
            wordTyped += "c";
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            wordTyped += "d";
        } else if (e.getKeyCode() == KeyEvent.VK_E) {
            wordTyped += "e";
        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            wordTyped += "f";
        } else if (e.getKeyCode() == KeyEvent.VK_G) {
            wordTyped += "g";
        } else if (e.getKeyCode() == KeyEvent.VK_H) {
            wordTyped += "h";
        } else if (e.getKeyCode() == KeyEvent.VK_I) {
            wordTyped += "i";
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            wordTyped += "j";
        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            wordTyped += "k";
        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            wordTyped += "l";
        } else if (e.getKeyCode() == KeyEvent.VK_M) {
            wordTyped += "m";
        } else if (e.getKeyCode() == KeyEvent.VK_N) {
            wordTyped += "n";
        } else if (e.getKeyCode() == KeyEvent.VK_O) {
            wordTyped += "o";
        } else if (e.getKeyCode() == KeyEvent.VK_P) {
            wordTyped += "p";
        } else if (e.getKeyCode() == KeyEvent.VK_Q) {
            wordTyped += "q";
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            wordTyped += "r";
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            wordTyped += "s";
        } else if (e.getKeyCode() == KeyEvent.VK_T) {
            wordTyped += "t";
        } else if (e.getKeyCode() == KeyEvent.VK_U) {
            wordTyped += "u";
        } else if (e.getKeyCode() == KeyEvent.VK_V) {
            wordTyped += "v";
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            wordTyped += "w";
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            wordTyped += "x";
        } else if (e.getKeyCode() == KeyEvent.VK_Y) {
            wordTyped += "y";
        } else if (e.getKeyCode() == KeyEvent.VK_Z) {
            wordTyped += "z";
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
