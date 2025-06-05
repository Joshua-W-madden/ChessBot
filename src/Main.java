import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame windowFrame = new JFrame("Chess");
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setResizable(false);
        windowFrame.setLocationRelativeTo(null); //opens the window in the center of the creen
        windowFrame.setVisible(true);//lets you see the window

        ImageIcon image = new ImageIcon("icon.jpg");
        windowFrame.setIconImage(image.getImage());

        GameWindow gw = new GameWindow();
        windowFrame.add(gw);
        windowFrame.pack(); //the window will adjust to the size of the game window

        gw.launchGame();
    }
}
