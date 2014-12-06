/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.listas;

/**
 *
 * @author Julian
 */
public class Cola extends MiArregloInt{

    public Cola() {
    }

    public Cola(int[] arr) {
        super(arr);
    }

    @Override
    public void insertar(int item) {
        if(!(items > 100)){
            arreglo[items] = item;
            items++;
        }
    }

    @Override
    public void eliminar() {
//        if(items > 0){
//            for(int i=0; i<items-1; i++){
//                arreglo[i] = arreglo[i+1];
//            }
//            items--;
//        }
        eliminarEn(0);
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
