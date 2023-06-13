import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static BufferedImage img;
    public static Comps Comp;
    public static JFrame frame;
    public static void main(String[] args) throws InterruptedException, IOException, AWTException {
        Robot robot=new Robot();
        img=robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));


        //img = ImageIO.read(new File("C:\\Users\\ns\\IdeaProjects\\untitled3\\src\\image.png"));

        frame = new JFrame("Test");
        //var device=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setLayout(new CardLayout());
        frame.setUndecorated(true);
        frame.setFocusable(true);
        frame.setAlwaysOnTop(true);
        frame.setBackground(new Color(10,10,10,10));

        //device.setFullScreenWindow(new Window(frame));


        Comp = new Comps();
        frame.add(Comp);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    frame.dispose();
                }
            }
        });

        frame.addMouseListener(new Mouse());


        frame.setVisible(true);


        while(frame.isVisible()){
                Comp.repaint();
                Thread.sleep(16);
        }
    }
}