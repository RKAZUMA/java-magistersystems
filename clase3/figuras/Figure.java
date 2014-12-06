/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase3.figuras;

/**
 *
 * @author Julian
 */
public class Figure implements FigureI{
    
    public String color;
    public int borderWidth;
    
    public Figure() {
        color = "blanco";
        borderWidth = 1;
    }
    
    public Figure(String color, int borderWidth) {
        this.color = color;
        this.borderWidth = borderWidth;
    }
    
    public void draw() {
        System.out.println("Dibujando cuadrado de lado de color " + color + 
                " con borde "+ borderWidth);
    }

    @Override
    public void rotate() {
        System.out.println("Rotando la figura");
    }

    @Override
    public void scale() {
        System.out.println("Escalando la figura");
    }
}
