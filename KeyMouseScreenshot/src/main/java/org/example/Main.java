package org.example;

import org.example.Utility.KmsUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) throws AWTException {
        KmsUI kmsUI = new KmsUI();
        kmsUI.initUserInterface();
    }
}