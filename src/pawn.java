public class pawn extends piece{
    public pawn(int color, int col, int row) {
        super(color, col, row);

        if(color == GameWindow.WHITE){
            image = getImage("res/w_pawn_1x.png");
        }
        else{
            image = getImage("res/b_pawn_1x.png");
        }

    }
    public int[][] availMoves(){
        return new int[0][];
    }

}
