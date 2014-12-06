/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase6.excepciones_cuenta;

import java.io.IOException;

/**
 *
 * @author Julian
 */
public class FondosInsuficientesException extends IOException{
    float saldoFaltante;
    
    public FondosInsuficientesException(float saldoFaltante){
        this.saldoFaltante = saldoFaltante;
    }
    
    @Override
    public String getMessage(){
        return String.format("No se puede hacer el retiro, hace falta: %.3f", saldoFaltante);
    }
}
