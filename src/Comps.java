import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Comps extends JComponent {
    public static Graphics2D g2;
    public static BufferedImage img;
    public static int x1=-1;
    public static int y1=-1;
    public static int x2;
    public static int y2;
    public static Rectangle size=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

    public Comps() throws AWTException {
        Robot robot=new Robot();
        img=robot.createScreenCapture(size);
    }
    public void paintComponent(Graphics g) {
        g2 = (Graphics2D) g;
        g2.drawImage(img, 0, 0, this);
        var mouse = MouseInfo.getPointerInfo().getLocation();
        x2 = mouse.x;
        y2 = mouse.y;
        g2.setColor(new Color(255, 255, 255));

        if (x1 != -1 || y1 != -1) {
            if (x1 - x2 < 0 && y1 - y2 < 0) {
                g2.drawRect(x1, y1, x2 - x1, y2 - y1);
            } else if(x1 - x2 < 0){
                g2.drawRect(x1, y2, x2 - x1, y1 - y2);
            } else if(y1 - y2 < 0){
                g2.drawRect(x2, y1, x1 - x2, y2 - y1);
            } else {
                g2.drawRect(x2, y2, x1 - x2, y1 - y2);
            }
        }
    }
    public static void crop(){
        if (x1 != -1 || y1 != -1) {
            if (x1 - x2 < 0 && y1 - y2 < 0) {
                img = img.getSubimage(x1, y1, x2 - x1, y2 - y1);
            } else if(x1 - x2 < 0){
                img = img.getSubimage(x1, y2, x2 - x1, y1 - y2);
            } else if(y1 - y2 < 0){
                img = img.getSubimage(x2, y1, x1 - x2, y2 - y1);
            } else {
                img = img.getSubimage(x2, y2, x1 - x2, y1 - y2);
            }
        }
    }
}

