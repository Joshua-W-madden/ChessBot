import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings({"ReassignedVariable", "BusyWait"})
public class GameWindow extends JPanel implements Runnable{
    public static final int HEIGHT  = 800;
    public static final int WIDTH = 1100;
    final double FPS = 60;

    MouseHandler MouseH = new MouseHandler();
    Thread gameThread; //threads track how many times the program is refreshing/ running or looping NEEDS THE RUNNABLE implementation tho

    Board board = new Board();
    Hint hint = new Hint();

    public static final int EMPTY = 0;
    public static final int WHITE = 1;
    public static final int BLACK = 2;
    public int currentColor = WHITE;

    //Pieces
    public static ArrayList<piece> pieces = new ArrayList<piece>();
    piece selectedPiece;
    static int [][] spaces = new int [Board.MAX_COLS][Board.MAX_ROWS];

    //Hints
    public static ArrayList<Hint> hints = new ArrayList<Hint>();

    GameWindow() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(0, 0, 0));
        this.addMouseListener(MouseH);
        this.addMouseMotionListener(MouseH);
        this.setFocusable(true);

        setPieces();
    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; //the rate of each frame 0.16... seconds
        double nextDrawTime = System.nanoTime()+drawInterval; //when next frame should occur
        while(gameThread != null){

            // UPDATE: number of pieces and positions
            update();
            //DRAW: chess pieces on screen with updated values
            repaint(); //the paintComponent method is called this way
            //the FPS determines how many times per second this loop with occur

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/ 1000000; //converts nano to millisecond
                if (remainingTime < 0) { //if the program took too long don't sleep
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);
                //sleep requires a try and catch, long input, input in milliseconds

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update(){ //updates data
         if(MouseH.pressed){
            if(selectedPiece == null){

                for(piece p : pieces){
                    if(p.col == MouseH.x/Board.SQUARE_SIZE && p.row == MouseH.y/Board.SQUARE_SIZE ){
                        selectedPiece = p;
                    }
                }
            }
            else{
                legalMoves();
            }
         }

    }

    private void legalMoves(){
        selectedPiece.x = MouseH.x;
        selectedPiece.y = MouseH.y;

        System.out.println(selectedPiece + " was Clicked");
        selectedPiece = null;

    }


    public void setPieces() {
        pieces.add(new Rook(WHITE, 0, 0));
        pieces.add(new Knight(WHITE, 1, 0));
        pieces.add(new Bishop(WHITE, 2, 0));
        pieces.add(new Queen(WHITE, 3, 0));
        pieces.add(new King(WHITE, 4, 0));
        pieces.add(new Bishop(WHITE, 5, 0));
        pieces.add(new Knight(WHITE, 6, 0));
        pieces.add(new Rook(WHITE, 7, 0));
        pieces.add(new pawn(WHITE, 0, 1));
        pieces.add(new pawn(WHITE, 1, 1));
        pieces.add(new pawn(WHITE, 2, 1));
        pieces.add(new pawn(WHITE, 3, 1));
        pieces.add(new pawn(WHITE, 4, 1));
        pieces.add(new pawn(WHITE, 5, 1));
        pieces.add(new pawn(WHITE, 6, 1));
        pieces.add(new pawn(WHITE, 7, 1));

        pieces.add(new Rook(BLACK, 0, 7));
        pieces.add(new Knight(BLACK, 1, 7));
        pieces.add(new Bishop(BLACK, 2, 7));
        pieces.add(new Queen(BLACK, 3, 7));
        pieces.add(new King(BLACK, 4, 7));
        pieces.add(new Bishop(BLACK, 5, 7));
        pieces.add(new Knight(BLACK, 6, 7));
        pieces.add(new Rook(BLACK, 7, 7));
        pieces.add(new pawn(BLACK, 0, 6));
        pieces.add(new pawn(BLACK, 1, 6));
        pieces.add(new pawn(BLACK, 2, 6));
        pieces.add(new pawn(BLACK, 3, 6));
        pieces.add(new pawn(BLACK, 4, 6));
        pieces.add(new pawn(BLACK, 5, 6));
        pieces.add(new pawn(BLACK, 6, 6));
        pieces.add(new pawn(BLACK, 7, 6));

        for(piece p: pieces){
            if(p.color == WHITE){
                spaces[p.col][p.row] = WHITE;
            }
            else{
                spaces[p.col][p.row] = BLACK;
            }
        }
    }


    public void paintComponent(Graphics g){ //the draws everything(from background to chess pieces)
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        board.draw(g2);

        for (piece p: pieces){
            p.draw(g2);
        }

        hint.draw(g2);

    }

}
