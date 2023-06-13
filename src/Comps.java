import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Comps extends JComponent {
    public static Graphics2D g2;
    public static BufferedImage img;
    public static int x1;
    public static int y1;
    public static int x2;
    public static int y2;

    public Comps() throws AWTException {
        Robot robot=new Robot();
        img=robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    }

    public void paintComponent(Graphics g) {
        g2=(Graphics2D) g;
        g2.drawImage(img,0,0,this);
    }
    public static void crop(){
        img = img.getSubimage(x1,y1,Math.abs(x1-x2),Math.abs(y1-y2));

    }
//    public static void once(){
//        img=img.getSubimage(x1,y1,Math.abs(x1-x2),Math.abs(y1-y2));
//        img.createGraphics();
//    }


}
