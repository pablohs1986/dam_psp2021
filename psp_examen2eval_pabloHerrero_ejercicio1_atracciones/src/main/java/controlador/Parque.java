/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.concurrent.CyclicBarrier;
import modelo.Atraccion;
import modelo.Persona;

/**
 *
 * @author Pablo Herrero
 */
public class Parque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Barrera parque
        CyclicBarrier barreraParque = new CyclicBarrier(36);
        
        // Creo atracciones y las arranco
        Atraccion atraccion1 = new Atraccion("Noria", 20, barreraParque);
        Atraccion atraccion2 = new Atraccion("Caballitos", 10, barreraParque);
        Atraccion atraccion3 = new Atraccion("Dragón", 6, barreraParque);
        atraccion1.start();
        atraccion2.start();
        atraccion3.start();
        
        // Genero personas y abro la barrera del parque cuando se crean 36 personas
        for (int i = 0; i < 36; i++) {
            boolean isPersonaAniadida = false;
            Persona persona = null;
            
            // Compruebo si cada atracción está llena y asigno a cada atracción, según el caso.
            // Una vez se asigna la atracción y se completa su aforo, se levanta la barrera de la misma
            while(!isPersonaAniadida) {
                if (atraccion1.getUsuariosEnAtraccion() == atraccion1.getUsuariosEnAtraccion()) {
                    System.out.println("La atraccion " + atraccion1.getNombre() + "está llena.");
                } else {
                    persona = new Persona("Persona_"+i, atraccion1, atraccion1.getBarreraAtraccion());
                    atraccion1.aniadirPersona();
                    isPersonaAniadida=true;
                }

                if (atraccion2.getUsuariosEnAtraccion() == atraccion2.getUsuariosEnAtraccion()) {
                    System.out.println("La atraccion " + atraccion2.getNombre() + "está llena.");
                } else {
                    persona = new Persona("Persona_" + i, atraccion2, atraccion2.getBarreraAtraccion());
                    atraccion2.aniadirPersona();
                    isPersonaAniadida = true;
                }

                if (atraccion3.getUsuariosEnAtraccion() == atraccion3.getUsuariosEnAtraccion()) {
                    System.out.println("La atraccion " + atraccion3.getNombre() + "está llena.");
                } else {
                    persona = new Persona("Persona_" + i, atraccion3, atraccion3.getBarreraAtraccion());
                    atraccion3.aniadirPersona();
                    isPersonaAniadida = true;
                }
            }
            persona.start();
        }
    }
    
}
