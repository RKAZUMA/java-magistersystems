/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase7.conexion;

/**
 *
 * @author Julian
 */
public class Ejercicio {
    
    public static void main(String[] args) throws Exception {
        
        Conexion dao = new Conexion();
        dao.leerDB("root","root");
        
    }
}
