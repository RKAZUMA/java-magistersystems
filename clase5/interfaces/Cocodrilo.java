/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase5.interfaces;

/**
 *
 * @author Julian
 */
public class Cocodrilo implements Reptil,Vertebrado{

    @Override
    public void incubar() {
        System.out.println("Cocodrilo incubando");
    }

    @Override
    public void fracturar() {
        System.out.println("Cocodrilo fracturándose");
    }

    @Override
    public void artritis() {
        System.out.println("Cocodrilo con artritis");
    }

    @Override
    public void nacer() {
        System.out.println("Cocodrilo naciendo");
    }

    @Override
    public void morir() {
        System.out.println("Cocodrilo muriendo");
    }

    @Override
    public void comer() {
        System.out.println("Cocodrilo comiendo");
    }
    
}
