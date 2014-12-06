/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.apuntadores;

/**
 *
 * @author Julian
 */
public class Pila extends Lista{

    @Override
    public void agregar(Nodo n) {
        super.agregarEn(n,cont-1); 
    }

    @Override
    public void agregarEn(Nodo n, int pos) {
        super.agregarEn(n,cont-1);
    }

    @Override
    public void eliminar(){
        super.eliminarEn(cont-1);
    }

    @Override
    public void eliminarEn(int pos) {
        super.eliminarEn(cont-1);
    }
    
}
