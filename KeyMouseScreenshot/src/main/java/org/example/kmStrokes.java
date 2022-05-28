package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class kmStrokes {
    int keyCount = 0;
    int mouseCount = 0;
    public kmStrokes(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame. setFocusable(true);

        JPanel panel = new JPanel();
        JLabel keyStrokeLbl = new JLabel();
        JLabel mouseStrokeLbl = new JLabel();

        panel.add(keyStrokeLbl);
        panel.add(mouseStrokeLbl);
        keyStrokeLbl.setText(" KeyStroke: ");
        mouseStrokeLbl.setText(" MouseStroke: ");
        keyStrokeLbl.setFont(new Font("Serif", Font.PLAIN, 30));
        mouseStrokeLbl.setFont(new Font("Serif", Font.PLAIN, 30));


        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                    mouseCount++;
                    //System.out.println(mouseCount);
                    mouseStrokeLbl.setText("MouseStroke: " + mouseCount);
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
        });



        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //char ch = event.getKeyChar();

                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    keyCount++;
                    //System.out.println(keyCount);
                    keyStrokeLbl.setText("KeyStroke: " + keyCount);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        frame.add(panel);
    }



}