package org.example.impl;

import org.example.Utility.keyMouseStroke;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseStrokeImpl implements MouseListener {
    private int mouseCount = 0;
    private JLabel mouseStrokeLbl;
    private keyMouseStroke keymouseStroke;

    public mouseStrokeImpl(keyMouseStroke keymouseStroke){
        this.keymouseStroke = keymouseStroke;
        this.mouseStrokeLbl = keymouseStroke.getMouseStrokelbl();
    }

        @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getID() == MouseEvent.MOUSE_PRESSED){
            mouseCount++;
            keymouseStroke.getMouseStrokelbl().setText("MouseStroke: " + mouseCount);

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
