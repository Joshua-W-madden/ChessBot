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
    public void availMoves() {
        moveUp(row);
        moveDown(row);
        moveLeft(col);
        moveRight(col);
    }
    private void moveUp(int row){
        int curr_row = row - 1;

        if (curr_row >= 0) {
            if (GameWindow.spaces[col][curr_row] == 0) {
                GameWindow.hints.add(new Hint(col, curr_row));
                moveUp(curr_row);
            }
            else if(GameWindow.spaces[col][curr_row] != color){
                GameWindow.hints.add(new Hint(col, curr_row));
            }
        }
    }

    private void moveDown(int row){
        int curr_row = row + 1;
        if (curr_row <= 7) {
            if (GameWindow.spaces[col][curr_row] == GameWindow.EMPTY) {
                moves[col][curr_row] = true;
                GameWindow.hints.add(new Hint(col, curr_row));
                moveDown(curr_row);
            }
            else if(GameWindow.spaces[col][curr_row] != color){
                GameWindow.hints.add(new Hint(col, curr_row));
            }
        }
    }

    private void moveLeft(int col){
        int curr_col = col - 1;

        if(curr_col >= 0){
            if(GameWindow.spaces[curr_col][row] == GameWindow.EMPTY){
                GameWindow.hints.add(new Hint(curr_col, row));
                moveLeft(curr_col);
            }
            else if(GameWindow.spaces[curr_col][row] != color){
                GameWindow.hints.add(new Hint(curr_col, row));
            }
        }
    }
    private void moveRight(int col){
        int curr_col = col + 1;
        if(curr_col <= 7) {
            if (GameWindow.spaces[curr_col][row] == GameWindow.EMPTY) {
                GameWindow.hints.add(new Hint(curr_col, row));
                moveRight(curr_col);
            }
            else if(GameWindow.spaces[curr_col][row] != color){
                GameWindow.hints.add(new Hint(curr_col, row));
            }
        }
    }
}
