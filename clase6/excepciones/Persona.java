/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase6.excepciones;

/**
 *
 * @author Julian
 */
public class Persona {
    String nombre;
    int edad;
    
    public Persona(){
        nombre = "NN";
        edad = 0;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreInvalidoException{
        if(nombre.matches("^[a-zA-Z ]+$")){
            this.nombre = nombre;
        }else{
            throw new NombreInvalidoException(nombre);
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws EdadInvalidaException{
        if(edad > 0 && edad < 150){
            this.edad = edad;
        }else{
            throw new EdadInvalidaException(edad);
        }
    }
    
    @Override
    public String toString(){
        return String.format("{nombre: %s, edad: %d}", nombre, edad);
    }
}
