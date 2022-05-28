package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class screenShot {
    public static final long serialVersionUID = 1L;
    private static Date date = null;
    private static long nextTime = 0;
    private static final String DIR_NAME = "screenshots";
    public static void main(String[] args) {
        while (true) {
            if (nextTime < System.currentTimeMillis()) {
                try {
                    Thread.sleep(30000);
                    Robot r = new Robot();

                    // It saves screenshot to desired path
                    //String path = "D:// Shot.jpg";

                    // Used to get ScreenSize and capture image
                    date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd_HHmmss");
                    createDirectory(DIR_NAME);
                    Rectangle capture =
                            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                    BufferedImage Image = r.createScreenCapture(capture);
                    ImageIO.write(Image, "jpg", new File("D:\\screenshots\\" + dateFormat.format(date) + ".png"));
                    System.out.println(dateFormat.format(date));
                    System.out.println("Screenshot saved");
                } catch (AWTException | IOException | InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    private static void createDirectory(String dirName) {
        File newDir = new File("D:\\"+dirName);
        if(!newDir.exists()){
            boolean isCreated = newDir.mkdir();
        }
    }
    private void getNextFreq() {
        long currentTime = System.currentTimeMillis();
        Random random = new Random();
        long value = random.nextInt(10000); //1800000
        nextTime = currentTime + value;
        //return currentTime+value;
    }


}
