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
        hasMoved = false;

    }
    public void availMoves(){
        moveUp();
        eat();
    }

    @Override
    public void hasMoved() {
        hasMoved = true;
    }

    private void moveUp(){
        if(color == GameWindow.WHITE){
            moveDown();
        }
        else {
            if (GameWindow.spaces[col][row - 1] == GameWindow.EMPTY) {
                GameWindow.hints.add(new Hint(col ,row - 1));
            }
            if (!hasMoved) {
                if (GameWindow.spaces[col][row - 2] == GameWindow.EMPTY) {
                    GameWindow.hints.add(new Hint(col ,row - 2));
                }
            }
        }
    }
    private void moveDown(){
        if(row != 7) {
            if (GameWindow.spaces[col][row + 1] == GameWindow.EMPTY) {
                GameWindow.hints.add(new Hint(col, row + 1));
            }
            if (!hasMoved) {
                if (GameWindow.spaces[col][row + 2] == GameWindow.EMPTY) {
                    GameWindow.hints.add(new Hint(col, row + 2));
                }
            }
        }
    }
    private void eat(){
        if(color == GameWindow.WHITE){
            eatDown();
        }
        else {
            if((row != 0) && (col != 0)){
                if ((GameWindow.spaces[col - 1][row - 1] != color) && (GameWindow.spaces[col - 1][row - 1] != GameWindow.EMPTY)) {
                    GameWindow.hints.add(new Hint(col - 1,row - 1));
                }
            }
            if((row != 0) && (col != 7)) {
                if (GameWindow.spaces[col + 1][row - 1] != color && GameWindow.spaces[col + 1][row - 1] != GameWindow.EMPTY) {
                    GameWindow.hints.add(new Hint(col + 1,row - 1));
                }
            }
        }
    }
    private void eatDown(){
        if((row != 7) && (col != 7)) {
            if (GameWindow.spaces[col + 1][row + 1] != color && GameWindow.spaces[col + 1][row + 1] != GameWindow.EMPTY) {
                GameWindow.hints.add(new Hint(col + 1,row + 1));
            }
        }
        if((row != 7) && (col != 0)) {
            if (GameWindow.spaces[col - 1][row + 1] != color && GameWindow.spaces[col - 1][row + 1] != GameWindow.EMPTY) {
                GameWindow.hints.add(new Hint(col - 1,row + 1));
            }
        }
    }
}

