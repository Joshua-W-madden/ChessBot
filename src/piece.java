import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("CallToPrintStackTrace")
public abstract class piece {
    /*-
    public final int NON = 0;
    public final int PAWN = 1;
    public final int ROOK = 2;
    public final int BISHOP = 3;
    public final int KNIGHT = 4;
    public final int QUEEN = 5;
    public final int kING = 6;
    */


    public BufferedImage image;
    public int x, y;
    public int col, row;
    public int color;
    public boolean hasMoved = false;
    public int name;
    public boolean alive = true;
    private int length = Board.SQUARE_SIZE;
    private int height = Board.SQUARE_SIZE;


    public piece(int color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;
    }

    public int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }

    public int getY(int row) {
        return row * Board.SQUARE_SIZE;
    }

    public BufferedImage getImage(String imagePath) {
        image = null;

        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    public void die(){
        alive = false;
        height = height/2;
        length = length/2;
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(image, getX(col), getY(row), length, height, null);
    }

    public abstract void availMoves();
    //public void getName(){}
    public void hasMoved() {
        hasMoved = true;
    }
}