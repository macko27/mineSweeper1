package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 14/08/2022 - 18:58
 *
 * @author macik
 */
public class Grid extends JPanel {

    public static final int SIZE = 9;
    public static final int[][] DIRECTIONS = { {-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    private Cell[][] cells;
    private Random random;
    private int numberOfmines;
    private Game game;

    public Grid(Game game) {
        this.cells = new Cell[SIZE][SIZE];
        this.random = new Random();
        this.numberOfmines = 0;
        this.game = game;
        this.setLayout(new GridLayout(SIZE, SIZE));

        this.setVisible(true);

        this.generateMines();
        this.addNumbers();
    }

    private void generateMines() {
        this.random = new Random();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int cislo = this.random.nextInt(8);
                if (cislo == 7) {
                    this.cells[i][j] = new Cell(false, true, this, this.game);
                    this.numberOfmines++;
                } else {
                    this.cells[i][j] = new Cell(false, false, this, this.game);
                }
                this.cells[i][j].setText("");
                this.add(this.cells[i][j]);
            }
        }
    }

    //for each cell it adds the number of mines that are located around the cell
    private void addNumbers() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.cells[i][j].setNumberOfMInes(this.calculateNumberOfMines(i, j));
            }
        }
    }
    private int calculateNumberOfMines(int x, int y) {
        int number = 0;
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE) {
                if (this.cells[newX][newY].getHasMine()) {
                    number++;
                }
            }
        }
        return number;
    }

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println();
            for (int j = 0; j < SIZE; j++) {
                if (this.cells[i][j].getHasMine()) {
                    System.out.print("- ");
                } else {
                    System.out.print(this.cells[i][j].getNumberOfMInes() + " ");
                }
            }
        }
        System.out.println();
    }

    public boolean checkWin() {
        int rightFlagedCells = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.cells[i][j].getHasFlag() && this.cells[i][j].getHasMine()) {
                    rightFlagedCells++;
                }
            }
        }
        if (this.game.getScore() == this.numberOfmines && this.game.getScore() == rightFlagedCells) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.numberOfmines = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.cells[i][j].setNumberOfMInes(0);
                if (this.cells[i][j].getHasMine()) {
                    this.cells[i][j].setHasMine(false);
                }
                this.cells[i][j].setHasFlag(false);
                this.cells[i][j].setShowed(false);
                this.cells[i][j].setText("");

                int cislo = this.random.nextInt(8);
                if (cislo == 7) {
                    this.cells[i][j].setHasMine(true);
                    this.numberOfmines++;
                }
                this.addNumbers();
            }
        }
        this.game.setScore(0);
        this.game.setNumberOfMines();
        this.game.resetScore();
    }

    public int getNumberOfmines() {
        return this.numberOfmines;
    }
}
