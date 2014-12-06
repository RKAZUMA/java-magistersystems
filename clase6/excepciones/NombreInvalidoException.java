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
public class NombreInvalidoException extends IOException{
    String nombre;
    public NombreInvalidoException(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String getMessage(){
        return String.format("El nombre '%s' no es válido.",nombre);
    }
}
