public class Knight extends piece{
    public Knight(int color, int col, int row) {
        super(color, col, row);
        if(color == GameWindow.WHITE){
            image = getImage("res/w_knight_1x.png");
        }
        else{
            image = getImage("res/b_knight_1x.png");
        }
    }

    @Override
    public void availMoves() {
    }
}
