/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase8.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;
import javax.swing.BoxLayout;

/**
 *
 * @author Julian
 */
public class BxLFrame extends Frame {

    public BxLFrame(String title) throws HeadlessException {
        super(title);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        add(new Button("b1"));
        add(new Button("b2"));
        add(new Button("b3"));
    }
}
