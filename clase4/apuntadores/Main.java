/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.apuntadores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Julian
 */
public class Main {
    public static void main(String[] args){
        Lista lista = new Lista();
        //*
        lista.agregar(new Nodo(0));
        lista.agregar(new Nodo(1));
        lista.agregar(new Nodo(2));
        lista.agregar(new Nodo(3));
        lista.agregar(new Nodo(4));
        lista.agregar(new Nodo(5));
        lista.agregar(new Nodo(6));
        lista.agregar(new Nodo(7));
        lista.agregar(new Nodo(8));
        lista.eliminarEn(5);
        //*/
        System.out.print(lista.toString());
        try{
            //lista.longitud();
            lista.invertir();
        }catch(MiExcepcion e){
            System.out.println("\n"+e.getMessage());
        }
    }
}
