import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageTask {
    public static void findImg(File root) throws IOException {
        String extOne = "jpg";
        String extTwo = "bmp";
        File[] images = root.listFiles();
        try {
            if (images != null) {
                for (File file : images) {
                    if (file.isDirectory()) {
                        findImg(file);
                    }
                    else if (file.isFile() && file.getName().endsWith(extOne)) {
                        BufferedImage img = ImageIO.read(file);
                        Graphics2D g = img.createGraphics();

                        // задать цвет фона
                        g.setColor(Color.BLACK);

                        // заполнить фон:
                        g.fillRect(0,0,img.getWidth(),img.getHeight());

                        // нарисовать квадрат:
                        int w = 300, h = 300; // размеры квадрата
                        g.setColor(Color.BLUE);
                        g.drawRect(img.getWidth()/2-w/2, img.getHeight()/2-h/2, w, h);

                        // Напишем текст
                        g.setColor(Color.GREEN);
                        g.drawString("Hello,", img.getWidth()/2, img.getHeight()/2);
                        g.drawString("World!",img.getWidth()/2, (img.getHeight()/2)+20);
                        g.dispose(); // освобождаем холст

                        // записываем итоговое изображение в новый конвертированный файл
                        String imgName = file.getName().substring(0, file.getName().lastIndexOf('.'));
                        ImageIO.write(img, extTwo, new File(imgName + "." + extTwo));
                    }
                }
            }
        } catch (IOException  | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File root = new File(".");
        findImg(root);
    }
}
