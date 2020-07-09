package org.example.gui;

import org.example.Generation;
import org.example.Universe;
import org.example.util.ArrayUtil;
import org.example.util.NameSpace;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameOfLife extends JFrame {

    private JLabel generation;
    private JLabel alive;
    private GridPanel grid;
    private JToggleButton pauseButton;
    private JButton resetButton;
    private JLabel sliderLabel;
    private JSlider slider;

    private Universe universe;
    private Random random;
    private ArrayUtil util;

    private boolean pause = false;
    private boolean reset = false;
    private int generationNumber = 1;

    public GameOfLife() {
        super("Game of Life");

        initiateWorld();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 550);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null);
        setVisible(true);
        updateGui();
    }

    private void initComponents() {
        Font font = new Font("Courier", Font.BOLD, 16);

        Icon pauseIcon = new ImageIcon(NameSpace.PAUSE);
        Icon resetIcon = new ImageIcon(NameSpace.RESET);

        pauseButton = new PauseButton(pauseIcon);
        resetButton = new ResetButton(resetIcon);
        slider = new Slider();
        sliderLabel = new SliderLabel();

        generation = new GenerationLabel();
        generation.setFont(font);

        alive = new AliveLabel();
        alive.setText(Integer.toString(universe.getAlive()));
        alive.setFont(font);

        grid = new GridPanel(universe);

        add(pauseButton);
        add(resetButton);
        add(sliderLabel);
        add(slider);
        add(generation);
        add(alive);
        add(grid);

        pauseButton.addActionListener(e -> {
            pause = !pause;
        });

        resetButton.addActionListener(e -> {
            reset = !reset;
        });

        slider.addChangeListener(e -> {
            sliderLabel.setText("Speed mode: " + slider.getValue());
        });
    }

    public void run() {

        while (true) {
            if (pause) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            nextGeneration();
            if (isReset()) {
                resetGame();
            }
        }
    }

    private void initiateWorld() {
        random = new Random(System.currentTimeMillis());
        util = new ArrayUtil(random);
        String[][] firstState = util.initiateArray();

        universe = new Universe();
        universe.setState(util.expandArray(firstState));
    }

    private boolean isReset() {
        if (reset) {
            reset = false;
            return true;
        } else {
            return false;
        }
    }

    private void resetGame() {
        generationNumber = 1;

        String[][] firstState = util.initiateArray();
        universe = new Universe();
        universe.setState(util.expandArray(firstState));

    }

    private void nextGeneration() {
        Generation gen = new Generation(universe, util);
        gen.start();
        updateGui();
        try {
            Thread.sleep(waitTime());
            gen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        generationNumber++;
    }

    private int waitTime() {
        return 5000 / slider.getValue();
    }

    private void updateGui() {
        this.getContentPane().removeAll();
        generation.setText(Integer.toString(generationNumber));
        alive.setText(Integer.toString(universe.getAlive()));
        add(pauseButton);
        add(resetButton);
        add(sliderLabel);
        add(slider);
        add(generation);
        add(alive);
        add(new GridPanel(universe));
        this.repaint();
        this.setVisible(true);
    }
}
