import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    public static boolean pressed;
    public static boolean released;

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        pressed=true;
        released=false;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        pressed=false;
        released=true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
