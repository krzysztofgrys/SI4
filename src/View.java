import Models.ExtractedImage;
import Models.Neighbours;
import com.sun.javafx.geom.Vec4f;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Created by krzysztofgrys on 5/28/17.
 */
public class View extends JFrame {
    private JPanel mainPanel;
    private JPanel panel;
    private JPanel imgPa1;
    private JPanel imgPa2;
    private ArrayList<Vec4f> lines;

    public View(String pathImg1, String pathImg2) {
        super("Podobnienstwo obrazow");
        lines = new ArrayList<>();
        setPreferredSize(new Dimension(1600, 600));
        setContentPane(mainPanel);

        JLabel img1L = new JLabel("", new ImageIcon(pathImg1), JLabel.CENTER);
        JLabel img2L = new JLabel("", new ImageIcon(pathImg2), JLabel.CENTER);

        imgPa1.add(img1L);
        imgPa2.add(img2L);

        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println(e.getX()+" "+e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        mainPanel.add(panel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void drawNearest(ArrayList<ExtractedImage> extractedImages){
        for(int i=0;i<extractedImages.size();i++){
            Neighbours neighbour =  extractedImages.get(i).getNeighbour();
            float x1 = extractedImages.get(i).getX();
            float y1 = extractedImages.get(i).getY();
            float x2 = neighbour.getX();
            float y2 = neighbour.getY();
            lines.add(new Vec4f(x1,y1,x2+808,y2));
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0;i<lines.size();i++){
            Line2D line2D = new Line2D.Float(lines.get(i).x,lines.get(i).y, lines.get(i).z, lines.get(i).w);
            g2.draw(line2D);
        }

    }


}
