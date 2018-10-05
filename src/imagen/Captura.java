package imagen;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Captura {
	
	public static void main(String[] args) throws IOException {
		capturar(25, 585 , 519, 992);
		GrayscaleConverter gc = new GrayscaleConverter();
		BufferedImage imageOnDisk = ImageIO.read(new File("scr.jpg"));
		ImageIO.write(gc.toGrayMethod1(imageOnDisk), "jpg", new File("scr.jpg"));
	}
	
	public static String capturar(int x1, int y1, int x2, int y2) {
		try {
            Robot robot = new Robot();
            String format = "jpg";
            String fileName = "scr." + format;
             
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle captureRect = new Rectangle(x1, y1, x2-x1, y2-y1);
            BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
            ImageIO.write(screenFullImage, format, new File(fileName));
             
            System.out.println("¡Captura guardada!");
            return fileName;
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
            return null;
        }
	}

}
