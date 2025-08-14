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
        moveUp();
        moveDown();
        moveLeft();
        moveRight();
    }

    @Override
    public void hasMoved() {
    }

    private void moveUp(){
        int curr_col = col - 2;
        if(curr_col >= 0 && (row < 7)) {
            if (GameWindow.spaces[curr_col][row + 1] != color){
                GameWindow.hints.add(new Hint(curr_col, row + 1));
            }
        }
        if(curr_col >= 0 && (row > 1)) {
            if (GameWindow.spaces[curr_col][row - 1] != color){
                GameWindow.hints.add(new Hint(curr_col, row - 1));
            }
        }
    }

    private void moveDown(){
        int curr_col = col + 2;
        if(curr_col <= 7 && (row +1 <= 7)) {
            if (GameWindow.spaces[curr_col][row + 1] != color){
                GameWindow.hints.add(new Hint(curr_col, row + 1));
            }
        }
        if(curr_col <= 7 && (row -1 >= 0)) {
            if (GameWindow.spaces[curr_col][row - 1] != color){
                GameWindow.hints.add(new Hint(curr_col, row - 1));
            }
        }
    }
    private void moveLeft(){
        int curr_row = row + 2;
        if(col + 1 <= 7 && (curr_row <= 7)) {
            if (GameWindow.spaces[col + 1][curr_row] != color){
                GameWindow.hints.add(new Hint(col + 1, curr_row));
            }
        }
        if(col > 0 && (curr_row <= 7)) {
            if (GameWindow.spaces[col -1][curr_row] != color){
                GameWindow.hints.add(new Hint(col - 1, curr_row));
            }
        }
    }
    private void moveRight(){
        int curr_row = row - 2;
        if(col + 1 <= 7 && (curr_row >= 0)) {
            if (GameWindow.spaces[col + 1][curr_row] != color){
                GameWindow.hints.add(new Hint(col + 1, curr_row));
            }
        }
        if(col - 1 >= 0 && (curr_row >= 0)) {
            if (GameWindow.spaces[col -1][curr_row] != color){
                GameWindow.hints.add(new Hint(col - 1, curr_row));
            }
        }
    }


}
