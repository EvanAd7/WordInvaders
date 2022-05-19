import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class GameManager implements ActionListener {

    //instance variables
    private Player player;
    private ArrayList<Enemy> enemies;

    //constructor
    public GameManager(Player player) {
        this.player = player;
        enemies = new ArrayList<Enemy>();
    }

    //adds an enemy to the array list, priming it to be spawned
    public void spawnEnemy() {
        enemies.add(new Enemy((int) (Math.random() * (WordInvadersDriver.WIDTH-70)), 0, 90, 90));
    }

    //draw game objects onto the screen
    public void drawObjects(Graphics g) {
        player.draw(g);
        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }
    }

    //update all objects
    public void updateObjects() {
        for (Enemy enemy : enemies) {
            enemy.updateEnemy();
        }
    }

    //spawn enemies at a certain rate (rate decided in UserScreen)
    @Override
    public void actionPerformed(ActionEvent e) {
        spawnEnemy();
    }
}
