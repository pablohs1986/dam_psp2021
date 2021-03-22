/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pablo
 */
public class HiloEjemploJoin implements Runnable{
    public String nombre;
    public HiloEjemploJoin(String nombre){
        this.nombre =nombre;
    }
    @Override
    public void run(){
        for (int i=0;i<10;i++){
        if (nombre.equalsIgnoreCase("Mi Hilo uno")){
        System.out.println(i+" "+ nombre+ " ---->");
     }
     else{
         System.out.println(i+" "+ nombre+ "<----");
     }
    try {
        Thread.sleep(500);
     }
        catch (InterruptedException ex) {
        ex.printStackTrace();
     }
     }
     System.out.println("Finaliza el Hilo "+ nombre);
    }
}
