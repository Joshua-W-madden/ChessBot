import java.awt.*;

public class Hint {
    //private int x = Board.HALF_SQUARE_SIZE;
    //private int y = Board.HALF_SQUARE_SIZE;
    /*
    public int[][] availmoves(piece p){
        int[][] pos;

    }
    */


    public void draw(Graphics2D g2) {
        g2.setColor(new Color(160, 160, 160));
        g2.fillOval(getX(), getY(), Board.HALF_SQUARE_SIZE, Board.HALF_SQUARE_SIZE);
    }

    private int getX(){
        int x = Board.SQUARE_SIZE*2;
        x += Board.HALF_SQUARE_SIZE/2;
        return x;
    }

    private int getY(){
        int y = Board.SQUARE_SIZE*5;
        y += Board.HALF_SQUARE_SIZE/2;
        return y;
    }
}
