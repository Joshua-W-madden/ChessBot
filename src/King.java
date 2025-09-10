public class King extends piece {
    public King(int color, int col, int row) {
        super(color, col, row);
        name = GameWindow.kING;
        if (color == GameWindow.WHITE) {
            image = getImage("res/w_King_1x.png");
        } else {
            image = getImage("res/b_King_1x.png");
        }
    }

    @Override
    public void availMoves() {
        moveUp();
        moveDown();
        moveSide();
        if(!hasMoved){
            castling();
        }


    }
    private boolean Recastable(){
        return !GameWindow.underAttack(col, row) &&
                !GameWindow.underAttack(col + 1, row) &&
                !GameWindow.underAttack(col + 2, row) &&
                !GameWindow.underAttack(col + 3, row);
    }

    public void castling(){
        //Right Castling
        if(GameWindow.spaces[col + 1][row] == GameWindow.EMPTY && GameWindow.spaces[col + 2][row] == GameWindow.EMPTY){
            if(Recastable()){
                for(piece p : GameWindow.pieces){
                    if(p.col == (col+3) && p.row == row && !p.hasMoved && p.name == GameWindow.BISHOP){
                        GameWindow.hints.add(new Hint(col + 1, row));
                        GameWindow.hints.add(new Hint(col + 2, row));
                    }
                }
            }

        }
        //Left Castling
        if(GameWindow.spaces[col - 1][row] == GameWindow.EMPTY && GameWindow.spaces[col - 2][row] == GameWindow.EMPTY){
            if(!GameWindow.underAttack(col, row)) {
                for (piece p : GameWindow.pieces) {
                    if (p.col == (col - 3) && p.row == row && !p.hasMoved && p.name == GameWindow.BISHOP) {
                        GameWindow.hints.add(new Hint(col - 1, row));
                        GameWindow.hints.add(new Hint(col - 2, row));
                    }
                }
            }
        }
    }




    private void moveSide() {
        if (col + 1 <= 7) {
            if (GameWindow.spaces[col + 1][row] != color) {
                GameWindow.hints.add(new Hint(col + 1, row));
            }
        }
        if (col - 1 >= 0) {
            if (GameWindow.spaces[col - 1][row] != color) {
                GameWindow.hints.add(new Hint(col - 1, row));
            }
        }
    }

    private void moveUp() {
        if (row + 1 <= 7) {
            if (GameWindow.spaces[col][row + 1] != color) {
                GameWindow.hints.add(new Hint(col, row + 1));
            }
            if (col + 1 <= 7) {
                if (GameWindow.spaces[col + 1][row + 1] != color) {
                    GameWindow.hints.add(new Hint(col + 1, row + 1));
                }
            }
            if (col - 1 >= 0) {
                if (GameWindow.spaces[col - 1][row + 1] != color) {
                    GameWindow.hints.add(new Hint(col - 1, row + 1));
                }
            }

        }
    }

    private void moveDown() {
        if (row - 1 >= 0) {
            if (GameWindow.spaces[col][row - 1] != color) {
                GameWindow.hints.add(new Hint(col, row - 1));
            }
            if (col + 1 <= 7) {
                if (GameWindow.spaces[col + 1][row - 1] != color) {
                    GameWindow.hints.add(new Hint(col + 1, row - 1));
                }
            }
            if (col - 1 >= 0) {
                if (GameWindow.spaces[col - 1][row - 1] != color) {
                    GameWindow.hints.add(new Hint(col - 1, row - 1));
                }
            }

        }
    }
}