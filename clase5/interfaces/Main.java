/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase5.interfaces;

/**
 *
 * @author Julian
 */
public class Main {
    public static void main(String args[]){
        Animal jeff = new Cocodrilo();
        Animal luke = new Perro();
        Perro goofy = new Perro();
        //Animal john = new Animal();
        jeff.nacer();
        luke.nacer();
        ((Cocodrilo)jeff).incubar();
        //((Cocodrilo)luke).incubar();
        goofy.amamantar();
        ((Perro)luke).mamar();
    }
}
