package cenafilosofos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

class Filosofo extends Thread{
   private String identidad;
   private Mesa mesa;
   private int numFilosofo;
   

   public Filosofo (int i,  Mesa m)
   {
      this.mesa = m;    
      this.numFilosofo=i;
   }
   
   public void run()
   {
       boolean tieneLosPalillos=false;
      while (true)
      {
         mesa.pensar(numFilosofo);
         tieneLosPalillos=mesa.cogerPalillos(numFilosofo);
         //solo come si los palillos al lado del filosofo han sido cogidos
         //pero por el no por los filosofos de al lado
         if (tieneLosPalillos){
             mesa.comer(numFilosofo);
             mesa.soltarPalillos(numFilosofo);
         }
         yield();
      }
   }
}

