public class King extends piece{
    public King(int color, int col, int row) {
        super(color, col, row);
        if(color == GameWindow.WHITE){
            image = getImage("res/w_King_1x.png");
        }
        else{
            image = getImage("res/b_King_1x.png");
        }
    }

    @Override
    public void availMoves() {
        move();
    }
    public void move(){
        if(col > 0 && row > 0){
            if(GameWindow.spaces[col-1][row] != color){
                GameWindow.hints.add(new Hint(col -1, row -1));
                GameWindow.hints.add(new Hint(col -1, row));
                GameWindow.hints.add(new Hint(col -1, row +1));
                GameWindow.hints.add(new Hint(col +1, row -1));
                GameWindow.hints.add(new Hint(col +1, row));
                GameWindow.hints.add(new Hint(col +1, row +1));
            }
        }
    }
}
