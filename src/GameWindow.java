import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame implements Runnable{
    public static final int HEIGHT  = 800;
    public static final int WIDTH = 1100;
    final int FPS = 60;
    Thread gameThread; //threads track how many times the program is refreshing/ running or looping NEEDS THE RUNNABLE implementation tho

    GameWindow() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(0xBDD2E4));
    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null){

            System.out.println("Game running");

        }
    }

    private void update(){

    }
    private void paintComponent(Graphics g){
        super.paintComponents(g);
    }
}
