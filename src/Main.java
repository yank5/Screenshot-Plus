import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Thread{
    public static Comps Comp;
    public static JFrame frame;
    public static void main(String[] args) throws InterruptedException, AWTException {
        frame = new JFrame("Test");
        //var device=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        //frame.setLayout();
        frame.setUndecorated(true);
        frame.setFocusable(true);
        frame.setAlwaysOnTop(true);
        //frame.setResizable(true);
        frame.setBackground(new Color(10,10,10,10));

        //device.setFullScreenWindow(new Window(frame));

        System.out.println(System.getProperty("user.dir"));
        Comp = new Comps();
        frame.add(Comp);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    frame.dispose();
                }
                if(e.getKeyCode()==KeyEvent.VK_S&&e.isControlDown()){
                    save();
                }
            }
        });

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Comps.x1 =MouseInfo.getPointerInfo().getLocation().x;
                Comps.y1 =MouseInfo.getPointerInfo().getLocation().y;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                Comps.x2 =MouseInfo.getPointerInfo().getLocation().x;
                Comps.y2 =MouseInfo.getPointerInfo().getLocation().y;
                Comps.crop();
                save();
            }
        });
        frame.setVisible(true);

        while(frame.isVisible()){
                Comp.repaint();
                Thread.sleep(16);
        }
    }

    public static void save(){
        File file=new File(System.getProperty("user.dir")+"/test.png");
        try {
            ImageIO.write(Comps.img,"png",file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Main.frame.dispose();
    }

    @Override
    public void run() {
        while(frame.isVisible()){

        }
    }
}