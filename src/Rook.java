public class Rook extends piece{
    public Rook(int color, int col, int row) {
        super(color, col, row);
        if(color == GameWindow.WHITE){
            image = getImage("res/w_rook_1x.png");
        }
        else{
            image = getImage("res/b_rook_1x.png");
        }
    }
}
