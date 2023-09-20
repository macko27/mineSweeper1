package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;

/**
 * 14/08/2022 - 18:58
 *
 * @author macik
 */
public class Game extends JFrame {

    private Grid grid;
    private ScoreBar scoreBar;
    private int score;
    public Game() {
        this.score = 0;
        this.grid = new Grid(this);
        this.scoreBar = new ScoreBar(this.grid);

        this.setMinimumSize(new Dimension(450, 450));
        this.setLocationRelativeTo(null);
        this.setTitle("Minesweeper");
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        this.add(this.grid, BorderLayout.CENTER);
        this.add(this.scoreBar, BorderLayout.NORTH);

        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void lowerScore() {
        this.score--;
        this.scoreBar.setScore(this.score);
    }

    public void increaseScore() {
        this.score++;
        this.scoreBar.setScore(this.score);
    }

    public void setScore(int number) {
        this.scoreBar.setScore(number);
    }

    public int getScore() {
        return this.score;
    }

    //Total number of all mines in game in game bar
    public void setNumberOfMines() {
        this.scoreBar.setNumberOfMines(this.grid.getNumberOfmines());
    }

    public void resetScore() {
        this.score = 0;
    }
}
