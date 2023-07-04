package dev.solfe.einmale.awesome.Listeners;

import dev.solfe.einmale.awesome.GUI.Game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TypeListener implements KeyListener {

    private Game game;
    private JLabel challengeLabel;

    public TypeListener(Game game) {
        this.game = game;
        this.challengeLabel = game.challengeLabel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'e' && !game.isGameStarted) {
            game.startChallenge();
            return;
        }

        char at = challengeLabel.getText().charAt(0);

        if (at == e.getKeyChar() || (at == 'I' && e.getKeyChar() == 'l')) {
            challengeLabel.setText(challengeLabel.getText().substring(1));
        } else {
            game.combo = 0;
            return;
        }

        game.combo++;

        if (challengeLabel.getText().length() == 0) {
            game.nextChallenge();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        JTextArea area = (JTextArea) e.getSource();
        area.setText("");

        game.comboLabel.setText(String.valueOf(game.combo));
    }
}
