/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.listas;

/**
 *
 * @author Julian
 */
public class Pila extends MiArregloInt{
    
    public Pila(){
        super();
    }
    
    public Pila(int[] arr){
        super(arr);
    }

    @Override
    public void insertar(int item) {
        if(!(items>100)){
            arreglo[items] = item;
            items++;
        }
    }

    @Override
    public void eliminar() {
        if(items>0){
            //arreglo[items] = 0;
            items--;
        }
    }

    @Override
    public void eliminarPrimeraCoincidencia(int item) {
        super.eliminarPrimeraCoincidencia(item); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarTodasCoincidencias(int item) {
        super.eliminarTodasCoincidencias(item); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarEn(int pos) {
        super.eliminarEn(pos); //To change body of generated methods, choose Tools | Templates.
    }
    
}
