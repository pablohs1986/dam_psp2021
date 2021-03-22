/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import modelo.Deportista;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        ExecutorService executor = Executors.newFixedThreadPool(8); // Pool para 8 deportistas
        Deportista deportista;
        long tiempoCaminando = 0;
        Deportista deportistaVencedor = null;

        for (int i = 1; i <= 8; i++) {
            tiempoCaminando = generarTiempoCaminar();
            deportista = new Deportista("Deportista_" + i, tiempoCaminando);
            executor.execute(deportista);
            deportistaVencedor = comprobarGanador(deportista);
        }

        executor.shutdown();
        
        
        Thread.sleep(1000); 
        System.out.println("UNA VEZ FINALIZADA LA PRUEBA, el ganador essss.........:");
        System.out.println(deportistaVencedor.getNombre() + " con un tiempo total de " 
                + (deportistaVencedor.getTiempoCaminando()+deportistaVencedor.getTiempoDisparando())
                + " ENHORABUENA!!!");
    }
    
    
    /**
     * Comprueba el deportista ganador. Recorre cada deportista creado
     * comparando con un tiempo ganador inicial. Si el tiempo es menor,
     * almacena el tiempo del deportista pasado y lo almacena a él mismo
     * para retornarlo, pues sería el deportista ganador.
     *
     * @return Long con el tiempo en ms
     */
    public static Deportista comprobarGanador(Deportista deportista) {
        Deportista deportistaVencedor = null;
        long tiempoDeportistaVencedor = 100000000;
        long tiempoDeportista = deportista.getTiempoCaminando() + deportista.getTiempoDisparando();
        
        if(tiempoDeportista < tiempoDeportistaVencedor){
            deportistaVencedor = deportista;
            tiempoDeportistaVencedor = tiempoDeportista;
        }
        return deportistaVencedor;
    }
    
    /**
     * Genera un tiempo aleatorio en ms, de 100 a 150ms.
     *
     * @return Long con el tiempo en ms
     */
    public static long generarTiempoCaminar() {
        return (long) (Math.random() * 100) + 50;
    }
    
}
