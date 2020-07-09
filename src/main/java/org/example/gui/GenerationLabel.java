package org.example.gui;

import javax.swing.*;

public class GenerationLabel extends JLabel {

    public GenerationLabel() {
        this.setText("1");
        this.setName("GenerationLabel");
        this.setBounds(10, 80, 230, 30);
    }

    @Override
    public void setText(String text) {
        super.setText("Generation #" + text);
    }
}
