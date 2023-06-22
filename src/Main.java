import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Thread{
    public static Comps Comp;
    public static JFrame frame;
    public static boolean settingsOpen=false;
    public static boolean once =false;
    public static JComboBox box;
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        frame = new JFrame("Screenshot+");

        //var device=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setUndecorated(true);
        frame.setFocusable(true);
        frame.setAlwaysOnTop(true);
        //frame.setResizable(true);
        frame.setBackground(new Color(10,10,10,10));


        //device.setFullScreenWindow(new Window(frame));


        Comp = new Comps();

        JButton jButton=new JButton("Settings");
        jButton.setBounds(960,0,50,30);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsOpen=!settingsOpen;
                System.out.println(settingsOpen);
            }
        });

        //box=new JComboBox<>(new String[]{"Clipboard","File","Upload"});

        frame.add(jButton);
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
                if(!settingsOpen) {
                    Comps.x1 = MouseInfo.getPointerInfo().getLocation().x;
                    Comps.y1 = MouseInfo.getPointerInfo().getLocation().y;
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(!settingsOpen) {
                    Comps.x2 = MouseInfo.getPointerInfo().getLocation().x;
                    Comps.y2 = MouseInfo.getPointerInfo().getLocation().y;
                    Comps.crop();
                    save();
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if(!settingsOpen){
                    save();
                }
            }
        });
        frame.setVisible(true);

        while(frame.isVisible()){
                Comp.repaint();
                if(settingsOpen){
                    settings();
                }
                Thread.sleep(16);
        }
    }
    public static void settings() throws IOException {
//        File file=new File(System.getProperty("user.dir")+"/settings");
//        FileReader fileReader=new FileReader(file);
//
//        FileWriter fileWriter=new FileWriter(file);

        //fileWriter.write();

        if(!once) {
            box.setVisible(true);
            once=true;
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