/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase5.interfaces;

/**
 *
 * @author Julian
 */
public class Perro implements Mamifero,Vertebrado{

    @Override
    public void amamantar() {
        System.out.println("Perro amamantando");
    }

    @Override
    public void mamar() {
        System.out.println("Perro mamando");
    }

    @Override
    public void nacer() {
        System.out.println("Perro naciendo");
    }

    @Override
    public void morir() {
        System.out.println("Perro muriendo");
    }

    @Override
    public void comer() {
        System.out.println("Perro comiendo");
    }

    @Override
    public void fracturar() {
        System.out.println("Perro fracturándose");
    }

    @Override
    public void artritis() {
        System.out.println("Perro con artritis");
    }

    @Override
    public void incubar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
