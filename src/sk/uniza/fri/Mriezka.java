package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * 14/08/2022 - 18:58
 *
 * @author macik
 */
public class Mriezka extends JPanel {

    private Policko[][] policka;
    private Random generator;
    private int pocetMin;
    private Hra hra;

    public Mriezka(Hra hra) {
        this.policka = new Policko[9][9];
        this.generator = new Random();
        this.pocetMin = 0;
        this.hra = hra;
        this.setLayout(new GridLayout(9, 9));

        this.setVisible(true);

        this.vygenerujMiny();
        this.pridajCisla();
        this.vypis();
    }

    private void vygenerujMiny() {
        this.generator = new Random();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int cislo = this.generator.nextInt(8);
                if (cislo == 7) {
                    this.policka[i][j] = new Policko(false, true, this, this.hra);
                    this.pocetMin++;
                } else {
                    this.policka[i][j] = new Policko(false, false, this, this.hra);
                }
                this.policka[i][j].setText("");
                this.add(this.policka[i][j]);
            }
        }
    }

    private void pridajCisla() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.policka[i][j].setPocetMin(this.spocitajPocetMin(i, j));
            }
        }
    }
    private int spocitajPocetMin(int x, int y) {
        int cislo = 0;
        if (x + 1 < 9 ) {
            if (this.policka[x + 1][y].getMaMInu()) {
                cislo = cislo + 1;
            }
        }
        if (x - 1 >= 0) {
            if (this.policka[x - 1][y].getMaMInu()) {
                cislo = cislo + 1;
            }
        }
        if (y + 1 < 9) {
            if (this.policka[x][y + 1].getMaMInu()) {
                cislo = cislo + 1;
            }
        }
        if (y - 1 >= 0) {
            if (this.policka[x][y - 1].getMaMInu()) {
                cislo = cislo + 1;
            }
        }
        if (x - 1 >= 0 && y - 1 >= 0) {
            if (this.policka[x - 1][y - 1].getMaMInu()) {
                cislo = cislo + 1;
            }
        }
        if (x + 1 < 9 && y + 1 < 9) {
            if (this.policka[x + 1][y + 1].getMaMInu()) {
                cislo = cislo + 1;
            }
        }
        if (x + 1 < 9 && y - 1 >= 0) {
            if (this.policka[x + 1][y - 1].getMaMInu()) {
                cislo = cislo + 1;
            }
        }
        if (x - 1 >= 0 && y + 1 < 9) {
            if (this.policka[x - 1][y + 1].getMaMInu()) {
                cislo = cislo + 1;
            }
        }
        return cislo;
    }

    public void vypis() {
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                if (this.policka[i][j].getMaMInu()) {
                    System.out.print("- ");
                } else {
                    System.out.print(this.policka[i][j].getPocetMin() + " ");
                }
            }
        }
        System.out.println();
    }

    public boolean skontrolujVyhru() {
        int pocetSpravneOzancenychPolicok = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.policka[i][j].getMaVlajku() && this.policka[i][j].getMaMInu()) {
                    pocetSpravneOzancenychPolicok++;
                }
            }
        }
        if (this.hra.getSkore() == this.pocetMin && this.hra.getSkore() == pocetSpravneOzancenychPolicok) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.pocetMin = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.policka[i][j].setPocetMin(0);
                if (this.policka[i][j].getMaMInu()) {
                    this.policka[i][j].setMaMInu(false);
                }
                this.policka[i][j].setMaVlajku(false);
                this.policka[i][j].setJeOdhalene(false);
                this.policka[i][j].setText("");

                int cislo = this.generator.nextInt(8);
                if (cislo == 7) {
                    this.policka[i][j].setMaMInu(true);
                    this.pocetMin++;
                }
                this.pridajCisla();
            }
        }
        this.hra.nastavSkore(0);
        this.hra.nastavPocetMin();
        this.hra.resetSkore();
        this.vypis();
    }

    public int getPocetMin() {
        return this.pocetMin;
    }
}
