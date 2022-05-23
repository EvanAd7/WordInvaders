import javax.swing.*;

public class WordInvadersDriver {

    //instance variables
    private JFrame window;
    private UserScreen screen;

    //dimensions of the window
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;

    //construct the window (JFrame) and screen (JPanel)
    public WordInvadersDriver() {
        window = new JFrame("Word Invaders");
        screen = new UserScreen();
    }

    //add all necessary components to the window for running the game
    public void run() {
        window.add(screen);
        window.addKeyListener(screen);

        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    //MAIN METHOD
    public static void main(String[] args) {
        //instantiate driver and run the game
        WordInvadersDriver driver = new WordInvadersDriver();
        driver.run();
    }
}
