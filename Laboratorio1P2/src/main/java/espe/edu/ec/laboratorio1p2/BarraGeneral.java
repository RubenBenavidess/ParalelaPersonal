package espe.edu.ec.laboratorio1p2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author DARÍO BENAVIDES
 */
public class BarraGeneral extends Thread{
    
    private int id;
    private Semaphore aportes;
    private ArrayList<Integer> porcentajes;
    private int nHilos;
    private JProgressBar bar;
    
    BarraGeneral(int id, Semaphore aportes, ArrayList<Integer> porcentajes, int nHilos, JProgressBar bar){
        this.id = id;
        this.aportes = aportes;
        this.porcentajes = porcentajes;
        this.nHilos = nHilos;
        this.bar = bar;
    }
    
    @Override
    public void run(){
        int a;
        for(int i = 0; i < nHilos; i++){
            try {
                aportes.acquire();
                a = bar.getValue();
                bar.setValue(a + porcentajes.get(i));
                System.out.println(porcentajes.toString());
            } catch (InterruptedException ex) {
                Logger.getLogger(BarraGeneral.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
