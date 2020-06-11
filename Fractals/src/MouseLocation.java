import Fractals.BurningShip;
import Fractals.Mandelbrot;
import Fractals.Tricorn;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class MouseLocation extends JPanel {
    private static int x, y;
    int width = 400, height = 400;


    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);


    public MouseLocation() {

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
                switch (Generator.fr){
                    case 1:{
                        Mandelbrot.mandelbrot(image,width,height);
                        Generator.scaleFactor++;
                        break;}
                    case 2:{
                        Tricorn.THre(image,width,height);
                        Generator.scaleFactor++;
                        break;
                    }
                    case 3:{
                        BurningShip.burningShip(image,width,height);
                        Generator.scaleFactor++;
                        break;
                    }
                }
                JPanel pane = new JPanel() {
                };
            }
        });
    }

    @Override
    public  void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int newW = (int) (image.getWidth() * Generator.scaleFactor);
        int newH = (int) (image.getHeight() * Generator.scaleFactor);
        this.setPreferredSize(new Dimension(newW, newH));
        this.revalidate();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

        g2.drawImage(image, -x, -y, newW, newH, null);
    }
}
