import javax.swing.*;
import java.awt.*;

class Comps extends JComponent {
    public static Graphics2D g2;
    int mouseX;
    int mouseY;
    int prevX;
    int prevY;
    int finX;
    int finY;
    boolean released =false;
    boolean pressed=false;

    public void paintComponent(Graphics g){
        g2 = (Graphics2D) g;

        mouseX=getMousePosition().x;
        mouseY=getMousePosition().y;

        g2.drawImage(Main.img, 0, 0, this);

        if(!released&&pressed) {
            g2.drawRect(prevX, prevY, mouseX - prevX, mouseY - prevY);
        } else {
            g2.drawRect(prevX, prevY, finX, finY);
        }

        g2.setColor(new Color(100,100,100));
    }

    public void upd(){
        mouseX=getMousePosition().x;
        mouseY=getMousePosition().y;
    }
    public void press(){
        if(getMousePosition()!=null) {
            pressed=true;
            prevX = getMousePosition().x;
            prevY = getMousePosition().y;
        } else {
            System.out.println(getMousePosition());
        }
    }
    public void release(){
        if(getMousePosition()!=null) {
            released = true;
            finX = getMousePosition().x;
            finY = getMousePosition().y;
        }
    }
}
