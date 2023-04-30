import javax.swing.*;
import java.awt.*;

public class mainHero{
    public JPanel setGameCharacter()
    {
        JPanel gameCharacter = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // load the image file
                Image Character = new ImageIcon("C:\\Java Programming\\Game\\Assets\\Char0.png").getImage();
                g.drawImage(Character, 0, 0, 80, 700 / 7, null);
            }
        };
        gameCharacter.setOpaque(false);
        gameCharacter.setPreferredSize(new Dimension(80, 700 / 6));
        gameCharacter.setBounds(10, 445, 100, 700 / 6);
        return gameCharacter;
    }
}
