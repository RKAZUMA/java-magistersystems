/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase8.gui;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Julian
 */
public class CLFrame extends Frame implements MouseListener{

    public CLFrame(String title) throws HeadlessException {
        super(title);
        setLayout(new CardLayout());
        Button b1 = new Button("primero");
        b1.addMouseListener(this);
        Button b2 = new Button("último");
        b2.addMouseListener(this);
        
        add(b1);
        add(b2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Button b = (Button)(e.getSource());
        CardLayout cl = (CardLayout)(getLayout());
        switch(b.getLabel()){
            case "primero":
                cl.last(this);
                break;
            case "último":
                cl.first(this);
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
