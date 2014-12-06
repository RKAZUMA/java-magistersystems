/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase3.ej_vector;

/**
 *
 * @author Julian
 */
public class Principal {
    public static void main(String[] args) {
        Vector a,c,s;
        a = new Vector(7,8,5);
        c = new Vector(10,15,1);
        s = Vector.suma(a.invertir(),c).multiplicarConstante(Vector.productoPunto(a, c));
        System.out.println("s="+s.toString());
    }
}
