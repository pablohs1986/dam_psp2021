package opcion2_unHiloSolo.modelo;


public class HiloPersona extends Thread {
    private Jardin j;
    private boolean entra;
    
    public HiloPersona(String nombreHilo, Jardin j){
        //asigamos la puerta de salida al jardin 
        //y un nombre a dicha puerta
        this.j=j;
        this.setName(nombreHilo);  //atributo name heredado del Thread
        entra =(((int) (Math.random()*2))==0)?false:true;
        System.out.println("Generado hilo "+nombreHilo+ "entra="+entra);
    }
    
    public void run(){
        //para ese jardin invocamos al método para que incremente
        j.EntraOSalePersona_Jardin();
    }
}
