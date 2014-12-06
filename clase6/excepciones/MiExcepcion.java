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
public class MiExcepcion extends IOException{

    public MiExcepcion(String message) {
        super(message);
        System.out.println("Se ha creado una excepción propia");
    }

    @Override
    public String getMessage() {
        return super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
