package org.example.Utility;

import javax.imageio.ImageIO;
import java.awt.*;
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
import java.util.Random;
import org.example.Utility.JDBCUtil;


public class screenShot implements Runnable{
    // Automatically record a screenshot after 3 mins
private static Date date = null;
private static long nextTime = 0;
private static final String DIR_NAME = "screenshots";

public void run(){
    while(true){
        if(nextTime < System.currentTimeMillis()){
            try {
                Thread.sleep(180000);
                Robot r = new Robot();
                date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd_HHmmss");
                createDirectory(DIR_NAME);
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
            } catch (AWTException | IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
    public static void createDirectory(String dirName) {
        File newDir = new File("C:\\"+dirName);
        if(!newDir.exists()){
            boolean isCreated = newDir.mkdir();
        }
    }


}
