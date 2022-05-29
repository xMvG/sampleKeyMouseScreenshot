package org.example.impl;

import org.example.Utility.JDBCUtil;
import org.example.Utility.keyMouseStroke;
import org.example.Utility.screenShot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class keyStrokeImpl implements KeyListener {
    private int keyCount = 0;

    private JLabel keyStrokeLbl;

    private keyMouseStroke keymouseStroke;

    private static Date date = null;

    private static final String DIR_NAME = "screenshots";

    public keyStrokeImpl(keyMouseStroke keymouseStroke) throws AWTException {
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
            keymouseStroke.getKeyStrokelbl().setText("Key Stroke: " + keyCount);
            //System.out.println(e.getKeyCode());

        }
        }



    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_PRINTSCREEN ) {
            //Record a screenshot when you press PRINT SCREEN button
            try {
                Robot r = new Robot();
                date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd_HHmmss");
                screenShot.createDirectory(DIR_NAME);
                Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                BufferedImage Image = r.createScreenCapture(capture);
                ImageIO.write(Image, "jpg", new File("C:\\screenshots\\" + dateFormat.format(date) + ".png"));

                JDBCUtil jdbcUtil = new JDBCUtil("jdbc:mysql://localhost/kmsreenshot","mvg","mvg31");
                File file=new File("C:\\screenshots\\" + dateFormat.format(date) + ".png");
                FileInputStream fis=new FileInputStream(file);
                PreparedStatement ps=jdbcUtil.getConnection().prepareStatement("insert into image_table (image_pathlocation) values(?)");
                ps.setString(1, String.valueOf(file));
                ps.executeUpdate();
                ps.close();
                fis.close();

                System.out.println(dateFormat.format(date));
                System.out.println("Screenshot saved");
            } catch (AWTException | IOException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException sqlException) {
                throw new RuntimeException(sqlException);
            }
        }

    }
}
