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

    @Override
    public boolean[][] availMoves() {
        moveUp();
        moveDown();
        moveLeft();
        moveRight();
        return moves;
    }
    private void moveUp(){
        if(color == GameWindow.WHITE){
            moveDown();
        }
        else {
            this.col = col;
            this.row = row - 1;

            if (row >= 0) {
                if (GameWindow.spaces[col][row] == 0) {
                    moves[col][row] = true;
                    moveUp();
                } else moves[col][row] = GameWindow.spaces[col][row] != this.color;
            }
        }
    }
    private void moveDown(){
        if(color == GameWindow.WHITE){
            moveUp();
        }
        else {
            int Currentcol = col;
            int currentrow = row + 1;

            if (row <= 7) {
                if (GameWindow.spaces[col][row] == GameWindow.EMPTY) {
                    moves[col][row] = true;
                    moveDown();
                } else moves[col][row] = GameWindow.spaces[col][row] != color;
            }
        }
    }
    private void moveLeft(){
        this.col = col - 1;
        this.row = row;

        if(col >= 0){
            if(GameWindow.spaces[col][row] == GameWindow.EMPTY){
                moves[col][row] = true;
                moveLeft();
            }
            else moves[col][row] = GameWindow.spaces[col][row] != color;
            /*
            replace with:
            else if(GameWindow.spaces[col][row] == this.color){
                moves[col][row] = false;
            }
            else{
                moves[col][row] = true;
            }
            Since the GameWindow.spaces white and black = 1,2 and 0 means empty
             */
        }
    }
    private void moveRight(){
        int Currentcol = col + 1;
        int currentrow = row;

        if(col <= 7) {
            if (GameWindow.spaces[col][row] == GameWindow.EMPTY) {
                moves[col][row] = true;
                moveRight();
            } else moves[col][row] = GameWindow.spaces[col][row] != color;
        }
    }
}
