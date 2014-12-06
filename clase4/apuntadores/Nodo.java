/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.apuntadores;

/**
 *
 * @author Julian
 */
public class Nodo {
    int dato;
    Nodo sig;
    
    public Nodo(){
        dato = 0;
        sig = null;
    }
    
    public Nodo(int dato){
        this.dato = dato;
        sig = null;
    }
    
    @Override
    public String toString(){
        return ("{nodo:"+dato+"}");
    }
}
