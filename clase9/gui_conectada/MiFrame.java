/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase9.gui_conectada;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 *
 * @author Julian
 */
public class MiFrame extends JFrame{

    public MiFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}
