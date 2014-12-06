/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.apuntadores;

/**
 *
 * @author Julian
 */
public class Lista implements ILista{
    Nodo lista;
    int cont;
    
    public void Lista(){
        lista = null;
        cont = 0;
    }
    
    @Override
    public String toString(){
        String sLista = "{lista:[\n";
        Nodo iNodo = lista;
        for(int i=0; i<cont; i++){
            sLista += "\t" + iNodo.toString();
            iNodo = iNodo.sig;
            if(i!=cont-1){
                sLista += ",\n";
            }
        }
        sLista += "\n]}";
        return sLista;
    }
    
    public void agregar(Nodo n){
        if(cont == 0){
            lista = n;
        } else {
            Nodo i = lista;
            while (i.sig!=null){
                i = i.sig;
            }
            i.sig = n;
        }
        cont++;
    }
    
    public void agregarEn(Nodo n, int pos){
        if(pos < cont && pos >= 0){
            if(pos > 0){
                Nodo aux = lista;
                while(--pos > 0){
                    aux = aux.sig;
                }
                n.sig = aux.sig;
                aux.sig = n;
            } else {
                n.sig = lista;
                lista = n;
            }
            cont++;
        } else {
            agregar(n);
        }
    }
    
    public void eliminar(){
        if(cont > 0){
            lista = lista.sig;
            cont--;
        }
    }
    
    public void eliminarEn(int pos){
        if(pos < cont && pos >= 0){
            if(pos > 0){
                Nodo aux = lista;
                while(--pos > 0){
                    aux = aux.sig;
                }
                aux.sig = aux.sig.sig;                   
            } else {
                lista = lista.sig;     
            }
            cont--;
        }
    }

    @Override
    public void invertir() {
        throw new MiExcepcion("Esta es mi excepcion");
    }

    @Override
    public void reiniciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarTodasCoincidencias(Nodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPrimeraCoincidencia(Nodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int longitud() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
