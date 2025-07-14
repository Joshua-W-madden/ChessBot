public class King extends piece{
    public King(int color, int col, int row) {
        super(color, col, row);
        if(color == GameWindow.WHITE){
            image = getImage("res/w_King_1x.png");
        }
        else{
            image = getImage("res/b_King_1x.png");
        }
    }
}
