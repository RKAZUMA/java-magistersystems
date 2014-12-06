/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase8.gui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian
 */
public class MiFrame extends Frame implements ActionListener{
    
    
    Button miBoton;
    TextArea miAreaTexto;
    Label etiqueta;
    Scrollbar scrollbar;
    Menu menu;
    

    public MiFrame(String title) throws HeadlessException {
        super(title);
        
        //setLayout(new GridLayout(2,1));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        miBoton = new Button("Hola Mundo");
        //miBoton.setBounds(100, 100, 100, 40);
        
        miBoton.addActionListener(this);
        miBoton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botón Pulsado 2");
            }
            
        });
        
        add(miBoton);
        
        miAreaTexto = new TextArea("",1,1,TextArea.SCROLLBARS_BOTH);
        for( int i=0; i < 10; i++ ){
            miAreaTexto.append("linea "+i+"\n" );
        }
        //miAreaTexto.setBounds(100, 140, 200, 100);
        add(miAreaTexto);
        
        scrollbar = new Scrollbar(Scrollbar.HORIZONTAL);
        //scrollbar.setBounds(50, 70, 20, 200);
        add(scrollbar);
        
        etiqueta = new Label("Mi etiqueta");
        etiqueta.setBounds(70, 120, 100, 50);
        add(etiqueta);
        
        menu = new Menu("mi menú");
        MenuItem mi = new MenuItem("subitem0");
        mi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Menú Pulsado");
            }
        });
        menu.add(mi);
        menu.add(new MenuItem("subitem1"));
        menu.add(new CheckboxMenuItem("Checkbox menu item"));
        menu.add(new CheckboxMenuItem("prendido", true));
        
        Menu menu2 = new Menu("Otro Menú");
        menu2.add(new MenuItem("subitem01"));
        menu2.add(new MenuItem("subitem02"));
        menu2.add(new MenuItem("subitem03"));
        menu2.add(new MenuItem("subitem04"));
        
        menu.add(menu2);
        
        MenuBar menuBar = new MenuBar();
        menuBar.add(menu);
        
        setMenuBar(menuBar);
        
        CheckboxGroup cbg = new CheckboxGroup();
        add(new Checkbox("item1 grupo", cbg, false));
        add(new Checkbox("item2 grupo", cbg, false));
        add(new Checkbox("item3 grupo", cbg, false));
        add(new Checkbox("item4 grupo", cbg, false));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Botón Pulsado");
    }
}
