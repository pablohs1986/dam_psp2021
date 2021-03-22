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
    private int totalDatos;
    private boolean datoDisponible = false;
    private boolean ultimoDatoLeido = false;

    public DatosCompartidos() {
    }

    public void setTotalDatos(int totalDatos) {
        this.totalDatos = totalDatos;
        System.out.println("Total de datos a almacenar: " + this.totalDatos);
    }

    public int getTotalDatos() {
        return totalDatos;
    }

    public boolean parar() {
        return ultimoDatoLeido;
    }

    /* Método que ejecutará el productor. Si ha algún dato pendiente de recoger,
    * el productor esperará hasta quese haya recogido. Si no hay ningún dato pendiente
    * de recoger, lo almacenará y notificará que hay un dato pendiente de recogida.
     */
    public void almacenarDato(String dato) throws InterruptedException {
        while (datoDisponible == true) {
            Thread.yield();
            wait();
        }
        this.dato = dato;
        datoDisponible = true;
        System.out.println(this.dato + " ALMACENADO");
        Thread.yield();
        notifyAll();
    }

    /* Método para el consumidor. Si no hay datos pendientes de recogida, espera.
    * Si los hay, los recoge y lo notifica.
     */
    public String consumirDato() throws InterruptedException {
        if (totalDatos > 0) {
            while (totalDatos > 0 && datoDisponible == false) {
                Thread.yield();
                wait();
            }
            datoDisponible = false;
            totalDatos--;
            notifyAll();
        } else {
            dato = null;
            datoDisponible = true;
            ultimoDatoLeido = true;
            notifyAll();
        }
        return dato;
    }

}
