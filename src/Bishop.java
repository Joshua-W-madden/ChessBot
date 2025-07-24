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
    public void availMoves() {
        upRight(col, row);
        upLeft(col, row);
        downLeft(col, row);
        downRight(col, row);
    }
    private void upRight(int col, int row){
        int curr_col = col + 1;
        int curr_row = row + 1;

        if(curr_col < 8 && curr_row < 8) {
            if (GameWindow.spaces[curr_col][curr_row] == 0) {
                GameWindow.hints.add(new Hint(curr_col,curr_row));
                upRight(curr_col, curr_row);
            }
            else if (GameWindow.spaces[curr_col][curr_row] != color){
                GameWindow.hints.add(new Hint(curr_col,curr_row));
            }
        }
    }

    private void upLeft(int col, int row){
        int curr_col = col - 1;
        int curr_row = row + 1;

        if(curr_col >= 0 && curr_row < 8) {
            if (GameWindow.spaces[curr_col][curr_row] == 0) {
                GameWindow.hints.add(new Hint(curr_col,curr_row));
                upLeft(curr_col, curr_row);
            } else if (GameWindow.spaces[curr_col][curr_row] != color){
                GameWindow.hints.add(new Hint(curr_col,curr_row));
            }
        }
    }

    private void downLeft(int col, int row){
        int curr_col = col - 1;
        int curr_row = row - 1;

        if(curr_col >= 0 && curr_row >= 0) {
            if (GameWindow.spaces[curr_col][curr_row] == 0) {
                GameWindow.hints.add(new Hint(curr_col,curr_row));
                downLeft(curr_col, curr_row);
            } else if (GameWindow.spaces[curr_col][curr_row] != color){
                GameWindow.hints.add(new Hint(curr_col,curr_row));
            }
        }
    }

    private void downRight(int col, int row){
        int curr_col = col + 1;
        int curr_row = row - 1;

        if(curr_col < 8 && curr_row >= 0) {
            if (GameWindow.spaces[curr_col][curr_row] == 0) {
                GameWindow.hints.add(new Hint(curr_col,curr_row));
                downRight(curr_col, curr_row);
            } else if (GameWindow.spaces[curr_col][curr_row] != color){
                GameWindow.hints.add(new Hint(curr_col,curr_row));
            }
        }
    }

}
