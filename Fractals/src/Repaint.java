import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Repaint {
    public JPanel paint(BufferedImage image) {
        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                int newW = (int) (image.getWidth());
                int newH = (int) (image.getHeight());
                this.setPreferredSize(new Dimension(newW, newH));
                this.revalidate();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
                g2.drawImage(image, 0, 0, newW, newH, null);
            }
        };
        return pane;
    }
}
