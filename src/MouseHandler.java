import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
    int x;
    int y;
    boolean clicked;

    /*
    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        int code = e.getButton();
        if (code == MouseEvent.BUTTON1){
            clicked = true;
        }
    }
    */


    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        int code = e.getButton();
        if (code == MouseEvent.BUTTON1){
            clicked = true;
        }
    }
}
