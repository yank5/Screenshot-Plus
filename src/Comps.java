import javax.swing.*;
import java.awt.*;

class Comps extends JComponent {
    public static Graphics2D g2;
    static int mouseX=MouseInfo.getPointerInfo().getLocation().x;
    static int mouseY=MouseInfo.getPointerInfo().getLocation().y;
    static int prevX;
    static int prevY;
    static int finX;
    static int finY;
    static boolean released =false;
    static boolean pressed=false;
    static boolean once=false;
    static boolean once2=false;


    public void paintComponent(Graphics g){
        mouseX=MouseInfo.getPointerInfo().getLocation().x;
        mouseY=MouseInfo.getPointerInfo().getLocation().y;

        g2 = (Graphics2D) g;
        g2.drawImage(Main.img, 0, 0, this);

        if(Mouse.pressed) {
            if(!once){
                prevX=mouseX;
                prevY=mouseY;
                once=true;
            }
            g2.drawRect(prevX, prevY, mouseX, mouseY);
            System.out.println("mousex "+mouseX+" prevx "+prevX);
        }
        if(Mouse.released){
            if(!once2){
                finX=mouseX;
                finY=mouseY;
                once2=true;
            }
            g2.drawRect(prevX, prevY, finX, finY);
        }

        g2.setColor(new Color(255, 255, 255));
    }


}
