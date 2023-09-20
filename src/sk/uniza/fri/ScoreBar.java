package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;

/**
 * 14/08/2022 - 18:58
 *
 * @author macik
 */
public class ScoreBar extends JPanel {
    private JLabel numberOfMines;
    private JLabel score;

    public ScoreBar(Grid grid) {
        this.numberOfMines = new JLabel("" + grid.getNumberOfmines());
        this.score = new JLabel("" + 0);
        this.setLayout(new BorderLayout());

        this.numberOfMines.setForeground(Constants.TEXT_COLOR);
        this.numberOfMines.setFont(new Font("Arial", Font.BOLD, 30));
        this.numberOfMines.setVisible(true);
        this.add(this.numberOfMines, BorderLayout.WEST);

        this.score.setText("" + 0);
        this.score.setForeground(Constants.TEXT_COLOR);
        this.score.setFont(new Font("Arial", Font.BOLD, 30));
        this.score.setVisible(true);
        this.add(this.score, BorderLayout.EAST);

        this.setBackground(Constants.BACKGROUND_COLOR);
        this.setVisible(true);
    }

    public void setScore(int number) {
        this.score.setText("" + number);
    }

    public void setNumberOfMines(int number) {
        this.numberOfMines.setText("" + number);
    }
}
