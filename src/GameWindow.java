import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"ReassignedVariable", "BusyWait"})
public class GameWindow extends JPanel implements Runnable{
    public static final int HEIGHT  = 800;
    public static final int WIDTH = 1100;
    final double FPS = 60;

    MouseHandler MouseH = new MouseHandler();
    Thread gameThread; //threads track how many times the program is refreshing/ running or looping NEEDS THE RUNNABLE implementation tho

    Board board = new Board();

    GameWindow() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(0, 0, 0));
        this.addMouseListener(MouseH);
        this.setFocusable(true);
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
            repaint(); //the paintComponent method is called this way(idk why)
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
        //*if(MouseH.clicked){}

    }
    public void paintComponent(Graphics g){ //the draws everything(from background to chess pieces)
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        board.draw(g2);

    }

}
