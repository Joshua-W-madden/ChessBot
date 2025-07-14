public class Queen extends piece{
    public Queen(int color, int col, int row) {
        super(color, col, row);
        if(color == GameWindow.WHITE){
            image = getImage("res/w_queen_1x.png");
        }
        else{
            image = getImage("res/b_queen_1x.png");
        }
    }
}
