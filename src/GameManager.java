import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class GameManager {
    //instance variables
    Player player;

    //constructor
    public GameManager(Player player) {
        this.player = player;
    }

    //draw the screen
    public void draw(Graphics g) {
        player.draw(g);
    }
}
