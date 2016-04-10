/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.hilos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PROF_VESPERTINO
 */
public class HiloHijo implements Runnable {
    private Asterisco2 a;

    public HiloHijo(Asterisco2 a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                a.getjlbAsterisco().setLocation((a.getjlbAsterisco().getLocation().x + i), a.getjlbAsterisco().getLocation().y);
                a.repaint();
                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Asterisco2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
