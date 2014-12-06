/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase6.excepciones;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Julian
 */
public class Main {
    
    public static void main(String[] args){
        /**
         * COMPLEMENTOS
         * ArrayList, Vector y Stack
         */
        
        //ArrayList es la evolución de Vector, el cual está
        //fuera de producción desde la versión 1.2
        Vector vector = new Vector();
        vector.add(new Integer(20));
        vector.add(new Float(20.3));
        vector.add(new Double(34));
        vector.add(new String("Cadena"));
        System.out.println(vector);
        
        Stack stack = new Stack();
        stack.push(new Integer(1));
        System.out.println(stack);
        stack.push(new Float(2.0));
        
        System.out.println(stack);
        stack.push(new String("Tres"));
        
        System.out.println(stack);
        System.out.println("Salió: "+stack.pop());
        System.out.println(stack);
        System.out.println("Salió: "+stack.pop());
        System.out.println(stack);
        System.out.println("Salió: "+stack.pop());
        System.out.println(stack);
        try{
            System.out.println("Salió: "+stack.pop());
        }catch(EmptyStackException e){
            System.out.println("No salen más.");
        }finally{
            System.out.println(stack);
        }
        
        /**
         * EXCEPCIONES
         * Creación y manejo de excepciones.
         */
        
        try{
            int arr[] = new int[2];
            System.out.println("Accesando al elemento arr[3]:" + arr[3]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException lanzada: " + e);
            e.printStackTrace(System.out);
        }finally{
            System.out.println("Y este bloque siempre se ejecuta.");
        }
        
        Main ejercicio = new Main();
        try{
            ejercicio.miMetodo();
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
        }
        
        Persona persona1 = new Persona();
        try{
            persona1.setEdad(10);
            persona1.setNombre("Andres Perea");
        }catch(NombreInvalidoException n){
            System.out.println(n.getMessage());
            n.printStackTrace(System.out);
        }catch(EdadInvalidaException e){
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }finally{
            System.out.println(persona1.toString());
        }
        
        /**
         * RECURSIVIDAD
         * Métodos que se llaman a sí mismos
         */
        
        int dato = 10;
        System.out.println("fact("+dato+"):"+ejercicio.factorial(dato));
        
        ejercicio.imprimir();
        ejercicio.ordenar(vec, vec.length);
        ejercicio.imprimir();
        
        /**
         * MAPAS
         * Diccionario de datos con una llave y un valor
         */
        
        Map mapa = new HashMap();
        mapa.put('c', 12850);
        mapa.put(38.6, 386540);
        mapa.put("Andrés", 238761);
        mapa.put(14, "Valor de 14");
        mapa.put("p1", persona1);
        mapa.put("Andrea", 34500);
        
        
        
        System.out.println(mapa.toString());
        
        Set setmapa = mapa.entrySet();
        Iterator i = setmapa.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        int balanceAndrea = (int)mapa.get("Andrea");
        mapa.put("Andrea", balanceAndrea+5000);
        i = setmapa.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        
        //http://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-sortedmap-in-java
        
    }
    
    void miMetodo() throws MiExcepcion{
        throw new MiExcepcion("Excepción desde método");
    }
    
    int factorial(int n) {
        if (n>0) {
            int valor=n * factorial(n-1);
            return valor;
        } else
            return 1;
    }
    
    static int [] vec = {312, 614, 88, 22, 54};

    void ordenar (int [] v, int cant) {
        if (cant > 1) {
            for (int f = 0 ; f < cant - 1 ; f++)
                if (v [f] > v [f + 1]) {
                    int aux = v [f];
                    v [f] = v [f + 1];
                    v [f + 1] = aux;
                }
            ordenar (v, cant - 1);
        }
    }

    void imprimir () {
        for (int f = 0 ; f < vec.length ; f++)
            System.out.print (vec [f] + "  ");
        System.out.println("\n");
    }

}
