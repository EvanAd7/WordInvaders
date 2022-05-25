import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class UserScreen extends JPanel implements ActionListener, KeyListener {

    //image loading variables
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;

    //instance variables
    private Player player;
    private WordReader wordReader;
    private Timer drawFrame;
    private Timer spawner;
    private Status status = Status.MENU;
    private Status tempStatus;
    private int tempScore;
    private int highScore = 0;

    //game managers
    private Level1Manager level1Manager;
    private Level2Manager level2Manager;
    private Level3Manager level3Manager;
    private Level4Manager level4Manager;

    //constructor
    public UserScreen() {
        player = new Player(500, 860, 90, 90);

        level1Manager = new Level1Manager(player);
        level2Manager = new Level2Manager(player);
        level3Manager = new Level3Manager(player);
        level4Manager = new Level4Manager(player);

        //timer that runs the "frame rate"
        drawFrame = new Timer(1000 / 90, this);
        drawFrame.start();

        if (needImage) {
            loadImage("ImagesAndText/space.jpg");
        }
    }

    //draws the menu screen
    public void drawMenuScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WordInvadersDriver.WIDTH, WordInvadersDriver.HEIGHT);

        g.setFont(new Font("Arial", Font.PLAIN, 30));

        g.setColor(Color.WHITE);
        g.drawString("WORD INVADERS", 350, 150);
        g.drawString("Press key: 1, 2, 3, 4 for respective levels", 200, 250);
        g.drawString("Level 1: Easy", 350, 400);
        g.drawString("Level 2: Medium", 350, 450);
        g.drawString("Level 3: Hard", 350, 500);
        g.drawString("Level 4: IMPOSSIBLE", 350, 550);
        g.drawString("High Score: " + highScore, 370, 650);
        g.drawString("Press SPACE for instructions", 280, 800);
    }

    //draws the instructions screen
    public void drawInstructionsScreen(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WordInvadersDriver.WIDTH, WordInvadersDriver.HEIGHT);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("How to play WORD INVADERS:", 250, 100);

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Word Invaders is an outer-space themed game designed to improve your typing skills. ", 100, 200);
        g.drawString("The objective of the game is to obtain as many points as you can on each level, ", 100, 230);
        g.drawString("while simultaneously becoming a better typist. Use left and right arrow keys ", 100, 260);
        g.drawString("to position your spaceship beneath an enemy spacecraft, and correctly type in ", 100, 290);
        g.drawString("the word at the top of your screen, then press enter to fire a laser. If the ", 100, 320);
        g.drawString("laser collides with an enemy, you gain points and the enemy is destroyed. If ", 100, 350);
        g.drawString("the word is incorrectly typed, you will lose a life and a laser-beam will not fire. ", 100, 380);
        g.drawString("Additionally, if an enemy is allowed to reach the bottom of your screen, you ", 100, 410);
        g.drawString("will lose a life. Lose all of your lives, and it's game over! Each level is ", 100, 440);
        g.drawString("a certain difficulty; in harder levels the enemies spawn faster and the words ", 100, 470);
        g.drawString("that you must type are longer. Each level also has it's own power-ups, which ", 100, 500);
        g.drawString("provide boosts such as temporary invincibility. Good luck and happy typing!", 100, 530);

        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Press SPACE to return to menu", 250, 700);
    }

    //draws the game-over screen
    public void drawEndScreen(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, WordInvadersDriver.WIDTH, WordInvadersDriver.HEIGHT);

        g.setFont(new Font("Arial", Font.PLAIN, 50));

        g.setColor(Color.BLACK);
        g.drawString("GAME OVER!", 320, 200);
        g.drawString("Press SPACE to return to menu", 150, 600);

        switch (tempStatus) {
            case LEVEL1:
                g.drawString("You scored " + level1Manager.getPoints() + " points", 250, 400);
                tempScore = level1Manager.getPoints();
                break;
            case LEVEL2:
                g.drawString("You scored " + level2Manager.getPoints() + " points", 250, 400);
                tempScore = level2Manager.getPoints();
                break;
            case LEVEL3:
                g.drawString("You scored " + level3Manager.getPoints() + " points", 250, 400);
                tempScore = level3Manager.getPoints();
                break;
            case LEVEL4:
                g.drawString("You scored " + level4Manager.getPoints() + " points", 250, 400);
                tempScore = level4Manager.getPoints();
                break;
        }

        if (tempScore > highScore) {
            highScore = tempScore;
        }
    }

    //paint the screen (JPanel) with active objects
    @Override
    public void paintComponent(Graphics g) {
        switch (status) {
            case MENU:
                drawMenuScreen(g);
                break;
            case INSTRUCTIONS:
                drawInstructionsScreen(g);
                break;
            case LEVEL1:
                drawLevel1Screen(g);
                break;
            case LEVEL2:
                drawLevel2Screen(g);
                break;
            case LEVEL3:
                drawLevel3Screen(g);
                break;
            case LEVEL4:
                drawLevel4Screen(g);
                break;
            case END:
                drawEndScreen(g);
                break;
        }
    }

    //draw text for the level at the top of the screen
    public void drawText(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 30));

        g.setColor(Color.GREEN);
        switch (status) {
            case LEVEL1:
                g.drawString("Score: " + level1Manager.getPoints(), 10, 30);
                break;
            case LEVEL2:
                g.drawString("Score: " + level2Manager.getPoints(), 10, 30);
                break;
            case LEVEL3:
                g.drawString("Score: " + level3Manager.getPoints(), 10, 30);
                break;
            case LEVEL4:
                g.drawString("Score: " + level4Manager.getPoints(), 10, 30);
                break;
        }
        g.drawString("Type: " + wordReader.getCurrentWord(), 415, 30);
        g.drawString("Lives: " + player.getLives(), 870, 30);

        g.setColor(Color.WHITE);
        g.drawString(wordReader.getWordTyped(), 440, 70);
    }

    //draws the level 1 screen
    public void drawLevel1Screen(Graphics g) {
        g.drawImage(image, 0, 0, null);
        level1Manager.drawObjects(g);
        drawText(g);
    }

    //updates level 1 objects at a certain rate
    public void updateLevel1Screen() {
        player.updatePlayer();
        level1Manager.updateObjects();

        if (!(player.isActive())) {
            status = Status.END;
            spawner.stop();
        }
    }

    //draws the level 2 screen
    public void drawLevel2Screen(Graphics g) {
        g.drawImage(image, 0, 0, null);
        level2Manager.drawObjects(g);
        drawText(g);
    }

    //updates level 2 objects at a certain rate
    public void updateLevel2Screen() {
        player.updatePlayer();
        level2Manager.updateObjects();

        if (!(player.isActive())) {
            status = Status.END;
            spawner.stop();
        }
    }

    //draws the level 3 screen
    public void drawLevel3Screen(Graphics g) {
        g.drawImage(image, 0, 0, null);
        level3Manager.drawObjects(g);
        drawText(g);
    }

    //updates level 3 objects at a certain rate
    public void updateLevel3Screen() {
        player.updatePlayer();
        level3Manager.updateObjects();

        if (!(player.isActive())) {
            status = Status.END;
            spawner.stop();
        }
    }

    //draws the level 4 screen
    public void drawLevel4Screen(Graphics g) {
        g.drawImage(image, 0, 0, null);
        level4Manager.drawObjects(g);
        drawText(g);
    }

    //updates level 4 objects at a certain rate
    public void updateLevel4Screen() {
        player.updatePlayer();
        level4Manager.updateObjects();

        if (!(player.isActive())) {
            status = Status.END;
            spawner.stop();
        }
    }

    //key and action listener methods:
    //action performed method runs at a certain frame rate
    @Override
    public void actionPerformed(ActionEvent e) {
        //update all objects then repaint the screen
        switch (status) {
            case LEVEL1:
                updateLevel1Screen();
                break;
            case LEVEL2:
                updateLevel2Screen();
                break;
            case LEVEL3:
                updateLevel3Screen();
                break;
            case LEVEL4:
                updateLevel4Screen();
                break;
        }
        repaint();
    }

    //reads when a key is typed by the user
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //reads when the user presses a key and translates into code
    @Override
    public void keyPressed(KeyEvent e) {
        if (status == Status.LEVEL1 || status == Status.LEVEL2 || status == Status.LEVEL3 || status == Status.LEVEL4) {
            //player movement controllers
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                player.moveLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player.moveRight();
            }

            //check what the user is typing
            if (e.getKeyCode() == KeyEvent.VK_A) {
                wordReader.addLetter("a");
            } else if (e.getKeyCode() == KeyEvent.VK_B) {
                wordReader.addLetter("b");
            } else if (e.getKeyCode() == KeyEvent.VK_C) {
                wordReader.addLetter("c");
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                wordReader.addLetter("d");
            } else if (e.getKeyCode() == KeyEvent.VK_E) {
                wordReader.addLetter("e");
            } else if (e.getKeyCode() == KeyEvent.VK_F) {
                wordReader.addLetter("f");
            } else if (e.getKeyCode() == KeyEvent.VK_G) {
                wordReader.addLetter("g");
            } else if (e.getKeyCode() == KeyEvent.VK_H) {
                wordReader.addLetter("h");
            } else if (e.getKeyCode() == KeyEvent.VK_I) {
                wordReader.addLetter("i");
            } else if (e.getKeyCode() == KeyEvent.VK_J) {
                wordReader.addLetter("j");
            } else if (e.getKeyCode() == KeyEvent.VK_K) {
                wordReader.addLetter("k");
            } else if (e.getKeyCode() == KeyEvent.VK_L) {
                wordReader.addLetter("l");
            } else if (e.getKeyCode() == KeyEvent.VK_M) {
                wordReader.addLetter("m");
            } else if (e.getKeyCode() == KeyEvent.VK_N) {
                wordReader.addLetter("n");
            } else if (e.getKeyCode() == KeyEvent.VK_O) {
                wordReader.addLetter("o");
            } else if (e.getKeyCode() == KeyEvent.VK_P) {
                wordReader.addLetter("p");
            } else if (e.getKeyCode() == KeyEvent.VK_Q) {
                wordReader.addLetter("q");
            } else if (e.getKeyCode() == KeyEvent.VK_R) {
                wordReader.addLetter("r");
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                wordReader.addLetter("s");
            } else if (e.getKeyCode() == KeyEvent.VK_T) {
                wordReader.addLetter("t");
            } else if (e.getKeyCode() == KeyEvent.VK_U) {
                wordReader.addLetter("u");
            } else if (e.getKeyCode() == KeyEvent.VK_V) {
                wordReader.addLetter("v");
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                wordReader.addLetter("w");
            } else if (e.getKeyCode() == KeyEvent.VK_X) {
                wordReader.addLetter("x");
            } else if (e.getKeyCode() == KeyEvent.VK_Y) {
                wordReader.addLetter("y");
            } else if (e.getKeyCode() == KeyEvent.VK_Z) {
                wordReader.addLetter("z");
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                wordReader.backspace();
            }
        }

        //check what game state we are in
        switch (status) {
            case MENU:
                if (e.getKeyCode() == KeyEvent.VK_1) {
                    status = Status.LEVEL1;
                    tempStatus = Status.LEVEL1;
                    wordReader = new WordReader(4);
                    spawner = new Timer(4000, level1Manager);
                    spawner.start();
                } else if (e.getKeyCode() == KeyEvent.VK_2) {
                    status = Status.LEVEL2;
                    tempStatus = Status.LEVEL2;
                    wordReader = new WordReader(5);
                    spawner = new Timer(3000, level2Manager);
                    spawner.start();
                } else if (e.getKeyCode() == KeyEvent.VK_3) {
                    status = Status.LEVEL3;
                    tempStatus = Status.LEVEL3;
                    wordReader = new WordReader(6);
                    spawner = new Timer(2000, level3Manager);
                    spawner.start();
                } else if (e.getKeyCode() == KeyEvent.VK_4) {
                    status = Status.LEVEL4;
                    tempStatus = Status.LEVEL4;
                    wordReader = new WordReader(6);
                    spawner = new Timer(1000, level4Manager);
                    spawner.start();
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    status = Status.INSTRUCTIONS;
                }
                break;
            case INSTRUCTIONS:
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    status = Status.MENU;
                }
                break;
            case LEVEL1:
                //if the user has typed the correct word, fire laser
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (wordReader.getWordTyped().equals(wordReader.getCurrentWord())) {
                        level1Manager.shootLaser();
                    } else {
                        player.setLives(player.getLives() - 1);
                    }
                    wordReader.setWordTyped("");
                    wordReader.newWord();
                }
                break;
            case LEVEL2:
                //if the user has typed the correct word, fire laser
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (wordReader.getWordTyped().equals(wordReader.getCurrentWord())) {
                        level2Manager.shootLaser();
                    } else {
                        player.setLives(player.getLives() - 1);
                    }
                    wordReader.setWordTyped("");
                    wordReader.newWord();
                }
                break;
            case LEVEL3:
                //if the user has typed the correct word, fire laser
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (wordReader.getWordTyped().equals(wordReader.getCurrentWord())) {
                        level3Manager.shootLaser();
                    } else {
                        player.setLives(player.getLives() - 1);
                    }
                    wordReader.setWordTyped("");
                    wordReader.newWord();
                }
                break;
            case LEVEL4:
                //if the user has typed the correct word, fire laser
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (wordReader.getWordTyped().equals(wordReader.getCurrentWord())) {
                        if (level4Manager.hasPowerUp()) {
                            level4Manager.shoot3Lasers();
                        } else {
                            level4Manager.shootLaser();
                        }
                    } else {
                        player.setLives(player.getLives() - 1);
                    }
                    wordReader.setWordTyped("");
                    wordReader.newWord();
                }
                break;
            case END:
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    status = Status.MENU;
                    player.setActive(true);
                    level1Manager.reset();
                    level2Manager.reset();
                    level3Manager.reset();
                    level4Manager.reset();
                }
                break;
        }
    }

    //stops movement upon release of a key
    @Override
    public void keyReleased(KeyEvent e) {
        player.setSpeedX(0);
    }

    //image loading method
    private void loadImage(String imageFile) {
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
