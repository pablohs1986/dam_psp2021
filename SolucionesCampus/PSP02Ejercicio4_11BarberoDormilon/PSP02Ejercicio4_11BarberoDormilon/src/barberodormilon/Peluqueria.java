
package barberodormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Peluqueria {
    //nº de sillas de la peluquería, por ejemplo, 5
    private int nSillasEspera;
    //contador usado para saber cuantas sillas de espera están ocupadas en cada momento
    int contSillasOcupadas;
    //controla si está ocupado o libre el sillón de cortar el pelo
    private boolean estaLibreSillonCortar;
    //controla si hay sillas de espera libres
    private boolean haySillasEspera;
    //controla si el peluquero está durmiendo o no
    private boolean peluqueroDurmiendo;
    //controla cuando se termina de cortar el pelo el cliente
    private boolean termineDeCortarsePelo;
    private int totalClientes;
    private int nClientes;
    
    
    public Peluqueria(int nsillas, int nClientes){
        this.nSillasEspera=nsillas;
        this.contSillasOcupadas=0; //todas vacías
        this.estaLibreSillonCortar=true; //sillón de cortar pelo vacío
        this.haySillasEspera=true; //todas vacías
        this.peluqueroDurmiendo=false; //inicialmente no duerme
        this.termineDeCortarsePelo=false; //inicialmente se pone a falso
        this.totalClientes=0;
        this.nClientes=nClientes;
    }
    
    public synchronized void entrarCliente(String nombre){
        totalClientes++;
        haySillasEspera=(contSillasOcupadas==nSillasEspera)?false:true;
        if (!haySillasEspera) { //el cliente se irá
            System.out.println("El Cliente "+nombre+" se va sin cortar el pelo. Todo LLENO");
        }
        else{
            contSillasOcupadas++; //el cliente se sienta a esperar su turno
            System.out.println("El Cliente "+nombre+" se sienta a esperar su turno");
            while (!estaLibreSillonCortar){
                try {
                    wait(); //espera por el sillón para sentarse
                } catch (InterruptedException ex) {
                    Logger.getLogger(Peluqueria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //cuando continúa por aquí, es que el sillón de cortar ya está libre
            //al sentarse a cortar el pelo puede ser que el peluquero esté dormido, habría que despertarlo
            if (peluqueroDurmiendo){ //debe despertarlo
                System.out.println("El Cliente "+nombre+" despierta al peluquero");
                peluqueroDurmiendo=false; //se despierta
                notifyAll();//porque puede haber clientes y peluquero con un wait() hecho.
            }
            
            contSillasOcupadas--; //el cliente deja de esperar y libera su silla
            estaLibreSillonCortar=false; //lo ponemos a false porque lo ocupa este cliente que va a cortar
            System.out.println("El cliente "+nombre+ " pasa a cortar el pelo");
            termineDeCortarsePelo=false; //empieza ahora el corte por eso de momento es false
            while (!termineDeCortarsePelo){
                try {
                    //sigue en el sillón del peluquero cortando el pelo
                    wait();         
                } catch (InterruptedException ex) {
                    Logger.getLogger(Peluqueria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //cuando continúa aquí es que ya terminó de cortarse el pelo
            estaLibreSillonCortar=true; //ya se levanta del sillón de cortar y lo deja libre
            System.out.println("El Cliente "+nombre+" terminó de cortarse el pelo");
            notify();//despierta a otro            
        }
    }
    
    
    public synchronized void PeluqueroAtenderCliente(){
           
            while (estaLibreSillonCortar){ // sillón cortar libre
                //debe irse a dormir
                peluqueroDurmiendo=true; //se va a dormir
                System.out.println("GRRRR,GRRRR,...El peluquero está durmiendo a la espera de un cliente");
    
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Peluqueria.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
            //cuando llega aquí es porque se despertó
            System.out.println("El peluquero está cortando el pelo...");
         
    }
  
    
    
public synchronized void terminarCorte(){
    termineDeCortarsePelo=true;
    System.out.println("El peluquero terminó de cortar el pelo al cliente");
    System.out.println("QUE PASE EL SIGUIENTE!!!!!");
    notifyAll(); //avisa a uno de los clientes que están esperando para que pasen a cortar
}

public int getTotalClientes(){
    return totalClientes;
}

public boolean isHayClientesEsperando(){
    if (contSillasOcupadas==0 && estaLibreSillonCortar && totalClientes==nClientes)
        return false;
       else
        return true;
}
}
