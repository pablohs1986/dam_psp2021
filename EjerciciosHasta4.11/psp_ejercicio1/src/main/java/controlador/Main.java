/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Hilo1A;

/**
 *
 * @author pablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Apartado 1A
//        try {
//            crearHilos(20);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }

        // Apartado 1B
//        Scanner sc = new Scanner(System.in);
//        int numeroHilos;
//        System.out.println("Introduce el número de hilos que quieres crear:");
//        numeroHilos = sc.nextInt();
//        try {
//            crearHilosF1(numeroHilos);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }

        // Apartado 2A
//        try {
//        crearHilosF2(20);   
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // Apartado 2B
        Scanner sc = new Scanner(System.in);
        int numeroHilos;
        System.out.println("Introduce el número de hilos que quieres crear:");
        numeroHilos = sc.nextInt();
        try {
            crearHilosForma2(numeroHilos);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void crearHilosForma1(int numeroHilos) throws InterruptedException {
        int tiempoDurmiendo;
       
        for (int i = 0; i < numeroHilos; i++) {
            tiempoDurmiendo = (int) ((Math.random()*5000)+1000);
            Hilo1A hilo = new Hilo1A("Hilo_"+i, tiempoDurmiendo);
            hilo.start();
        }
    }
    
    public static void crearHilosForma2(int numeroHilos) throws InterruptedException {
        int tiempoDurmiendo;
       
        for (int i = 0; i < numeroHilos; i++) {
            tiempoDurmiendo = (int) ((Math.random()*5000)+1000);
            Hilo1A hilo = new Hilo1A("Hilo_"+i, tiempoDurmiendo);
            hilo.start();
        }
    }
    
}
