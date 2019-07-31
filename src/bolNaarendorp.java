import javax.swing.*;
import java.awt.*;

public class bolNaarendorp extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setMinimumSize(new Dimension(780,500));
        f.setTitle("Pyramide");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        JPanel p = new Panel();
        f.setContentPane(p);
        f.pack();
        f.setVisible(true);
    }
}
