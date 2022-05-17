import javax.swing.*;

class JFrame
{
    private static void initWindow() {
        // create a window frame and set the title in the toolbar
        javax.swing.JFrame window = new javax.swing.JFrame("Word Invader");
        // when we close the window, stop the app
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        // create the jpanel to draw on.
        // this also initializes the game loop

        Level level1 = new Level(); //need to make our own "Board"

        // add the jpanel to the window
        window.add(level1);
        // pass keyboard inputs to the jpanel
        window.addKeyListener(level1);

        // don't allow the user to resize the window
        window.setResizable(false);
        // fit the window size around the components (just our jpanel).
        // pack() should be called after setResizable() to avoid issues on some platforms
        window.pack();
        // open window in the center of the screen
        window.setLocationRelativeTo(null);
        // display the window
        window.setVisible(true);
    }
    public static void main(String[] args) {
        // invokeLater() is used here to prevent our graphics processing from
        // blocking the GUI. https://stackoverflow.com/a/22534931/4655368
        // this is a lot of boilerplate code that you shouldn't be too concerned about.
        // just know that when main runs it will call initWindow() once.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initWindow();
            }
        });
    }
}