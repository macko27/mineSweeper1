package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 14/08/2022 - 18:58
 *
 * @author macik
 */
public class Cell extends JButton implements MouseListener {

    private int numberOfMInes;
    private boolean hasFlag;
    private boolean hasMine;
    private boolean isShowed;
    private Grid grid;
    private Game game;

    public Cell(boolean hasFlag, boolean hasMine, Grid grid, Game game) {
        this.isShowed = false;
        this.numberOfMInes = 0;
        this.hasFlag = hasFlag;
        this.hasMine = hasMine;
        this.grid = grid;
        this.game = game;

        this.setBounds(0, 0, 100, 100);
        this.setBackground(Constants.BACKGROUND_COLOR);

        this.addMouseListener(this);
        this.requestFocus();
        this.setVisible(true);
    }

    public void setNumberOfMInes(int numberOfMInes) {
        this.numberOfMInes = numberOfMInes;
    }

    public int getNumberOfMInes() {
        return this.numberOfMInes;
    }

    public boolean getHasFlag() {
        return this.hasFlag;
    }

    public void setHasFlag(boolean hasFlag) {
        this.hasFlag = hasFlag;
    }

    public boolean getHasMine() {
        return this.hasMine;
    }

    public void setShowed(boolean showed) {
        this.isShowed = showed;
    }


    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (!this.hasFlag) {
                if (this.hasMine) {
                    this.setText("M");
                    this.isShowed = true;
                    int choice = JOptionPane.showConfirmDialog(null, "You lost! Do you want to play again?", "Lose", JOptionPane.YES_NO_OPTION);
                    if (choice == 0) {
                        this.grid.reset();
                    } else {
                        System.exit(0);
                    }
                } else {
                    this.setText(this.numberOfMInes + "");
                    this.isShowed = true;
                }
            }
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            if (this.hasFlag) {
                this.game.lowerScore();
                this.setHasFlag(false);
                this.setText("");
            } else {
                this.game.increaseScore();
                this.setHasFlag(true);
                this.setText("F");
            }
            if (this.grid.checkWin()) {
                int choice = JOptionPane.showConfirmDialog(null, "You won!. Do you want to play again?", "Win", JOptionPane.YES_NO_OPTION);
                if (choice == 0) {
                    this.grid.reset();
                } else {
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
