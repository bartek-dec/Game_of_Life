package org.example.gui;

import javax.swing.*;

public class PauseButton extends JToggleButton {

    public PauseButton(Icon icon) {
        super(icon);
        this.setName("PlayToggleButton");
        this.setBounds(10, 10, 65, 40);
    }
}
