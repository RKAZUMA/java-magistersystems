/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase9.gui_conectada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Julian
 */
public class Conexion {

    private Connection conexion = null;
    private Statement sentencia = null;
    private PreparedStatement sentenciaPreparada = null;
    private ResultSet setResultado = null;
    
    public void conectar(String database, String user, String password) throws ClassNotFoundException, SQLException{
       Class.forName("com.mysql.jdbc.Driver");
       conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+database, user, password);
    }
    
    public ResultSet ejecutarPeticion(String tabla) throws SQLException{
        if(sentencia == null){
            sentencia = conexion.createStatement();
        }
        if(sentencia.execute("SELECT * FROM "+tabla)){
            return sentencia.getResultSet();
        }
        return null;
    }
    
    public int ejecutarInsercion(String tabla, Object[] valores) throws SQLException{
        String sql = "insert into " + tabla + " values (";
        for(int i=0; i<valores.length; i++){
           sql += "?";
           if(i!=valores.length-1){
               sql += ",";
           }
        }
        sql += ")";
        if(sentenciaPreparada == null){
            sentenciaPreparada = conexion.prepareStatement(sql);
        }
        for(int i=0; i<valores.length; i++){
            sentenciaPreparada.setObject(i+1, valores[i]);
        }
        return sentenciaPreparada.executeUpdate();
    }
    
    public int ejecutarEliminacion(String tabla, int[] indices) throws SQLException{
        String sql = "delete from " + tabla + " where (id = ";
        for(int i=0; i<indices.length; i++){
           sql += "?)";
           if(i!=indices.length-1){
               sql += " or (id = ";
           }
        }
        if(sentenciaPreparada == null){
            sentenciaPreparada = conexion.prepareStatement(sql);
        }
        for(int i=0; i<indices.length; i++){
            sentenciaPreparada.setInt(i+1, indices[i]);
        }
        return sentenciaPreparada.executeUpdate();
    }

    // You need to close the resultSet
    public void close() {
        try {
            if (setResultado != null) {
                setResultado.close();
            }

            if (sentencia != null) {
                sentencia.close();
            }

            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
