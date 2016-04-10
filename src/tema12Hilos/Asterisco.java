/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.hilos;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author PROF_VESPERTINO
 */
public class Asterisco extends JFrame implements ActionListener, Runnable {

    private JPanel jpPanel;
    private JLabel jlbAsterisco;
    private JButton jbBoton;
    private static Asterisco a;

    public Asterisco() {
        jpPanel = new JPanel();
        jlbAsterisco = new JLabel("*");
        jbBoton = new JButton("Go!");

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpPanel);
        getContentPane().add(jbBoton);
        getContentPane().setPreferredSize(new Dimension(300, 200));
        jpPanel.setLayout(null);
        jbBoton.addActionListener(this);
        jpPanel.add(jlbAsterisco);
        jlbAsterisco.setBounds(10, 10, 10, 10);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        a = new Asterisco();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread t = new Thread(a);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                jlbAsterisco.setLocation((jlbAsterisco.getLocation().x + i), jlbAsterisco.getLocation().y);
                repaint();
                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Asterisco.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
