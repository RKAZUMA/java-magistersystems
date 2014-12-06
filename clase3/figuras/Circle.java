/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase3.figuras;

/**
 *
 * @author Julian
 */
public class Circle extends Figure{
    
    public int radius;
    
    public Circle() {
        radius = 2;
        color = "blue";
        borderWidth = 2;
    }
    
    @Override
    public void draw() {
        System.out.println("Dibujando círculo de radio " + radius + 
                ", de color " + color + 
                " con borde "+ borderWidth);
    }

    @Override
    public void rotate() {
        System.out.println("Rotando el círculo");
    }

    @Override
    public void scale() {
        System.out.println("Escalando el círculo");
    }
}
