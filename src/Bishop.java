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
    public int[][] availMoves() {
        int y = this.col;
        int x = this.row;
        int[][] takenSpots = GameWindow.spaces;
        /*
        for(int i = 0; i< 12; i++){
            if()
        }

         */
        return pos;
    }

    private int[][] take(int [][] arr){
        int [][] pos = arr;

    }
}
