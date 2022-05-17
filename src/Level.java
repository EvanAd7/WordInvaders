import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Level extends JPanel implements ActionListener, KeyListener {
    {
        int levelNum;
        int time;
        int points;
        boolean cleared;
        Player player;
        ArrayList<Enemy> enemies;
        ArrayList<PowerUp> powerUps;
    }
}
