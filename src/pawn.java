public class pawn extends piece{
    public boolean hasMoved = false;

    public pawn(int color, int col, int row) {
        super(color, col, row);
        if(color == GameWindow.WHITE){
            image = getImage("res/w_pawn_1x.png");
        }
        else{
            image = getImage("res/b_pawn_1x.png");
        }

    }
    public boolean[][] availMoves(){
        moveUp(col, row);
        eat(col, row);
        return moves;
    }
    private void moveUp(int col, int row){
        this.col = col;
        this.row = row;
        if(!hasMoved){
            if(GameWindow.spaces[col][row -1] == 0 && GameWindow.spaces[col][row -2] == 0){
                moves[col][row -1] = true;
                moves[col][row -2] = true;
            }
        }

        if(GameWindow.spaces[col][row - 1] == 0){
            moves[col][row -1] = true;
        }
    }
    private void eat(int col, int row){
        this.col = col;
        this.row = row;

        if(GameWindow.spaces[col-1][row -1] != color && GameWindow.spaces[col-1][row -1] != 0){
            moves[col-1][row -1] = true;
        }
        if(GameWindow.spaces[col+ 1][row +1] != color && GameWindow.spaces[col+ 1][row +1] != 0){
            moves[col+ 1][row +1] = true;
        }
    }
}

