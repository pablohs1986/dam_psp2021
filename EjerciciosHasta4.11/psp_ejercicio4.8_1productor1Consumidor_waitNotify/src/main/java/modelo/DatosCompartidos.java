/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pablo Herrero
 */
public class DatosCompartidos {
    private String dato;
    private boolean disponibilidadDato = false;

    public DatosCompartidos() {
    }
    
    /* Método que ejecutará el productor. Si ha algún dato pendiente de recoger,
    * el productor esperará hasta quese haya recogido. Si no hay ningún dato pendiente
    * de recoger, lo almacenará y notificará que hay un dato pendiente de recogida.
    */
    public synchronized void almacenarDato(String cadena) throws InterruptedException {
        while(disponibilidadDato == true) {
            wait();
        }
        this.dato = cadena;
        System.out.println("Almacenado el dato " + this.dato);
        disponibilidadDato = true;
        notifyAll();
    }

    /* Método para el consumidor. Si no hay datos pendientes de recogida, espera.
    * Si los hay, los recoge y lo notifica.
    */
    public synchronized String getDato() throws InterruptedException {
        while(disponibilidadDato == false){
            wait();
        }
        disponibilidadDato = false;
        notifyAll();
        return dato;
    }
    
    
    
    
}
