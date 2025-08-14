public class King extends piece {
    public King(int color, int col, int row) {
        super(color, col, row);
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
    }

    @Override
    public void hasMoved() {
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