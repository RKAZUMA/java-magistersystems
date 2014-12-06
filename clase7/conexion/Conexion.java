/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase7.conexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    

    public void leerDB(String user, String password) throws Exception {
        try {
            // Cargar el driver MySQL, cada BD tiene uno propio
            // ConnectorJ
            Class.forName("com.mysql.jdbc.Driver");
            // Abrir la conexión
            //connect = DriverManager.getConnection("jdbc:mysql://localhost/magister?user=julian&password=javasql");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/", user, password);

            // Statement son peticiones o sentencias
            sentencia = conexion.createStatement();
            sentencia.execute("use magister");
            // Se guarda el resultado luego de ejecutar la consulta
            System.out.println("Lo que la up retorna: " + sentencia.executeUpdate("create or replace view view_users_30_bikes as "
                    + "select u.*, b.id as id_b, b.brand, b.price, b.owner from users as u, bikes as b "
                    + "where b.owner = u.id "
                    + "and u.age > 30;"));
            //setResultado = sentencia.executeQuery("SELECT * FROM users");
//                writeResultSet(setResultado);
//                writeMetaData(setResultado);
            if (sentencia.execute("select u.*, b.id as id_b, b.brand, b.price, b.owner from users as u, bikes as b "
                    + "where b.owner = u.id "
                    + "and u.age > 30;")) {
                setResultado = sentencia.getResultSet();
                writeResultSet(setResultado);
                writeMetaData(setResultado);
            }

            // PreparedStatements son sentencias preparadas, más eficientes y con uso de variables
            sentenciaPreparada = conexion.prepareStatement("insert into bikes (brand, price, owner) values "
                    + "(?, ?, ?),"
                    + "(?, ?, ?),"
                    + "(?, ?, ?),"
                    + "(?, ?, ?)");

            String arr[] = new String[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = String.format("Marca: %d", i);
            }
            for (int i = 0; i < 4; i++) {
                sentenciaPreparada.setString(i * 3 + 1, arr[(int) (Math.random() * 20)]);
                sentenciaPreparada.setInt(i * 3 + 2, (int) (Math.random() * 1000) + 1);
                sentenciaPreparada.setInt(i * 3 + 3, (int) (Math.random() * 17) + 1);
            }
            System.out.println("Cantidad de filas sp modificó: " + sentenciaPreparada.executeUpdate());

            //*/

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {

        System.out.print("METADATA: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(6));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.print("-Column(" + i + "): " + resultSet.getMetaData().getColumnName(i));
            System.out.println(" type: " + resultSet.getMetaData().getColumnTypeName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String username = resultSet.getString("username");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            System.out.println("Id: " + id + "\tUsername: " + username + "\tName: " + name + "\tAge: " + age);
        }
    }

    // You need to close the resultSet
    private void close() {
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
