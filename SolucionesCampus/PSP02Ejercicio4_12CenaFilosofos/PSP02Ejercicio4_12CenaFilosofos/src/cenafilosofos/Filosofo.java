package cenafilosofos;
class Filosofo extends Thread{
   private String identidad;
   private Mesa mesa;
   private int numFilosofo;
   

   public Filosofo (int i,  Mesa m)
   {
      this.identidad= "f"+i;
      this.mesa = m;
      this.numFilosofo=i;
   }

   public void pensar()
   {
     try
     {
      System.out.println ("Filosofo " + identidad + " esta pensando");
      int delay= (int)(Math.random()*500)+1000;
      Thread.sleep(delay);
      System.out.println ("Filosofo " + identidad + " ha dejado de pensar");
     } catch (InterruptedException e) {}
   }

   public void comer()
   {
     try
     {
      System.out.println ("Filosofo " + identidad + " esta comiendo");
      int delay= (int)(Math.random()*500)+1000;
      Thread.sleep(delay);
      System.out.println ("Filosofo " + identidad + " ha terminado de comer");
     } catch (InterruptedException e) {}
   }

   public void run()
   {
      while (true)
      {
         pensar();
         mesa.cogerPalillos(numFilosofo);
         comer();
         mesa.soltarPalillos(numFilosofo);
      }
   }
}

