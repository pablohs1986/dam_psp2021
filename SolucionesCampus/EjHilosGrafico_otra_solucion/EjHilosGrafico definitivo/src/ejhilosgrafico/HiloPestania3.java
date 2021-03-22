package ejhilosgrafico;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.*;
/**
 *
 * @author Mª Alejandra Tomás Fernández
 */
public class HiloPestania3 extends Thread {
    private JPanel p3;
    private JLabel lb;
    JTextArea textoSaludo;
    private boolean terminar=false; //controla la parada del bucle de saludar
    private int cont=0; //contador para el saludo
    private JTabbedPane panelconpestanias; //panel que contendrá las pestañas
    
    
    //CONSTRUCTOR
    public HiloPestania3(JTabbedPane panel){
        super();
        //le paso el panel con pestañas para luego añadir una pestaña nueva desde aquí
        this.panelconpestanias=panel;
    }
    
    /** método que cuenta infinitamente y lo muestra en el textarea*/
    public void saludar(){
         while(!terminar){
            //inserto cada nuevo saludo arriba del todo del Textarea, para que lo vea siempre
            //Es la posición 0.
            this.textoSaludo.insert("HOLA QUE TAL = "+cont+"\n",0);
            cont++;
            try {
                //uso sleep para ralentizar un poco el contador y poder verlo
		Thread.sleep(1000);
            } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }
        }
    
    }
    
    public void parar(boolean parando){
        if (parando==true)
            this.terminar=true;
    }
    
    @Override
    public void run(){
        
        //creo el panel para situar luego en la pestaña 3
        p3=new JPanel(null);
        
        //etiqueta que muestra "ESTOY SALUDANDO!!!"
        lb=new JLabel();
        //sitúa la etiqueta donde quiero
        lb.setBounds(10,10,200,25);
        //pongo el texto a la etiqueta
        lb.setText("ESTOY SALUDANDO!!!!!!!!!!");
        //añado la etiqueta al panel
        p3.add(lb);
        
        //textarea para mostrar el contenido de los saludos que hace el hilo
        textoSaludo=new JTextArea();
        //coloco el textarea donde quiero
        textoSaludo.setBounds(10,50,200,200);
        //añado el textarea al panel
        p3.add(textoSaludo);
        
        //añado el panel p3 que ejecuta este hilo al panel de pestañas
        panelconpestanias.addTab("PESTAÑA 3 ", null, this.p3, "Hilo que está saludando");
        
        //´Código que hace la cuenta infinita
       this.saludar();
       
       
        
    
        
       
    }
}
