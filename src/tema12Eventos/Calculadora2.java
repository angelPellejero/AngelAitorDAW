/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema12;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author VESPERTINO
 */
public class Calculadora2 extends JFrame implements ActionListener{
    
    private JButton[] botones;
    private JPanel[] paneles;
    private JLabel jlbresultado;
    private int resultado, aux1, aux2;
    private StringBuilder acumulador;
    private Image icono;
    private int op1, op2;
    private char operador;
    
    public Calculadora2(){
        
        botones = new JButton[17];
        paneles = new JPanel[3];
        icono = new ImageIcon(getClass().getResource("/imagenes/calculadora.png")).getImage();
        resultado = 0;
        acumulador = new StringBuilder(" ");
        aux1 = 0;
        aux2 = 0;
        jlbresultado = new JLabel("0");
        
        for (int i = 0; i < 3; i++) {
            paneles[i] = new JPanel();
        }
        
        for (int i = 0; i < 17; i++) {
            if(i < 10)
                botones[i] = new JButton("" + i);
            else if(i == 10)
                botones[i] = new JButton("+");
            else if(i == 11)
                botones[i] = new JButton("-");
            else if(i == 12)
                botones[i] = new JButton("=");
            else if(i ==13)
                botones[i] = new JButton("C");
            else if(i == 14)
                botones[i] = new JButton("*");
            else if(i == 15)
                botones[i] = new JButton("/");
            else
                botones[i] = new JButton("%");
        }
        
        for (int i = 0; i < 17; i++) {
            botones[i].addActionListener(this);
        }

        paneles[0].setLayout(new FlowLayout(FlowLayout.RIGHT));
        paneles[0].add(jlbresultado);
        
        paneles[1].setLayout(new GridLayout(5, 3));
        for (int i = 0; i < 12; i++) {
            paneles[1].add(botones[i]);
        }
        paneles[1].add(botones[14]);
        paneles[1].add(botones[15]);
        paneles[1].add(botones[16]);
        
        paneles[2].setLayout(new GridLayout(1, 2));
        paneles[2].add(botones[12]);
        paneles[2].add(botones[13]);
        
        getContentPane().setLayout(new BorderLayout());
        add(paneles[1], BorderLayout.CENTER);
        add(paneles[2], BorderLayout.SOUTH);
        add(paneles[0], BorderLayout.NORTH);
        
        setResizable(false);
        setMinimumSize(new Dimension(200, 200));
        setIconImage(icono);
        setVisible(true);//hacer visible la ventana
        setLocationRelativeTo(null);//para que la ventana salga centrada
        setTitle("Calculadora");//titulo de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//para terminar proceso al cerrar ventana
        pack();//para que los botones se adaptel al tamaño de la ventana
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        JButton bot = (JButton) e.getSource();
        if (bot.getText().equals("+")) { // Ha sido pulsado el +
            op1 = Integer.parseInt(jlbresultado.getText());
            operador = '+';
            jlbresultado.setText(" ");            
        } else if (bot.getText().equals("-")) { // Ha sido pulsado el -
            op1 = Integer.parseInt(jlbresultado.getText());
            operador = '-';
            jlbresultado.setText(" ");
        } else if (bot.getText().equals("*")) { // Ha sido pulsado el -
            op1 = Integer.parseInt(jlbresultado.getText());
            operador = '*';
            jlbresultado.setText(" ");    
        } else if (bot.getText().equals("/")) { // Ha sido pulsado el -
            op1 = Integer.parseInt(jlbresultado.getText());
            operador = '/';
            jlbresultado.setText(" ");
        } else if (bot.getText().equals("%")) { // Ha sido pulsado el -
            op1 = Integer.parseInt(jlbresultado.getText());
            operador = '%';
            jlbresultado.setText(" ");    
        } else if (bot.getText().equals("=")) { // Ha sido pulsado el =
            int aux;
            if (operador=='+') {
                aux = op1 + Integer.parseInt(jlbresultado.getText().trim());
                jlbresultado.setText("" + aux);
            } else if (operador=='-') {
                aux = op1 - Integer.parseInt(jlbresultado.getText().trim());
                jlbresultado.setText("" + aux);
            } else if (operador=='*') {
                aux = op1 * Integer.parseInt(jlbresultado.getText().trim());
                jlbresultado.setText("" + aux);
            } else if (operador=='/') {
                aux = op1 / Integer.parseInt(jlbresultado.getText().trim());
                jlbresultado.setText("" + aux);
            } else if (operador=='%') {
                aux = op1 % Integer.parseInt(jlbresultado.getText().trim());
                jlbresultado.setText("" + aux);
            }
        } 
        else if(bot.getText().equals("C")){
            op1 = 0;
            jlbresultado.setText(" ");
        }else {
            jlbresultado.setText(jlbresultado.getText().trim() + bot.getText());
        }
        } catch (Exception ex){
             jlbresultado.setText("Error");
        }
//        if(e.getSource() ==  botones[0]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append(botones[0].getText());
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[1]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append(botones[1].getText());
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[2]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append("2");
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[3]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append("3");
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[4]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append("4");
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[5]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append("5"); 
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[6]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append("6");
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[7]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append("7");
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[8]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append("8");
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[9]){
//                if(acumulador.charAt(0) == ' ')
//                    acumulador.deleteCharAt(0);
//                acumulador.append("9");
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
        
        
//        if(e.getSource() == botones[10]){
//                aux1 = Integer.parseInt(acumulador.toString());
//                acumulador.delete(0, acumulador.length());
//                acumulador.append('+');
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[11]){
//                aux1 = Integer.parseInt(acumulador.toString());
//                acumulador.delete(0, acumulador.length());
//                acumulador.append('-');
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[12]){
//                if(acumulador.charAt(0) == '+')
//                    resultado = aux1 + Integer.parseInt(acumulador.toString());
//                if(acumulador.charAt(0) == '-')
//                    resultado = aux1 + Integer.parseInt(acumulador.toString());
//                if(acumulador.charAt(0) == '*'){
//                    acumulador.deleteCharAt(0);
//                    resultado = aux1 * Integer.parseInt(acumulador.toString());
//                }
//                if(acumulador.charAt(0) == '/'){
//                    acumulador.deleteCharAt(0);
//                    resultado = aux1 / Integer.parseInt(acumulador.toString());
//                }
//                if(acumulador.charAt(0) == '%'){
//                    acumulador.deleteCharAt(0);
//                    resultado = aux1 % Integer.parseInt(acumulador.toString());
//                }
//                acumulador.delete(0, acumulador.length());
//                acumulador.append(resultado);
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[13]){
//                acumulador.delete(0, acumulador.length());
//                acumulador.append(' ');
//                aux1 = 0;
//                aux2 = 0;
//                jlbresultado.setText(acumulador.toString());
//        }
//        if(e.getSource() == botones[14]){
//                aux1 = Integer.parseInt(acumulador.toString());
//                acumulador.delete(0, acumulador.length());
//                acumulador.append('*');
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[15]){
//                aux1 = Integer.parseInt(acumulador.toString());
//                acumulador.delete(0, acumulador.length());
//                acumulador.append('/');
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
//        if(e.getSource() == botones[16]){
//                aux1 = Integer.parseInt(acumulador.toString());
//                acumulador.delete(0, acumulador.length());
//                acumulador.append('%');
//                String acu = acumulador.toString();
//                jlbresultado.setText(acu);
//        }
    }
    
    public static void main(String[] args) {
        Calculadora2 calc = new Calculadora2();
    }

}
