package org.example.gui;

import javax.swing.*;

public class Slider extends JSlider {

    public Slider() {
        this.setBounds(10, 200, 200, 30);
        this.setMinimum(1);
        this.setMaximum(10);
        this.setValue(5);
    }
}
