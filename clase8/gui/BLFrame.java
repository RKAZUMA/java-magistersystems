/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase8.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;

/**
 *
 * @author Julian
 */
public class BLFrame extends Frame{

    public BLFrame(String title) throws HeadlessException {
        super(title);
        Button b1 = new Button("B1");
        Button b2 = new Button("B2");
        Button b3 = new Button("B3");
        Button b4 = new Button("B4");
        Button b5 = new Button("B5");
        
        setLayout(new BorderLayout());
        
//        add(b1, BorderLayout.PAGE_START);
//        add(b2, BorderLayout.LINE_START);
//        add(b3, BorderLayout.CENTER);
//        add(b4, BorderLayout.LINE_END);
//        add(b5, BorderLayout.PAGE_END);
        
        add(b1, BorderLayout.NORTH);
//        add(b2, BorderLayout.WEST);
//        add(b3, BorderLayout.CENTER);
//        add(b4, BorderLayout.EAST);
//        add(b5, BorderLayout.SOUTH);
    }
    
}
