/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase3.figuras;

/**
 *
 * @author Julian
 */
public class Triangle extends Figure implements PolygonalFigure{
    
    public int base;
    public int height;

    public Triangle() {
        super("rojo",3);
        base = 3;
        height = 2;
    }
    
    @Override
    public void draw() {
        System.out.println("Dibujando triángulo de base " + base +
                " de altura " + height +
                ", de color " + color + 
                " con borde "+ borderWidth);
    }
    
    @Override
    public void rotate() {
        System.out.println("Rotando el triángulo");
    }

    @Override
    public void scale() {
        System.out.println("Escalando el triángulo");
    }

    @Override
    public int edgesCount() {
        return 3;
    }
    
}
