import javax.swing.*;
import java.awt.*;

public class Frame extends mainHero{
    private int xOffset = 0;
    mainHero character=new mainHero();
    JFrame frame = new JFrame("Runner");

    public void render() {
        frame.setSize(1100, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JLayeredPane mainWindow = new JLayeredPane();

        // background
        JPanel gameWindow = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // load the image file
                Image backgroundImage = new ImageIcon("C:\\Java Programming\\Game\\Assets\\10.png").getImage();
                int height = frame.getHeight() - 250;
                xOffset--;
                if (xOffset < -frame.getWidth()) {
                    xOffset = 0;
                }
                g.drawImage(backgroundImage, xOffset, 0, frame.getWidth(), height, null);
                g.drawImage(backgroundImage, xOffset + frame.getWidth(), 0, frame.getWidth(), height, null);
            }
        };
        gameWindow.setPreferredSize(new Dimension(700, 445));
        gameWindow.setBounds(0, 0, 1100, 445);
        mainWindow.add(gameWindow, Integer.valueOf(0));

        // Road
        JPanel gameRoad = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // load the image file
                Image backgroundRoad = new ImageIcon("C:\\Java Programming\\Game\\Assets\\Road.png").getImage();
                int height = frame.getHeight() / 3;
                System.out.println(gameWindow.getHeight());
                xOffset--;
                if (xOffset < -frame.getWidth()) {
                    xOffset = 0;
                }
                g.drawImage(backgroundRoad, xOffset, 0, frame.getWidth(), height, null);
                g.drawImage(backgroundRoad, xOffset + frame.getWidth(), 0, frame.getWidth(), height, null);
            }
        };
        gameRoad.setPreferredSize(new Dimension(700, 220));
        gameRoad.setBounds(0, 445, 1100, 220);
        mainWindow.add(gameRoad, Integer.valueOf(1));
        JPanel mainChar=character.setGameCharacter();
        mainWindow.add(mainChar, Integer.valueOf(2));



        frame.getContentPane().add(mainWindow);
        Timer timer1 = new Timer(100, e -> gameWindow.repaint());
        timer1.start();
        Timer timer2 = new Timer(100, e -> gameRoad.repaint());
        timer2.start();
    }
}
