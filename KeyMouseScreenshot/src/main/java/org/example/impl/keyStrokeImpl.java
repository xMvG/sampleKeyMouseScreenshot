package org.example.impl;

import org.example.Utility.keyMouseStroke;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyStrokeImpl implements KeyListener {
    private int keyCount = 0;
    private JLabel keyStrokeLbl;

    private keyMouseStroke keymouseStroke;

    public keyStrokeImpl(keyMouseStroke keymouseStroke){
        this.keymouseStroke = keymouseStroke;
        this.keyStrokeLbl = keymouseStroke.getMouseStrokelbl();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            keyCount++;
            keymouseStroke.getKeyStrokelbl().setText("MouseStroke: " + keyCount);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
