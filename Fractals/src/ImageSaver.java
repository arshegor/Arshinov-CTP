import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.IOException;

    public class ImageSaver {
        public void SaveImage(BufferedImage image,JFrame frame){

            JFileChooser chooser=new JFileChooser() ;
            FileNameExtensionFilter filter=new FileNameExtensionFilter("PNG изображения","png");
            chooser.setFileFilter(filter);
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.showSaveDialog(frame);
            try {
                ImageIO.write(image, "PNG", chooser.getSelectedFile());
            }
            catch(IOException ex){JOptionPane.showMessageDialog(frame ,"Невозможно сохранить файл","Ошибка",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

