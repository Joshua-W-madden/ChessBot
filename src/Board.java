import java.awt.*;

public class Board {

    public static final int MAX_COLS = 8;
    public static final int MAX_ROWS = 8;
    public static final int SQUARE_SIZE = 100;
    public static final int HALF_SQUARE_SIZE = SQUARE_SIZE/2;


    public void draw(Graphics2D g2){
        boolean isDark = false;

        for(int row = 0; row < MAX_ROWS; row++){
            isDark = !isDark;

            for(int col = 0; col < MAX_COLS; col++){
                if (isDark){
                    g2.setColor(new Color(93, 50, 49));
                    isDark = false;

                }
                else{
                    g2.setColor(new Color(121,72,57,255));
                    isDark = true;
                }
                g2.fillRect(col*SQUARE_SIZE, row*SQUARE_SIZE, SQUARE_SIZE,SQUARE_SIZE);
            }
        }


    }

}
