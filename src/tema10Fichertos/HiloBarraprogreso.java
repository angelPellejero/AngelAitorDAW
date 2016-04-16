/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema10Fichertos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PROF_VESPERTINO
 */
public class HiloBarraprogreso implements Runnable {
    private Gui gui;

    public HiloBarraprogreso(Gui gui) {
        this.gui = gui;
    }
    
    
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                gui.getBarra().setValue(i);
                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloBarraprogreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
