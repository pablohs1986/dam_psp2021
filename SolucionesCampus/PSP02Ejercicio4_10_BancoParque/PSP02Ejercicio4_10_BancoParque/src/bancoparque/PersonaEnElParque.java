package bancoparque;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaEnElParque extends Thread{
    private Persona p;
    private BancoParque banco;
    
    PersonaEnElParque (Persona p, BancoParque banco){
        this.p = p;
        System.out.println("la persona "+p.getNombre()+" esta en el parque");
        
        this.banco = banco;
    }
    
     public void run(){
        //la persona se sienta
        banco.sentarsePersona(p);
        
        int tiempoSentado = 1000+(int) (Math.random()*500);
        try {
            Thread.sleep(tiempoSentado);
        } catch (InterruptedException ex) {
            Logger.getLogger(PersonaEnElParque.class.getName()).log(Level.SEVERE, null, ex);
        }
        //despues de un tiempo la persona se levanta
        banco.levantarsePersona(p);
    }
}
