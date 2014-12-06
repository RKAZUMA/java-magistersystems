/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.apuntadores;

/**
 *
 * @author Julian
 */
public class MiExcepcion extends UnsupportedOperationException{

    public MiExcepcion(){
        super();
    }
    
    public MiExcepcion(String message){
        super(message);
    }
    
    @Override
    public String getMessage() {
        return "Un Método No Implementado";
    }
    
}
