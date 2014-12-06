/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase6.excepciones;

import java.io.IOException;

/**
 *
 * @author Julian
 */
public class EdadInvalidaException extends IOException{
    
    int edad;
    
    public EdadInvalidaException(int edad){
        this.edad = edad;
    }
    
    @Override
    public String getMessage(){
        return String.format("La edad '%d' no es válida.",edad);
    }
}
