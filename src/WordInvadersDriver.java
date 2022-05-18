import javax.swing.*;

public class WordInvadersDriver {

    private JFrame window;
    private UserScreen screen;

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;

    public WordInvadersDriver() {
        window = new JFrame("Word Invaders");
        screen = new UserScreen();
    }

    public void run() {
        window.add(screen);
        window.addKeyListener(screen);

        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        WordInvadersDriver driver = new WordInvadersDriver();
        driver.run();
    }
}
