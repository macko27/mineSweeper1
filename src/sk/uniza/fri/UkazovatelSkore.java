package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;

/**
 * 14/08/2022 - 18:58
 *
 * @author macik
 */
public class UkazovatelSkore extends JPanel {
    private JLabel ukazovatelPoctuMin;
    private JLabel ukazovatelSkore;

    public UkazovatelSkore(Mriezka mriezka) {
        this.ukazovatelPoctuMin = new JLabel("" + mriezka.getPocetMin());
        this.ukazovatelSkore = new JLabel("" + 0);
        this.setLayout(new BorderLayout());

        this.ukazovatelPoctuMin.setForeground(Color.magenta);
        this.ukazovatelPoctuMin.setFont(new Font("Arial", Font.BOLD, 30));
        this.ukazovatelPoctuMin.setVisible(true);
        this.add(this.ukazovatelPoctuMin, BorderLayout.WEST);

        this.ukazovatelSkore.setText("" + 0);
        this.ukazovatelSkore.setForeground(Color.magenta);
        this.ukazovatelSkore.setFont(new Font("Arial", Font.BOLD, 30));
        this.ukazovatelSkore.setVisible(true);
        this.add(this.ukazovatelSkore, BorderLayout.EAST);

        this.setBackground(Color.BLUE);
        this.setVisible(true);
    }

    public void setUkazovatelSkore(int cislo) {
        this.ukazovatelSkore.setText("" + cislo);
    }

    public void setUkazovatelPoctuMin(int cislo) {
        this.ukazovatelPoctuMin.setText("" + cislo);
    }
}
