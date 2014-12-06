package clase8.gui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julian
 */
public class HolaIte extends JFrame {
    
    public JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    HolaIte frame = new HolaIte();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public HolaIte() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0,0,800,600);
    }
 
    @Override
    public void paint( Graphics g ) {
        super.paint(g);
        
        int fila = 0;
        for (int rojo = 0 ; rojo <= 255 ; rojo++)
        {
            Color col = new Color (rojo, 0, 0);
            g.setColor (col);
            g.drawLine (0, fila, 800, fila);
            fila++;
        }
        
        g.setColor (Color.blue);
        g.drawLine (0, 70, 100, 70);
        g.drawRect (150, 70, 50, 70);
        g.drawRoundRect (250, 70, 50, 70, 6, 6);
        g.drawOval (350, 70, 50, 70);
        int [] vx1 = {500, 550, 450};
        int [] vy1 = {70, 120, 120};
        g.drawPolygon (vx1, vy1, 3);

        g.setColor (Color.red);
        g.fillRect (150, 270, 50, 70);
        g.fillRoundRect (250, 270, 50, 70, 6, 6);
        g.fillOval (350, 270, 50, 70);
        int [] vx2 = {500, 550, 450};
        int [] vy2 = {270, 320, 320};
        g.fillPolygon (vx2, vy2, 3);
        g.setColor (Color.blue);
        g.drawString("Primer linea",10,200);
        g.drawString("Segunda linea",10,300);
    }
}

