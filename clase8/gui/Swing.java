/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase8.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julian
 */
public class Swing {
    
    public static void main(String args[]){
        /**
         * Swing
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    

    private static void createAndShowGUI() {
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana = new JFrame("Prueba de un frame");
        ventana.setVisible(true);
        ventana.setSize(400, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.setLayout(new GridLayout(2, 0, 10, 10));
        final JLabel miLabel = new JLabel("Un label");
        
        ventana.add(miLabel);
        
        final JList<String> miLista = new JList<>(new String[]{"Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez"});
        
        ventana.add(miLista);
        
        miLista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                cambiarDesdeLista(miLista, miLabel);
            }
        });
        
        final JButton btn = new JButton("mi botón");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarDesdeBoton(btn, miLabel);
            }
        });
        
        btn.setSize(10, 10);
        ventana.add(btn);
        
        final JComboBox<String> combo = new JComboBox(new String[]{"uno", "dos", "tres"});
        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarDesdeCombo(combo, miLabel);
            }
        });
        
        ventana.add(combo);
        
        final JSlider slider = new JSlider(JSlider.HORIZONTAL, -20, 30, 5);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider s = (JSlider)(e.getSource());
                miLabel.setText(String.valueOf(s.getValue()));
            }
        });
        
        ventana.add(slider);


        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("col1");
        modelo.addColumn("col2");
        modelo.addColumn("col3");
        modelo.addColumn("col4");
        modelo.addRow(new String[]{"A1", "B1", "C1", "D1"});
        modelo.addRow(new String[]{"A2", "B2", "C2", "D2"});
        modelo.addRow(new String[]{"A3", "B3", "C3", "D3"});
        modelo.addRow(new String[]{"A4", "B4", "C4", "D4"});
        JTable tabla = new JTable(modelo);

        JScrollPane scrollpane = new JScrollPane(tabla);

        ventana.add(scrollpane);


        modelo.setValueAt("Nuevo", 1, 2);
    }

    public static void cambiarDesdeLista(JList miLista, JLabel miLabel) {
        String s = "";
        //*/
        int min = miLista.getMinSelectionIndex();
        int max = miLista.getMaxSelectionIndex();
        for (int i = min; i <= max; i++) {
            if (miLista.isSelectedIndex(i)) {
                s += "(" + i + ")";
            }
        }
        /*/
        int[] indices = miLista.getSelectedIndices();
        for(int i = 0; i<indices.length; i++){
            s += "("+i+")";
        }
        //*/
        miLabel.setText(s);

    }
    
    public static void cambiarDesdeBoton(JButton miBoton, JLabel miLabel){
        miLabel.setText(miBoton.getText());
    }
    
    public static void cambiarDesdeCombo(JComboBox miCombo, JLabel miLabel){
        miLabel.setText(miCombo.getItemAt(miCombo.getSelectedIndex()).toString());
    }
}
