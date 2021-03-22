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
public class Cliente extends Thread {
    private String nombre;
    private Peluqueria peluqueria;

    public Cliente(String nombre, Peluqueria peluqueria) {
        this.nombre = nombre;
        this.peluqueria = peluqueria;
    }

    public Peluqueria getPeluqueria() {
        return peluqueria;
    }

    public void setPeluqueria(Peluqueria peluqueria) {
        this.peluqueria = peluqueria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println(this.nombre + " entra en la peluquería");
        peluqueria.entraCliente(this);
    }
    
    
    
}
