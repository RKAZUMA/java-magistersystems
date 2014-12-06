/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase9.gui_conectada;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julian
 */
public class Main{
    
    static MiFrame ventanaInicioSesion, ventanaTodo;
    static Conexion conector;
    static String db, usuario, pass;
    static Timer timerLog;
    
    static JButton refrescar = new JButton("Refrescar");
    static JButton eliminarSeleccion = new JButton("Eliminar Selección");
    static JButton agregar = new JButton("Agregar");
    static JButton cerrarSesion = new JButton("Cerrar Sesión");
    static JTable usersTable = new JTable();
    static JLabel lUsername = new JLabel("Username");
    static JLabel lName = new JLabel("Name");
    static JLabel lAge = new JLabel("Age");
    static JTextField username = new JTextField();
    static JTextField name = new JTextField();
    static JTextField age = new JTextField();
    static JLabel log = new JLabel("...");
    
    public static void main(String []args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                actualizarLog();
            }
        });
    }
    
    private static void actualizarLog(){
        timerLog = new Timer(3000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                log.setText("...");
            }
        });
        timerLog.start();
    }
    
    private static void cerrarTodo(){
        ventanaInicioSesion.dispose();
        ventanaTodo.dispose();
        conector.close();
    }
    
    private static void createAndShowGUI() {
        conector = new Conexion();
        ventanaInicioSesion();
    }
    
    public static void ventanaInicioSesion(){
        ventanaInicioSesion = new MiFrame("Base de datos MS");
        
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridLayout(4,2));
        
        JLabel lDB = new JLabel("Base de Datos");
        JLabel lUsuario = new JLabel("Usuario");
        JLabel lPass = new JLabel("Contraseña");
        JButton boton = new JButton("Conectar");
        final JLabel log = new JLabel("Ingrese los datos");
        log.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        
        final JTextField tfDb = new JTextField();
        final JTextField tfUsuario = new JTextField();
        final JPasswordField tfPass = new JPasswordField();
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db = tfDb.getText();
                usuario = tfUsuario.getText();
                pass = tfPass.getText();
                try{
                    conector.conectar(db, usuario, pass);
                    log.setText("Conexión exitosa...");
                    inicioDeSesionCorrecta();
                }catch(ClassNotFoundException cnfe){
                    log.setText("El conector a la DB no está cargado.");
                    cnfe.printStackTrace(System.out);
                }catch(SQLException sqle){
                    log.setText("Error en los datos.");
                    sqle.printStackTrace(System.out);
                    conector.close();
                }
            }
        });
        
        contenedor.add(lDB);
        contenedor.add(tfDb);
        contenedor.add(lUsuario);
        contenedor.add(tfUsuario);
        contenedor.add(lPass);
        contenedor.add(tfPass);
        contenedor.add(boton);
        contenedor.add(log);
        
        contenedor.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        ventanaInicioSesion.add(contenedor);
        
        ventanaInicioSesion.setSize(300, 150);
        ventanaInicioSesion.setLocation(200, 200);
        ventanaInicioSesion.setVisible(true);
        
        //*/
        tfDb.setText("magister");
        tfUsuario.setText("julian");
        tfPass.setText("javasql");
        //*/
    }
    
    private static void inicioDeSesionCorrecta(){
        //Ocultar anterior ventana
        ventanaInicioSesion.setVisible(false);
        
        //GUI nueva ventana
        ventanaTodo = new MiFrame("Base de Datos Accesada");
        
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        JPanel contenedor1 = new JPanel();
        contenedor1.setLayout(new BoxLayout(contenedor1, BoxLayout.LINE_AXIS));
        contenedor.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel contenedor2 = new JPanel();
        contenedor2.setLayout(new BoxLayout(contenedor2, BoxLayout.LINE_AXIS));
        JPanel contenedor3 = new JPanel();
        contenedor3.setLayout(new GridLayout(2, 3, 3, 3));
        
        JScrollPane scrollTabla = new JScrollPane(usersTable);
        
        contenedor1.add(refrescar);
        contenedor1.add(eliminarSeleccion);
        contenedor1.add(cerrarSesion);
        
        contenedor3.add(lUsername);
        contenedor3.add(lName);
        contenedor3.add(lAge);
        contenedor3.add(username);
        contenedor3.add(name);
        contenedor3.add(age);
        
        contenedor2.add(contenedor3);
        contenedor2.add(agregar);
        
        contenedor.add(contenedor1);
        contenedor.add(scrollTabla);
        contenedor.add(contenedor2);
        contenedor.add(log);
        
        ventanaTodo.add(contenedor);
        
        ventanaTodo.setSize(800, 600);
        ventanaTodo.setLocation(100, 100);
        ventanaTodo.setVisible(true);
        
        //traer datos
        refrescarTabla();
        
        //configurar escuchadores
        escuchadores();
    }
    
    public static void refrescarTabla(){
        usersTable.setModel(traerModelo());
    }
    
    private static DefaultTableModel traerModelo(){
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSet resultadosUsuarios;
        try {
            resultadosUsuarios = conector.ejecutarPeticion("users");
            
            ResultSetMetaData mdUsuarios = resultadosUsuarios.getMetaData();
            for(int c=0; c<mdUsuarios.getColumnCount(); c++){
                modelo.addColumn(mdUsuarios.getColumnName(c+1));
            }
            
            while(resultadosUsuarios.next()){
                String[] tupla = new String[mdUsuarios.getColumnCount()];
                for(int i=0; i<mdUsuarios.getColumnCount(); i++){
                    tupla[i] = resultadosUsuarios.getObject(i+1).toString();
                }
                modelo.addRow(tupla);
            }
            log.setText("Información traída exitosamente.");
            
        } catch (SQLException ex) {
            log.setText("Hubo un problema con el pedido.");
            ex.printStackTrace(System.out);
        }
        return modelo;
    }
    
    private static void escuchadores(){
        //Botón refrescar
        refrescar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refrescarTabla();
            }
        });
        
        //Botón agregar
        agregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!username.getText().isEmpty() &&
                    !name.getText().isEmpty() &&
                    !age.getText().isEmpty()){
                    try{
                        Integer.valueOf(age.getText());
                        log.setText("Se insertaron exitosamente " +
                        //                                                      id        username           name           age
                                conector.ejecutarInsercion("users", new Object[]{null, username.getText(), name.getText(), age.getText()}) +
                                " filas en la tabla.");
                    }catch(NumberFormatException nfe){
                        log.setText("Edad no válida.");
                        nfe.printStackTrace(System.out);
                    } catch (SQLException ex) {
                        log.setText("Error: "+ex.getMessage());
                    }
                }else{
                    log.setText("Todos los campos deben tener información.");
                }
            }
        });
        
        //Botón eliminar
        eliminarSeleccion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int[] indicesFilasSeleccionadas = usersTable.getSelectedRows();
                if(indicesFilasSeleccionadas.length > 0){
                    for(int r=0; r<indicesFilasSeleccionadas.length; r++){
                        indicesFilasSeleccionadas[r] = Integer.valueOf(
                                (String)usersTable.getModel().getValueAt(indicesFilasSeleccionadas[r], 0));
                    }
                    try {
                        log.setText("Se eliminaron exitosamente " +
                                conector.ejecutarEliminacion("users", indicesFilasSeleccionadas) + " filas de la tabla.");
                    } catch (SQLException ex) {
                        log.setText("Error: "+ex.getMessage());
                    }
                }else{
                    log.setText("Debe seleccionar al menos una tupla.");
                }
            }
        });
        
        //Cerrar Sesión
        cerrarSesion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarTodo();
                createAndShowGUI();
            }
        });
    }
}
