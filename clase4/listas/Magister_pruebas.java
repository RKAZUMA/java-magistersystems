/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.listas;

/**
 *
 * @author Julian
 */
public class Magister_pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MiArregloInt arreglo = new MiArregloInt();
        arreglo.insertar(15,0);
        arreglo.insertar(25,1);
        arreglo.insertar(35,2);
        arreglo.insertar(32,3);
        arreglo.insertar(51,4);
        arreglo.insertar(12,2);
        System.out.println(arreglo.toString());
        Pila miPila = new Pila();
        Cola miCola = new Cola();
        System.out.println("Pila: "+miPila.toString()+" | Cola: "+miCola.toString());
        miPila.insertar(1);
        miPila.insertar(2);
        miPila.insertar(3);
        miPila.insertar(2);
        miPila.insertar(4);
        miPila.insertar(2);
        miPila.insertar(5);
        miPila.insertar(2);
        System.out.println("Pila: "+miPila.toString());
        miPila.eliminarTodasCoincidencias(2);
        miPila.eliminarPrimeraCoincidencia(3);
        System.out.println("Pila: "+miPila.toString());
        miPila.eliminar();
        System.out.println("Pila: "+miPila.toString());
        miCola.insertar(1);
        miCola.insertar(2);
        miCola.insertar(3);
        miCola.insertar(4);
        miCola.insertar(5);
        System.out.println("Cola: "+miCola.toString());
        miCola.eliminar();
        System.out.println("Cola: "+miCola.toString());
        /*
        MiArregloInt miArreglo = new MiArregloInt(new int[]{1,2,3,4,5,6});
        /*/
        MiArregloInt miArreglo = (MiArregloInt)miCola;
        //*/
        System.out.println("Arreglo: "+miArreglo.toString());
        miArreglo.insertar(1);
        System.out.println("Arreglo: "+miArreglo.toString());
    }
    
}
