public class Bishop extends piece{

    public Bishop(int color, int col, int row) {
        super(color, col, row);
        if(color == GameWindow.WHITE){
            image = getImage("res/w_bishop_1x.png");
        }
        else{
            image = getImage("res/b_bishop_1x.png");
        }
    }

    @Override
    public boolean[][] availMoves() {
        upRight(col, row);
        upLeft(col, row);
        downLeft(col, row);
        downRight(col, row);
        return moves;
    }
    private void upRight(int col, int row){
        this. col = col;
        this.row = row;

        if(col + 1 < 8 && row + 1 < 8) {
            if (GameWindow.spaces[col][row] == color) {
                moves[col][row] = false;
            } else if (GameWindow.spaces[col][row] == 0) {
                moves[col][row] = true;
                upRight(col + 1, row + 1);
            } else {
                moves[col][row] = true;
            }
        }
    }

    private void upLeft(int col, int row){
        this. col = col;
        this.row = row;

        if(col -1  >= 0 && row + 1 < 8) {
            if (GameWindow.spaces[col][row] == color) {
                moves[col][row] = false;
            } else if (GameWindow.spaces[col][row] == 0) {
                moves[col][row] = true;
                upLeft(col - 1, row + 1);
            } else {
                moves[col][row] = true;
            }
        }
    }

    private void downLeft(int col, int row){
        this. col = col;
        this.row = row;

        if(col -1  >= 0 && row - 1 >= 0) {
            if (GameWindow.spaces[col][row] == color) {
                moves[col][row] = false;
            } else if (GameWindow.spaces[col][row] == 0) {
                moves[col][row] = true;
                upLeft(col - 1, row - 1);
            } else {
                moves[col][row] = true;
            }
        }
    }

    private void downRight(int col, int row){
        this. col = col;
        this.row = row;

        if(col + 1 < 8 && row - 1 < 8) {
            if (GameWindow.spaces[col][row] == color) {
                moves[col][row] = false;
            } else if (GameWindow.spaces[col][row] == 0) {
                moves[col][row] = true;
                upRight(col + 1, row - 1);
            } else {
                moves[col][row] = true;
            }
        }
    }

}
