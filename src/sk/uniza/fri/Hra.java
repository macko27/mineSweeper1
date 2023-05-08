package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;

/**
 * 14/08/2022 - 18:58
 *
 * @author macik
 */
public class Hra extends JFrame {

    private Mriezka mriezka;
    private UkazovatelSkore ukazovatelSkore;
    private int skore;
    public Hra() {
        this.skore = 0;
        this.mriezka = new Mriezka(this);
        this.ukazovatelSkore = new UkazovatelSkore(this.mriezka);

        this.setMinimumSize(new Dimension(450, 450));
        this.setLocationRelativeTo(null);
        this.setTitle("Minesweeper");
        this.setLayout(new BorderLayout());

        this.add(this.mriezka, BorderLayout.CENTER);
        this.add(this.ukazovatelSkore, BorderLayout.NORTH);

        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void znizSkore() {
        this.skore--;
        this.ukazovatelSkore.setUkazovatelSkore(this.skore);
    }

    public void zvysSkore() {
        this.skore++;
        this.ukazovatelSkore.setUkazovatelSkore(this.skore);
    }

    public void nastavSkore(int cislo) {
        this.ukazovatelSkore.setUkazovatelSkore(cislo);
    }

    public int getSkore() {
        return this.skore;
    }

    public void nastavPocetMin() {
        this.ukazovatelSkore.setUkazovatelPoctuMin(this.mriezka.getPocetMin());
    }

    public void resetSkore() {
        this.skore = 0;
    }
}
