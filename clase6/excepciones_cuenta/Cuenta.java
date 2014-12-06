/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase6.excepciones_cuenta;

/**
 *
 * @author Julian
 */
public class Cuenta {
    
    float saldo;
    
    public Cuenta(){
        saldo = 0;
    }
    
    public Cuenta(float saldo){
        if(saldo > 0){
            this.saldo = saldo;
        }else{
            this.saldo = 0;
        }
    }
    
    public float consignacion(float c){
        if(c > 0){
            saldo += c;
            System.out.println("Consignación realizada.");
        }else{
            System.out.println("Consignación no realizada.");
        }
        return saldo;
    }
    
    public float retiro(float r) throws FondosInsuficientesException{
        if(r > 0){
            if(r <= saldo){
                saldo -= r;
                System.out.println("Retiro realizado.");
            }else{
                System.out.println("Retiro no realizado.");
                throw new FondosInsuficientesException(r-saldo);
            }
        }else{
            System.out.println("Retiro no realizado.");
        }
        return saldo;
    }
    
    @Override
    public String toString(){
        return String.format("Cuenta con saldo: %,12.2f", saldo);
    }
}
