/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.listas;

/**
 *
 * @author Julian
 */
public interface ArregloInt {
    public void insertar(int item);
    public void eliminar();
    public void eliminarPrimeraCoincidencia(int item);
    public void eliminarTodasCoincidencias(int item);
    public void eliminarEn(int pos);
}
