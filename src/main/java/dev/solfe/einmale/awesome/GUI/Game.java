package dev.solfe.einmale.awesome.GUI;

import dev.solfe.einmale.awesome.Listeners.TypeListener;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game extends JFrame {

    private TypeListener typeListener;

    public JLabel challengeLabel;
    public JLabel timerLabel;
    public JLabel comboLabel;

    public boolean isGameStarted = false;
    private double currentSeconds = 0;
    public int combo = 0;
    private Random random;

    public Game() {
        this.setName("aWEsome");
        this.setMinimumSize(new Dimension(256, 256));
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        random = new Random();

        challengeLabel = new JLabel("Hello, Type 'e' to start.");
        challengeLabel.setHorizontalAlignment(JLabel.CENTER);
        challengeLabel.setSize(256, 256);

        timerLabel = new JLabel("105sec");
        timerLabel.setSize(64, 64);

        comboLabel = new JLabel("0");
        comboLabel.setSize(64, 64);

        JTextArea typer = new JTextArea();
        typer.setSize(128,128);
        typeListener = new TypeListener(this);
        typer.addKeyListener(typeListener);

        this.add(challengeLabel, BorderLayout.CENTER);
        this.add(timerLabel, BorderLayout.NORTH);
        this.add(comboLabel, BorderLayout.EAST);
        this.add(typer, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void startChallenge() {
        isGameStarted = true;

        nextChallenge();
    }

    public void nextChallenge() {
        // displays previous record.
        timerLabel.setText(((System.currentTimeMillis() - currentSeconds) / 1000) + " sec");

        // init variables
        currentSeconds = System.currentTimeMillis();

        // randomize challenge text.
        int length = random.nextInt(1, 20);
        String string = "";
        for (int i=1; i<=length; i++) {
            char startAt = (char) (random.nextBoolean() ? 97 : 65);
            char selected = (char) (startAt + random.nextInt(0, 25));
            string += selected;
        }

        challengeLabel.setText(string);
    }

}
