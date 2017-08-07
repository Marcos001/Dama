package util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nig on 19/07/17.
 */
public class Util {

    public ImageIcon redimensionar_icone(String path_img, int size_x, int size_y){

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("../"+path_img)); // load the image to a imageIcon

        Image image = imageIcon.getImage(); // transform it

        Image newimg = image.getScaledInstance(size_x, size_y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        ImageIcon img_icone = new ImageIcon(newimg);  // transform it back

        return img_icone;
    }

}
