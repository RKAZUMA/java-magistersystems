/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase6.excepciones_cuenta;

import java.util.Scanner;

/**
 *
 * @author Julian
 */
public class Ejercicio {
    
    enum Accion {
            CONSIGNAR, RETIRAR 
        }
    
    public static void main(String args[]){
        
        /**
         * EJERCICIO EXCEPCIONES
         * Una cuenta de banco en donde se pueda consignar y retirar.
         * Excepción de fondos insuficientes.
         */
        
        Cuenta nuevaCuenta = new Cuenta();
        String dataIn;
        
        do{
            System.out.println(nuevaCuenta.toString());
            System.out.println("Escriba 'c' ó 'r' ó 'quit'");
            Scanner in = new Scanner(System.in);
            dataIn = in.nextLine();
            Accion accion;
            if(dataIn.equalsIgnoreCase("c")){
                System.out.println("¿Cuánto va a consignar?");
                accion = Accion.CONSIGNAR;
            } else if(dataIn.equalsIgnoreCase("r")) {
                System.out.println("¿Cuánto va a retirar?");
                accion = Accion.RETIRAR;
            } else {
                continue;
            }
            
            float valor;
            try{
                valor = Float.valueOf(in.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Número no válido.");
                System.out.println(e.getMessage());
                continue;
            }
            
            if(accion == Accion.CONSIGNAR){
                nuevaCuenta.consignacion(valor);
            }else{
                try{
                    nuevaCuenta.retiro(valor);
                }catch(FondosInsuficientesException e){
                    System.out.println(e.getMessage());
                }
            }
        }while(!dataIn.equalsIgnoreCase("quit"));
    }
}
