/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Hilo extends Thread {
 //le pongo nombre a mi hilo
 public Hilo(String nombre){
 super(nombre);
 }

 @Override
 public void run(){
 try {
 sleep(2000);
 } catch (InterruptedException ex) {
 Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
 }
        System.out.println("FIN HILO");

 }

} 
