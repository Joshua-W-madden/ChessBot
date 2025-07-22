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
        moveUp();
        eat();
        return moves;
    }
    private void moveUp(){
        if(color == GameWindow.WHITE){
            moveDown();
        }
        else {
            if (!hasMoved) {
                if (GameWindow.spaces[col][row - 1] == GameWindow.EMPTY && GameWindow.spaces[col][row - 2] == GameWindow.EMPTY) {
                    moves[col][row - 1] = true;
                    moves[col][row - 2] = true;
                }
            }

            if (GameWindow.spaces[col][row - 1] == GameWindow.EMPTY) {
                moves[col][row - 1] = true;
            }
        }
    }
    private void moveDown(){
        if (!hasMoved) {
            if (GameWindow.spaces[col][row + 1] == GameWindow.EMPTY && GameWindow.spaces[col][row + 2] == GameWindow.EMPTY) {
                moves[col][row + 1] = true;
                moves[col][row + 2] = true;
            }
        }

        if (GameWindow.spaces[col][row + 1] == GameWindow.EMPTY) {
            moves[col][row + 1] = true;
        }
    }
    private void eat(){
        if(color == GameWindow.WHITE){
            eatDown();
        }
        else {
            if((row != 0) || (col != 0)){
                if ((GameWindow.spaces[col - 1][row - 1] != color) && (GameWindow.spaces[col - 1][row - 1] != GameWindow.EMPTY)) {
                    moves[col - 1][row - 1] = true;
                }
            }
            if((row != 0) || (col != 7)) {
                if (GameWindow.spaces[col + 1][row - 1] != color && GameWindow.spaces[col + 1][row - 1] != GameWindow.EMPTY) {
                    moves[col + 1][row - 1] = true;
                }
            }
        }
    }
    private void eatDown(){
        if(GameWindow.spaces[col+1][row +1] != color && GameWindow.spaces[col-1][row +1] != GameWindow.EMPTY){
            moves[col +1][row +1] = true;
        }
        if(GameWindow.spaces[col+ 1][row +1] != color && GameWindow.spaces[col+ 1][row +1] != GameWindow.EMPTY){
            moves[col +1][row +1] = true;
        }
    }
}

