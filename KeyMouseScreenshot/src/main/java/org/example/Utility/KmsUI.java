package org.example.Utility;

import org.example.impl.keyStrokeImpl;
import org.example.impl.mouseStrokeImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class KmsUI {

    private JFrame frame = new JFrame("Key and Mouse Strokes") ;
    private JLabel keyStrokelbl;
    private JLabel mouseStrokelbl;
    private JPanel panel;

    public void initUserInterface() throws AWTException {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setFocusable(true);
        this.mouseStrokelbl = new JLabel("Mouse Stroke : ");
        this.keyStrokelbl = new JLabel("Key Stroke : ");
        this.panel = new JPanel();
        this.panel.add(keyStrokelbl);
        this.panel.add(mouseStrokelbl);

        keyMouseStroke keymouseStroke = initLabels();
        KeyListener keyListener = new keyStrokeImpl(keymouseStroke);
        MouseListener mouseListener = new mouseStrokeImpl(keymouseStroke);

        this.frame.addKeyListener(keyListener);
        this.frame.addMouseListener(mouseListener);

        this.frame.add(panel);
        this.frame.setVisible(true);

        //Screenshot
        screenShot screenshot = new screenShot();
        screenshot.run();



    }

    private keyMouseStroke initLabels() {
        keyMouseStroke keymouseStroke = new keyMouseStroke();
        keymouseStroke.setKeyStrokelbl(keyStrokelbl);
        keymouseStroke.setMouseStrokelbl(mouseStrokelbl);

        return keymouseStroke;

    }
}




