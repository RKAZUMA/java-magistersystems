/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase8.gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Julian
 */
public class Ejercicio {

    public static void main(String[] args) {

        /*
         * CERRAR LAS VENTANAS
         */
        WindowAdapter wl = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                //System.exit(0);
                Frame f = (Frame) (we.getSource());
                f.setVisible(false);
            }
        };

        /**
         * AWT
         */
        BLFrame frame1 = new BLFrame("BorderLayout");
        frame1.setSize(200, 300);
        frame1.setVisible(true);
        frame1.addWindowListener(wl);

        BxLFrame frame2 = new BxLFrame("BoxLayout");
        frame2.setSize(200, 300);
        frame2.setVisible(true);
        frame2.addWindowListener(wl);

        CLFrame frame3 = new CLFrame("CardLayout");
        frame3.setSize(200, 300);
        frame3.setVisible(true);
        frame3.addWindowListener(wl);

        MiFrame frame4 = new MiFrame("Título");
        frame4.setSize(400, 600);
        frame4.setVisible(true);

        //Cierra la ventana
        frame4.addWindowListener(wl);

        //*/
    }
}
