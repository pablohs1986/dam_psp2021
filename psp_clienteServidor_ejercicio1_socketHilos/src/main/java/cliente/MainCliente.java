/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Pablo Herrero
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for (int i = 1; i <= 6; i++) {
            new Cliente(i).start();
        }
    }
    
}
