package espe.edu.ec.laboratorio1p2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.swing.JProgressBar;

/**
 *
 * @author DARÍO BENAVIDES
 */
public class Laboratorio1P2 {

    public static void correr(JProgressBar barProgresoGeneral, 
            JProgressBar barProgreso1, JProgressBar barProgreso2, 
            JProgressBar barProgreso3, JProgressBar barProgreso4, 
            JProgressBar barProgreso5) {
        
        int nHilos = 5;
        Semaphore aportes = new Semaphore(0);
        ArrayList<Integer> porcentajes = new ArrayList<Integer>();
        ArrayList<SubProceso> subProcesos = new ArrayList<>();
        BarraGeneral barraGeneral = new BarraGeneral(1, aportes, porcentajes, nHilos, barProgresoGeneral);
        
        subProcesos.add(new SubProceso(aportes, 1, 50, 40, porcentajes, barProgreso1));
        subProcesos.add(new SubProceso(aportes,  2, 100, 10, porcentajes, barProgreso2));
        subProcesos.add(new SubProceso(aportes,  3, 100, 10, porcentajes, barProgreso3));
        subProcesos.add(new SubProceso(aportes, 4, 50, 5, porcentajes, barProgreso4));
        subProcesos.add(new SubProceso(aportes,  5, 100, 35, porcentajes, barProgreso5));
        
        barraGeneral.start();
        
        for(int i = 0; i < nHilos; i++){
            subProcesos.get(i).start();
        }
        
        while(barraGeneral.isAlive() || subProcesos.get(0).isAlive() || subProcesos.get(1).isAlive() || subProcesos.get(2).isAlive() ||
                subProcesos.get(3).isAlive() || subProcesos.get(4).isAlive()){
        }
    
    }
}
