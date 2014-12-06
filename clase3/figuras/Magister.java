/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase3.figuras;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Scanner;

/**
 *
 * @author Julian
 */
public class Magister extends Applet {

    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hola Mundo");
        
        //primerEjercicio();
        
        Figure f = new Figure();
        Triangle t = new Triangle();
        
        f.draw();
        t.draw();
        t.rotate();
        f.scale();
        t.scale();
        System.out.println("t-edges:"+t.edgesCount());
    }
    
    public static void primerEjercicio() {
        // Entero limitado entre -128 y 127
        byte var0;
        // Entero limitado entre -32,768 y 32767
        short var1;
        // Entero limitado entre -2,147,483,648 y 2,147,483,647
        int var2;
        // Entero limitado entre -9,223,372,036,854,775,808 y 9,223,372,036,854,775,807
        long var3;
        float var4;
        double var5;
        boolean var6;
        char var7;
        String var8;
        
        // Operadores aritméticos, lógicos, relacionales
        double a = (double)5/(double)7;
        double b = a/a;
        double c;
        if(b == 1) {
            c = 6;
        } else {
            c = 4;
        }
        b++;
        
        //Arreglos
        double[] arreglo = new double[7];
        for(int i = 0; i<7; i++){
            //límites???
            arreglo[i] = 50*Math.random()+25;
            System.out.println("arreglo["+i+"]="+arreglo[i]);
        }
        
        //while y do-while manejo de índices de ciclo manual
        int index = 0;
        while(arreglo[6] != 100) {
            arreglo[index] = 100;
            System.out.println("arreglo["+index+"]="+arreglo[index]);
            index+=1;
        }
        
        index = 6;
        do {
            arreglo[index] = 0;
            System.out.println("arreglo["+index+"]="+arreglo[index]);
            index--;
        }while(arreglo[0] != 0);
        
        String respuesta;
        do{
            System.out.println("Escoja 1 y oprima Enter");
            Scanner in = new Scanner(System.in);
            respuesta = in.nextLine();
        }while(!respuesta.equals("1"));
        
        System.out.println("Afuera del ciclo");
    }
}
