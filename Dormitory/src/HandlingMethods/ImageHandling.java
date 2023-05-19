package HandlingMethods;
import java.awt.*;
import javax.swing.*;
public class ImageHandling {
    public static ImageIcon imgIconAuto(ImageIcon In,int width,int height){
        Image newimg,image;
        image = In.getImage();
        newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }


}
