/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase5.arraylists;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Julian
 */
public class Main {
    public static void main(String args[]){
        ArrayList miLista = new ArrayList();
        ArrayList miLista2 = new ArrayList();
        miLista2.add("Esta");
        miLista2.add("Es");
        miLista2.add("La");
        miLista2.add("Lista");
        miLista2.add(2);
        //*
        miLista.add("Hola");
        miLista.add("Amigo");
        miLista.add("Mio");
        miLista.add("Esto");
        miLista.add("Es");
        miLista.add("Una");
        miLista.add("Lista");
        miLista.add(34);
        miLista.add(true);
        miLista.add(miLista2);
        System.out.println(miLista.toString());
        //*/
        
        Iterator i = miLista.iterator();
        int pos = 0;
        while(i.hasNext()){
            Object obj = i.next();
            Class cla = obj.getClass();
            String nomCla = cla.getSimpleName();
            System.out.println("elemento["+pos+"]:"+obj.toString()+"     \tclase:"+nomCla);
            pos++;
        }
        
//        try {
//            Runtime.getRuntime().exec("cls/clear");
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//            ex.printStackTrace();
//        }
        
        try{
            Object obj = miLista.get(15);
        }catch(Exception e){
            e.printStackTrace(System.out);
            System.out.println(e.getMessage());
        }
        
    }
}
