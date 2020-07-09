package org.example.gui;

import org.example.Universe;
import org.example.util.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GridPanel extends JPanel {

    private final int a = 5;
    private Universe universe;

    public GridPanel(Universe universe) {
        this.universe = universe;
        this.setBounds(240, 10, (100 * a) + 1, (100 * a) + 1);
        this.setLayout(new GridLayout(100, 100));
    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (Objects.equals(universe.getState()[i][j], Cell.ALIVE.getState())) {

                    graphics.setColor(Color.BLUE);
                    graphics.fillRect(a * i, a * j, a, a);
                } else {
                    graphics.setColor(Color.GRAY);
                    graphics.drawRect(a * i, a * j, a, a);
                }
            }
        }
    }
}
