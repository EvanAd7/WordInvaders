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
    private GameManager gameManager;
    private WordReader wordReader;
    private Timer drawFrame;
    private Timer spawner;
    private Status status = Status.MENU;

    //constructor
    public UserScreen() {
        player = new Player(500, 860, 90, 90);
        gameManager = new GameManager(player);
        wordReader = new WordReader();

        //timer that runs the "frame rate"
        drawFrame = new Timer(1000 / 90, this);
        drawFrame.start();

        if (needImage) {
            loadImage("ImagesAndText/space.jpg");
        }
    }

    //paint the screen (JPanel) with active objects
    @Override
    public void paintComponent(Graphics g) {
        switch (status) {
            case MENU:
                drawMenuScreen(g);
                break;
            case LEVEL1:
                drawLevelScreen(g);
                break;
            case END:
                drawEndScreen(g);
                break;
        }
    }

    //draws the level screen
    public void drawLevelScreen(Graphics g) {
        g.drawImage(image, 0, 0, null);
        gameManager.drawObjects(g);

        g.setFont(new Font("Arial", Font.PLAIN, 30));

        g.setColor(Color.GREEN);
        g.drawString("Score: " + gameManager.getPoints(), 10, 30);
        g.drawString("Type: " + wordReader.getCurrentWord(), 415, 30);
        g.drawString("Lives: " + player.getLives(), 870, 30);

        g.setColor(Color.WHITE);
        g.drawString(wordReader.getWordTyped(), 440, 70);
    }

    //updates current level's objects at a certain rate
    public void updateLevelScreen() {
        player.updatePlayer();
        gameManager.updateObjects();

        if (!(player.isActive())) {
            status = Status.END;
            spawner.stop();
            gameManager.reset();
        }
    }

    //draws the menu screen
    public void drawMenuScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WordInvadersDriver.WIDTH, WordInvadersDriver.HEIGHT);

        g.setFont(new Font("Arial", Font.PLAIN, 30));

        g.setColor(Color.WHITE);
        g.drawString("WORD INVADERS", 400, 300);
        g.drawString("Press SPACE to begin!", 400, 500);
    }

    //draws the game-over screen
    public void drawEndScreen(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, WordInvadersDriver.WIDTH, WordInvadersDriver.HEIGHT);

        g.setFont(new Font("Arial", Font.PLAIN, 30));

        g.setColor(Color.BLACK);
        g.drawString("GAME OVER!", 400, 300);
        g.drawString("Press SPACE to return to menu!", 400, 500);
    }

    //key and action listener methods:
    //action performed method runs at a certain frame rate
    @Override
    public void actionPerformed(ActionEvent e) {
        //update all objects then repaint the screen
        updateLevelScreen();
        repaint();
    }

    //reads when a key is typed by the user
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //reads when the user presses a key and translates into code
    @Override
    public void keyPressed(KeyEvent e) {
        //check what game state we are in
        switch (status) {
            case MENU:
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    status = Status.LEVEL1;
                    spawner = new Timer(2000, gameManager);
                    spawner.start();
                }
                break;
            case LEVEL1:
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

                //if the user has typed the correct word, fire laser
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (wordReader.getWordTyped().equals(wordReader.getCurrentWord())) {
                        gameManager.shootLaser();
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
    void loadImage(String imageFile) {
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
