/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.apuntadores;

/**
 *
 * @author Julian
 */
public interface ILista {
    public void invertir();
    public void reiniciar();
    public void eliminarTodasCoincidencias(Nodo n);
    public void eliminarPrimeraCoincidencia(Nodo n);
    public int longitud();
    //...
}
