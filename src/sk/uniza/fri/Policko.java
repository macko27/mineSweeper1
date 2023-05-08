package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 14/08/2022 - 18:58
 *
 * @author macik
 */
public class Policko extends JButton implements MouseListener {

    private int pocetMin;
    private boolean maVlajku;
    private boolean maMInu;
    private boolean jeOdhalene;
    private Mriezka mriezka;
    private Hra hra;

    public Policko(boolean maVlajku, boolean maMInu, Mriezka mriezka, Hra hra) {
        this.pocetMin = 0;
        this.maVlajku = maVlajku;
        this.maMInu = maMInu;
        this.mriezka = mriezka;
        this.hra = hra;

        this.setBounds(0, 0, 100, 100);
        this.addMouseListener(this);
        this.requestFocus();
        this.setVisible(true);
    }

    public void setPocetMin(int pocetMin) {
        this.pocetMin = pocetMin;
    }

    public int getPocetMin() {
        return this.pocetMin;
    }

    public boolean getMaVlajku() {
        return this.maVlajku;
    }

    public void setMaVlajku(boolean maVlajku) {
        this.maVlajku = maVlajku;
    }

    public boolean getMaMInu() {
        return this.maMInu;
    }

    public void setJeOdhalene(boolean jeOdhalene) {
        this.jeOdhalene = jeOdhalene;
    }

    public void setMaMInu(boolean maMInu) {
        this.maMInu = maMInu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (!this.maVlajku) {
                if (this.maMInu) {
                    this.setText("M");
                    this.setJeOdhalene(true);
                    int volba = JOptionPane.showConfirmDialog(null, "Prehral si. Chces hrat znovu?", "Prehra", JOptionPane.YES_NO_OPTION);
                    if (volba == 0) {
                        this.mriezka.reset();
                    } else {
                        System.exit(0);
                    }
                } else {
                    this.setText(this.pocetMin + "");
                    this.setJeOdhalene(true);
                }
            }
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            if (this.maVlajku) {
                this.hra.znizSkore();
                this.setMaVlajku(false);
                this.setText("");
            } else {
                this.hra.zvysSkore();
                this.setMaVlajku(true);
                this.setText("F");
            }
            if (this.mriezka.skontrolujVyhru()) {
                int volba = JOptionPane.showConfirmDialog(null, "Vyhral si. Chces hrat znovu?", "Vyhra", JOptionPane.YES_NO_OPTION);
                if (volba == 0) {
                    this.mriezka.reset();
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
