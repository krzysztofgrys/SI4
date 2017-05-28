package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by krzysztofgrys on 5/28/17.
 */
public class Panel extends JPanel {

    private JPanel imgPa1;
    private JPanel imgPa2;


    public Panel(JPanel img1, JPanel img2, String pathImg1, String pathImg2){

        JLabel img1L = new JLabel("", new ImageIcon(pathImg1), JLabel.CENTER);
        JLabel img2L = new JLabel("", new ImageIcon(pathImg2), JLabel.CENTER);
        this.imgPa1 = img1;
        this.imgPa2 = img2;

        imgPa1.add(img1L);
        imgPa2.add(img2L);
        setVisible(true);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


            g2.setBackground(Color.orange);
            g2.setPaint(Color.orange);
            g.fillRect(0, 0, getWidth(), getHeight());

    }
}
