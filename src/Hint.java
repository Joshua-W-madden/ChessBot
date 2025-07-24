import java.awt.*;

public class Hint{
    public int col, row;

    public Hint(int col, int row){
        this.col = col;
        this.row = row;
    }
    public void draw(Graphics2D g2) {
        g2.setColor(new Color(160, 160, 160));
        g2.fillOval(getX(), getY(), Board.HALF_SQUARE_SIZE, Board.HALF_SQUARE_SIZE);
    }

    private int getX(){
        int x = Board.SQUARE_SIZE* col;
        x += Board.HALF_SQUARE_SIZE/2;
        return x;
    }

    private int getY(){
        int y = Board.SQUARE_SIZE* row;
        y += Board.HALF_SQUARE_SIZE/2;
        return y;
    }
}
