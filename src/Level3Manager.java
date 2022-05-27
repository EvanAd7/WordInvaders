import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Level3Manager implements ActionListener {

    //instance variables
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<Laser> lasers;
    private ArrayList<PowerUp> powerUps;
    private boolean invincible;
    private int points = 0;
    private int counter = 0;
    private int powerUpReset = 0;

    //constructor
    public Level3Manager(Player player) {
        this.player = player;
        enemies = new ArrayList<Enemy>();
        lasers = new ArrayList<Laser>();
        powerUps = new ArrayList<PowerUp>();
        invincible = false;
    }

    //adds an enemy to the array list, priming it to be spawned
    public void spawnEnemy() {
        enemies.add(new Enemy((int) (Math.random() * (WordInvadersDriver.WIDTH - 70)), 0, 90, 90, 3));
    }

    //adds a new laser to the array list
    public void shootLaser() {
        lasers.add(new Laser(player.getX() + 40, 860, 8, 40));
    }

    //adds a power-up to the array list, priming it to be spawned in
    public void spawnPowerUp() {
        powerUps.add(new PowerUp((int) (Math.random() * (WordInvadersDriver.WIDTH - 70)), 0, 90, 90, 3));
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
        for (PowerUp powerup : powerUps) {
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
        for (PowerUp powerup : powerUps) {
            powerup.updatePowerUp();
        }

        checkCollisions();
        lifeLoss();
        deleteInactive();
    }

    //checks which objects have been collided with
    public void checkCollisions() {
        for (Enemy enemy : enemies) {
            for (Laser laser : lasers) {
                if (enemy.getCollisionBox().intersects(laser.getCollisionBox())) {
                    enemy.setActive(false);
                    laser.setActive(false);
                    points += 300;
                }
            }
        }

        for (PowerUp powerup : powerUps) {
            for (Laser laser : lasers) {
                if (powerup.getCollisionBox().intersects(laser.getCollisionBox())) {
                    powerup.setActive(false);
                    laser.setActive(false);
                    invincible = true;
                }
            }
        }
    }

    //checks if the player has lost a life or lost the game
    public void lifeLoss() {
        for (Enemy enemy : enemies) {
            if (enemy.getY() > player.getY()) {
                enemy.setActive(false);
                if (!invincible) {
                    player.setLives(player.getLives() - 1);
                }
            }
        }
        if (player.getLives() <= 0) {
            player.setActive(false);
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

        for (int i = powerUps.size() - 1; i >= 0; i--) {
            if (!(powerUps.get(i).isActive())) {
                powerUps.remove(i);
            }
        }
    }

    //reset the game
    public void reset() {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            enemies.remove(i);
        }

        for (int i = lasers.size() - 1; i >= 0; i--) {
            lasers.remove(i);
        }

        for (int i = powerUps.size() - 1; i >= 0; i--) {
            powerUps.remove(i);
        }

        points = 0;
        player.setLives(3);
        invincible = false;
    }

    //spawn objects at a certain rate (rate decided in UserScreen)
    @Override
    public void actionPerformed(ActionEvent e) {
        spawnEnemy();
        counter++;
        if (counter % 10 == 0) {
            spawnPowerUp();
        }
        if (invincible) {
            powerUpReset++;
        }
        if ((powerUpReset % 5 == 0) && powerUpReset != 0) {
            invincible = false;
        }
    }

    //getters
    public int getPoints() {
        return points;
    }
}
