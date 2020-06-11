package Fractals;

import java.awt.*;
import java.awt.image.BufferedImage;
public class Tricorn { public Tricorn() {
}

    public static void THre(BufferedImage image, int x1, int y1) {
        int width = x1;
        int height = y1;
        int max = 2000;
        int black = 0;
        int[] colors = new int[max];


        for(int row = 0; row < height; ++row) {
            colors[row] = Color.HSBtoRGB((float)row / 256.0F, 1.0F, (float)row / ((float)row + 8.0F));
            for(int col = 0; col < width; ++col) {
                double c_re = (double)(col - width / 2) * 4.0D / (double)width;
                double c_im = (double)(row - height / 2) * 4.0D / (double)width;
                double x = 0.0D;
                double y = 0.0D;

                int iteration;
                for(iteration = 0; x * x + y * y < 4.0D && iteration < max; ++iteration) {
                    double x_new = x * x - y * y + c_re;
                    y = 2.0D * x *(-y) + c_im;
                    x = x_new;
                }

                if (iteration < max) {
                    image.setRGB(col, row, colors[iteration]);
                } else {
                    image.setRGB(col, row, black);
                }
            }
        }

    }
}

