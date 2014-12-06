/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase3.ej_vector;

/**
 *
 * @author Julian
 */
public class Vector {
    public float x;
    public float y;
    public float z;
    
    public Vector() {
        x = y = z = 0;
    }
    
    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector invertir() {
        return new Vector(-x, -y, -z);
    }
    
    public Vector multiplicarConstante(float c) {
        return new Vector(c*x, c*y, c*z);
    }
    
    public static Vector suma(Vector a, Vector b) {
        return new Vector(a.x + b.x,
                a.y + b.y,
                a.z + b.z);
    }
    
    public static float productoPunto(Vector a, Vector b) {
        return (a.x*b.x)+(a.y*b.y)+(a.z*b.z);
    }
    
    @Override
    public String toString(){
        return ("("+x+","+y+","+z+")");
    }
}
