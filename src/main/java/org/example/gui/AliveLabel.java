package org.example.gui;

import javax.swing.*;

public class AliveLabel extends JLabel {

    public AliveLabel() {
        this.setText("-1");
        this.setName("AliveLabel");
        this.setBounds(10, 120, 230, 30);
    }

    @Override
    public void setText(String text) {
        super.setText("Alive: " + text);
    }
}
