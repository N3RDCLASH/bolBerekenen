import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;


import static java.lang.Math.pow;

public class Panel extends JPanel {
    Double pi = 3.14159265359, r, inhoud, opp;
    ImageIcon img;
    JLabel lbImage, lbStraal, lbInhoud, lbOppervlakte;
    JTextField tfStraal, tfInhoud, tfOppervlakte;
    JButton btHelp,btClear;

    Panel() {
        setLayout(null);
        setBackground(Color.BLACK);
        Color yel =new Color(251, 192, 45);

        img = new ImageIcon(getClass().getResource("giphy.gif"));
        lbImage = new JLabel();
        lbImage.setIcon(img);
        lbImage.setBounds(0,0,500,500);

        tfStraal = new JTextField(10);
        tfStraal.setBorder(null);
        tfStraal.setBounds(637, 289, 96, 20);
        tfStraal.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        e.consume();
                    }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                r = Double.parseDouble(tfStraal.getText());
                opp = (4*pi)*pow(r,2);
                inhoud = 0.75*pi*pow(r,3);
                tfOppervlakte.setText(Math.round(opp*100)/100D+" cm2");
                tfInhoud.setText(Math.round(inhoud*100)/100D+" ");
            }
        });
        tfInhoud = new JTextField(10);
        tfInhoud.setBorder(null);
        tfInhoud.setEditable(false);
        tfInhoud.setBounds(637, 337, 96, 20);

        tfOppervlakte = new JTextField(10);
        tfOppervlakte.setBorder(null);
        tfOppervlakte.setEditable(false);
        tfOppervlakte.setBounds(637, 380, 96, 20);

        lbStraal = new JLabel("Straal");
        lbStraal.setForeground(Color.WHITE);
        lbStraal.setBounds(516, 292, 48, 14);

        lbOppervlakte = new JLabel("Oppervlakte");
        lbOppervlakte.setForeground(Color.WHITE);
        lbOppervlakte.setBounds(516, 383, 78, 14);


        lbInhoud = new JLabel("Inhoud");
        lbInhoud.setForeground(Color.WHITE);
        lbInhoud.setBounds(516, 340, 70, 14);


        btClear = new JButton("Clear");
        btClear.setBounds(644, 427, 89, 23);
        btClear.setBorder(null);
        btClear.setBackground(yel);
        btClear.addActionListener(new ClearListener());

        btHelp = new JButton("Help");
        btHelp.setBorder(null);
        btHelp.setBackground(yel);
        btHelp.setBounds(516, 427, 89, 23);
        btHelp.addActionListener(new HelpListener());

        add(lbImage);
        add(tfStraal);
        add(tfInhoud);
        add(tfOppervlakte);
        add(lbStraal);
        add(lbInhoud);
        add(lbOppervlakte);
        add(btClear);
        add(btHelp);
    }
    class ClearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            tfStraal.setText(null);
            tfInhoud.setText(null);
            tfOppervlakte.setText(null);

        }
    }
    class HelpListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Vul de straal in om te berekenen!");
        }
    }
}
