package espe.edu.ec.laboratorio1p2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;

/**
 *
 * @author DARÍO BENAVIDES
 */
public class SubProceso extends Thread{
    private Semaphore aportes;
    private int id;
    private int tiempo;
    private int porcentaje;
    private ArrayList<Integer> porcentajes;
    private JProgressBar bar;
    
    SubProceso(Semaphore aportes, int id, int tiempo, int porcentaje, ArrayList<Integer> porcentajes, JProgressBar bar){
        this.aportes = aportes;
        this.id = id;
        this.tiempo = tiempo;
        this.porcentaje = porcentaje;
        this.porcentajes = porcentajes;
        this.bar = bar;
    }
    
    @Override
    public void run(){
        for(int i = 1; i <= 100; i++){
            try{
                this.sleep(tiempo);
                bar.setValue(i);
            }catch(InterruptedException ex){
                Logger.getLogger(SubProceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(porcentaje);
        porcentajes.add(porcentaje);
        aportes.release();
    }
}
