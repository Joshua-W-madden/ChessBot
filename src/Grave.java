import java.awt.*;

public class Grave extends Board{
    public void draw(Graphics2D g2){
        g2.setColor(new Color(200, 157, 124));
        g2.fillRect(MAX_COLS*SQUARE_SIZE, 0, SQUARE_SIZE*4, SQUARE_SIZE*8);
    }

}
