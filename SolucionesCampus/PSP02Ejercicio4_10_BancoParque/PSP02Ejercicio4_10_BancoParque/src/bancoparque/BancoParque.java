package bancoparque;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoParque {
    private int MaxNumPersonasSentadas;
    private boolean plazas_disponibles ;
    private int totalPersonasSentadas ;
    
    BancoParque(int plazas){
        MaxNumPersonasSentadas=plazas;
        plazas_disponibles =true;
        totalPersonasSentadas=0;
    }
    
    public synchronized void sentarsePersona(Persona p){
        while (!plazas_disponibles) {            
            try {
                System.out.println(p.getNombre()+": No hay sitio, esperando para sentarse");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BancoParque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("++++ La persona " + p.getNombre() + " se ha sentado ");
        totalPersonasSentadas++;
        if (totalPersonasSentadas == MaxNumPersonasSentadas) {
            plazas_disponibles = false;
            System.out.println("banco lleno");
        }        
        notifyAll();
    }
    
    public synchronized void levantarsePersona(Persona p){
        System.out.println("---- La persona " + p.getNombre() + " se ha levantado");
        totalPersonasSentadas--;
        plazas_disponibles = true;
        System.out.println("quedan "+ (MaxNumPersonasSentadas-totalPersonasSentadas)+" plazas libres");
        notifyAll();
    }
}
