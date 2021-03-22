/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.Exchanger;
import modelo.Amigo;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exchanger<String> exchangerCita = new Exchanger<String>();
        
        Amigo amigo1 = new Amigo("Luke", exchangerCita);
        Amigo amigo2 = new Amigo("Vader", exchangerCita);
        
        amigo1.start();
        amigo2.start();
    }
    
}
