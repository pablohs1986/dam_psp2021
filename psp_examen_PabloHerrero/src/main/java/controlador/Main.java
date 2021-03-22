/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.Semaphore;
import modelo.Nadador;
import modelo.Piscina;
import modelo.TipoNadador;

/**
 *
 * @author Pablo Herrero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creo semáforo y asigno permisos
        Semaphore semaforo = new Semaphore(8);

        // Creo piscina, asignando el número de calles
        Piscina piscina = new Piscina(8);

        // Creo nadadores
        Nadador nadador1 = new Nadador("id_1", TipoNadador.hombre, semaforo, piscina);
        Nadador nadador2 = new Nadador("id_2", TipoNadador.mujer, semaforo, piscina);
        Nadador nadador3 = new Nadador("id_3", TipoNadador.niño, semaforo, piscina);
        Nadador nadador4 = new Nadador("id_4", TipoNadador.mujer, semaforo, piscina);
        Nadador nadador5 = new Nadador("id_5", TipoNadador.niño, semaforo, piscina);
        Nadador nadador6 = new Nadador("id_6", TipoNadador.hombre, semaforo, piscina);
        Nadador nadador7 = new Nadador("id_7", TipoNadador.mujer, semaforo, piscina);
        Nadador nadador8 = new Nadador("id_8", TipoNadador.niño, semaforo, piscina);
        Nadador nadador9 = new Nadador("id_9", TipoNadador.hombre, semaforo, piscina);
        Nadador nadador10 = new Nadador("id_10", TipoNadador.mujer, semaforo, piscina);
        Nadador nadador11 = new Nadador("id_11", TipoNadador.niño, semaforo, piscina);
        Nadador nadador12 = new Nadador("id_12", TipoNadador.hombre, semaforo, piscina);
        Nadador nadador13 = new Nadador("id_13", TipoNadador.mujer, semaforo, piscina);
        Nadador nadador14 = new Nadador("id_14", TipoNadador.niño, semaforo, piscina);
        Nadador nadador15 = new Nadador("id_15", TipoNadador.hombre, semaforo, piscina);
        Nadador nadador16 = new Nadador("id_16", TipoNadador.mujer, semaforo, piscina);
        Nadador nadador17 = new Nadador("id_17", TipoNadador.niño, semaforo, piscina);
        Nadador nadador18 = new Nadador("id_18", TipoNadador.hombre, semaforo, piscina);
        Nadador nadador19 = new Nadador("id_19", TipoNadador.mujer, semaforo, piscina);
        Nadador nadador20 = new Nadador("id_20", TipoNadador.niño, semaforo, piscina);

        // Inicio nadadores
        nadador1.start();
        nadador2.start();
        nadador3.start();
        nadador4.start();
        nadador5.start();
        nadador6.start();
        nadador7.start();
        nadador8.start();
        nadador10.start();
        nadador11.start();
        nadador12.start();
        nadador13.start();
        nadador14.start();
        nadador15.start();
        nadador16.start();
        nadador17.start();
        nadador18.start();
        nadador19.start();
        nadador20.start();
    }

}
