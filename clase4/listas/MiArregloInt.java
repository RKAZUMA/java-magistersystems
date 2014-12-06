/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.listas;

/**
 *
 * @author Julian
 */
public class MiArregloInt implements ArregloInt{
    int[] arreglo;
    int items;
    
    public MiArregloInt(){
        arreglo = new int[100];
        items = 0;
    }
    public MiArregloInt(int[] arr){
        arreglo = new int[100];
        for(items=0; items<100 && items<arr.length-1; items++){
            arreglo[items] = arr[items];
        }
    }
    
    @Override
    public String toString(){
        String respuesta = "{";
        for(int i=0; i<items; i++){
            respuesta += String.valueOf(arreglo[i]);
            if(i != items-1){
                respuesta += ",";
            }
        }
        respuesta += "}";
        return respuesta;
    }
    
    public void insertar(int item, int pos){
        if(pos < arreglo.length && pos >= 0){
            if(pos < items){
                for(int i=items; i>pos; i--){
                    arreglo[i] = arreglo[i-1];
                }
                arreglo[pos] = item;
            } else {
                arreglo[items] = item;
            }
            items++;
        }
    }

    @Override
    public void insertar(int item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPrimeraCoincidencia(int item) {
        if(items>0){
            for(int i=0; i<items; i++){
                if(arreglo[i] == item){
                    eliminarEn(i);
                    break;
                }
            }
        }
    }

    @Override
    public void eliminarTodasCoincidencias(int item) {
        if(items>0){
            for(int i=0; i<items; i++){
                if(arreglo[i] == item){
                    eliminarEn(i);
                }
            }
        }
    }

    @Override
    public void eliminarEn(int pos) {
        if(items>0 && pos<=items){
            for(int i=pos; i<items-1; i++){
                arreglo[i] = arreglo[i+1];
            }
            items--;
        }
    }
}
