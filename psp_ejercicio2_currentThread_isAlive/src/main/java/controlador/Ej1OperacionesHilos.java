/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Hilo;

/**
 *
 * @author pablo
 */
public class Ej1OperacionesHilos {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
 // TODO code application logic here
 //Pongo nombre al hilo que representa el programa principal
 Thread.currentThread().setName("ProgPrin");

 //creo el objeto hilo con el nombre "mihilo"
 Hilo mihilo=new Hilo("mihilo");

 //compruebo si está vivo o muerto el hilo
 System.out.println("Hilo "+mihilo.getName()+" antes de iniciar: "+mihilo.isAlive());

 mihilo.start(); //arranco el hilo

 //compruebo si está vivo o muerto el hilo
 System.out.println("Hilo "+mihilo.getName()+" en ejecución: "+mihilo.isAlive());

 try{
 //hace dormir al hilo del programa principal
 System.out.println("HILO PRINCIPAL: "+Thread.currentThread().getName());
 Thread.currentThread().sleep(1000);
 //al dormirse 3000, el hilo ya terminó porque se duerme 2000
 }catch(InterruptedException e){
 Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, e); 
  }
 System.out.println("Hilo "+mihilo.getName()+" después de ejecutarse: "+mihilo.isAlive());
 } 
    
}
