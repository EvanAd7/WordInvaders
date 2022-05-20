import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class GameManager implements ActionListener {

    //instance variables
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<Laser> lasers;
    private ArrayList<PowerUp> powerups;

    private int points = 0;

    //constructor
    public GameManager(Player player) {
        this.player = player;
        enemies = new ArrayList<Enemy>();
        lasers = new ArrayList<Laser>();
        powerups = new ArrayList<PowerUp>();
    }

    //adds an enemy to the array list, priming it to be spawned
    public void spawnEnemy() {
        enemies.add(new Enemy((int) (Math.random() * (WordInvadersDriver.WIDTH - 70)), 0, 90, 90));
    }

    //adds a new laser to the array list
    public void shootLaser() {
        lasers.add(new Laser(player.getX() + 40, 860, 8, 40));
    }

    public void spawnPowerUp() {
        powerups.add(new PowerUp((int) (Math.random() * (WordInvadersDriver.WIDTH - 70)), 0, 90, 90));
    }

    //draw game objects onto the screen
    public void drawObjects(Graphics g) {
        player.draw(g);
        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }
        for (Laser laser : lasers) {
            laser.draw(g);
        }
        for (PowerUp powerup : powerups) {
            powerup.draw(g);
        }
    }

    //update all objects each frame
    public void updateObjects() {
        for (Enemy enemy : enemies) {
            enemy.updateEnemy();
        }
        for (Laser laser : lasers) {
            laser.updateLaser();
        }
        for (PowerUp powerup : powerups) {
            powerup.updatePowerUp();
        }

        checkCollisions();
        deleteInactive();
    }

    //checks which objects have been collided with
    public void checkCollisions() {
        for (Enemy enemy : enemies) {
            for (Laser laser : lasers) {
                if (enemy.getCollisionBox().intersects(laser.getCollisionBox())) {
                    enemy.setActive(false);
                    laser.setActive(false);
                    points += 100;
                }
            }
        }
        for (PowerUp powerup : powerups) {
            for (Laser laser : lasers) {
                if (powerup.getCollisionBox().intersects(laser.getCollisionBox())) {
                    powerup.setActive(false);
                    laser.setActive(false);
                    points += 500;
                }
            }
        }
    }

    //deletes inactive objects every frame
    public void deleteInactive() {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (!(enemies.get(i).isActive())) {
                enemies.remove(i);
            }
        }

        for (int i = lasers.size() - 1; i >= 0; i--) {
            if (!(lasers.get(i).isActive())) {
                lasers.remove(i);
            }
        }

        for (int i = powerups.size() - 1; i >= 0; i--) {
            if (!(powerups.get(i).isActive())) {
                powerups.remove(i);
            }
        }
    }

    //spawn enemies at a certain rate (rate decided in UserScreen)
    @Override
    public void actionPerformed(ActionEvent e) {
        spawnEnemy();
    }

    //getters
    public String getPoints() {
        return "" + points;
    }
}
