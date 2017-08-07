package MoverJanela;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by ivan on 24/05/16.
 */
public class MoveWindow implements MouseMotionListener {
    Frame window;

    int xMouseOld;
    int yMouseOld;

    public MoveWindow(Frame window){
        this.window = window;

        Point p = new Point();

        p = window.getLocationOnScreen();
        xMouseOld = (int) p.getX();
        yMouseOld = (int) p.getY();
    }


    public void mouseDragged(MouseEvent arg0) {
        Point posicaoNova = new Point(( arg0.getXOnScreen() - xMouseOld ), ( arg0.getYOnScreen() - yMouseOld) );
        window.setLocation(posicaoNova);
    }


    public void mouseMoved(MouseEvent arg0) {
        xMouseOld = arg0.getX();
        yMouseOld = arg0.getY();
    }

}
