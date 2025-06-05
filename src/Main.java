import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame windowFrame = new JFrame();
        windowFrame.setTitle("Chess");
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setResizable(false);

        ImageIcon image = new ImageIcon("icon.jpg");
        windowFrame.setIconImage(image.getImage());

        GameWindow GameWindow = new GameWindow();
        windowFrame.add(GameWindow);

        windowFrame.pack();

        windowFrame.setLocationRelativeTo(null);
        windowFrame.setVisible(true);

        GameWindow.launchGame();

    }
}
