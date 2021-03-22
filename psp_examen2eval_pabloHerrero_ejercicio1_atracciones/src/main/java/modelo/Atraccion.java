/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Herrero
 */
public class Atraccion extends Thread {
    
    private String nombre;
    private int capacidad;
    private int usuariosEnAtraccion;
    private CyclicBarrier barreraParque;
    private CyclicBarrier barreraAtraccion = new CyclicBarrier(capacidad);

    public Atraccion(String nombre, int capacidad, CyclicBarrier barreraParque) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.barreraParque = barreraParque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getUsuariosEnAtraccion() {
        return usuariosEnAtraccion;
    }

    public void setUsuariosEnAtraccion(int usuariosEnAtraccion) {
        this.usuariosEnAtraccion = usuariosEnAtraccion;
    }

    
    public void aniadirPersona() {
        usuariosEnAtraccion++;
    }

    public CyclicBarrier getBarreraParque() {
        return barreraParque;
    }

    public void setBarreraParque(CyclicBarrier barreraParque) {
        this.barreraParque = barreraParque;
    }

    public CyclicBarrier getBarreraAtraccion() {
        return barreraAtraccion;
    }

    public void setBarreraAtraccion(CyclicBarrier barreraAtraccion) {
        this.barreraAtraccion = barreraAtraccion;
    }
    
    /**
     * Genera un tiempo aleatorio en ms, de 500 a 750ms.
     *
     * @return Long con el tiempo en ms
     */
    private long generarTiempo() {
        return (long) (Math.random() * 500) + 250;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Atracción" + this.nombre + " preparada");
            barreraParque.await();
            System.out.println("ESTAMOS LISTOS!!! aforo completo!" + this.nombre + " se inicia");
            long tiempo = generarTiempo();
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
