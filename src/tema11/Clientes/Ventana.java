package tema11.Clientes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener, WindowListener {

    private Dimension dimesion;
    private JPanel jpMain, jpTop, jpSignOn, jpSignOff, jpShowMain, jpShow, jpshow2, jpChange1, jpChange2;
    private JButton jbAlta, jbBaja, jbShow, jbChange, jbAgreeAdd, jbShowID, jbChangeID, jbChange2, jbDeleteID;
    private JLabel jlNameAdd, jlLasNameAdd, jlIDadd, jlAgeAdd, jlShowID, jlChangeID, jlDeleteID;
    private JLabel jlNameChange, jlLasNameChange, jlIDChange, jlAgeChange;
    private JTextArea jtNameAdd, jtLasNameAdd, jtIDadd, jtAgeAdd, jtShowID, jtShowData, jtChangeID, jtDeleteID;
    private JTextArea jtNameChange, jtLasNameChange, jtIDChange, jtAgeChange;
    private JScrollPane jpscrollPanel;
    private Cursor datosCliente;

    public Ventana() {
        datosCliente = new Cursor();
        dimesion = new Dimension(600, 350);
        jpMain = new JPanel(null);
        jpTop = new JPanel(new FlowLayout());
        jbAlta = new JButton("alta");
        jbAlta.addActionListener(this);

        jbBaja = new JButton("baja");
        jbBaja.addActionListener(this);

        jbShow = new JButton("mostrar");
        jbShow.addActionListener(this);

        jbChange = new JButton("cambiar");
        jbChange.addActionListener(this);
        this.addWindowListener(this);

        jpTop.add(jbAlta);
        jpTop.add(jbBaja);
        jpTop.add(jbShow);
        jpTop.add(jbChange);

        this.add(jpMain);
        jpMain.add(jpTop);
        jpTop.setBounds(10, 10, dimesion.width - 25, 40);

        jbChangeID = new JButton("ok");
        jbChangeID.addActionListener(this);
        jbAgreeAdd = new JButton("ok");
        jbAgreeAdd.addActionListener(this);
        jbShowID = new JButton("ok");
        jbChange2 = new JButton("ok");
        jbChange2.addActionListener(this);
        jbDeleteID = new JButton("ok");
        jbDeleteID.addActionListener(this);

        panelAdd();
        crearPanelDelete();
        crearPanelShow();
        creapanelCambiar1();
        creapanelCambiar2();

        pack();
        setSize(dimesion);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void panelAdd() {
        jpSignOn = new JPanel(new GridLayout(6, 6, 5, 5));
        jlNameAdd = new JLabel("nombre");
        jlLasNameAdd = new JLabel("apellidos");
        jlIDadd = new JLabel("dni");
        jlAgeAdd = new JLabel("años");
        jtNameAdd = new JTextArea(" ");
        jtLasNameAdd = new JTextArea(" ");
        jtIDadd = new JTextArea(" ");
        jtAgeAdd = new JTextArea(" ");
        jpSignOn.add(jlNameAdd);
        jpSignOn.add(jtNameAdd);
        jpSignOn.add(jlLasNameAdd);
        jpSignOn.add(jtLasNameAdd);
        jpSignOn.add(jlIDadd);
        jpSignOn.add(jtIDadd);
        jpSignOn.add(jlAgeAdd);
        jpSignOn.add(jtAgeAdd);
        jpSignOn.add(jbAgreeAdd);

        jpMain.add(jpSignOn);
        jpSignOn.setBounds(10, 60, dimesion.width, 300);
        jpSignOn.setVisible(false);
    }

    public void crearPanelShow() {
        jpShowMain = new JPanel(new BorderLayout());
        jpshow2 = new JPanel(new FlowLayout());
        jtShowData = new JTextArea(8, 40);
        jtShowData.setText(datosCliente.showData());
        jpscrollPanel = new JScrollPane(jtShowData);
        jpshow2.add(jpscrollPanel);
        jpShowMain.add(jpshow2, BorderLayout.CENTER);
        jpMain.add(jpShowMain);
        jpShowMain.setBounds(10, 60, dimesion.width, 200);
        jpShowMain.setVisible(false);

    }

    public void crearPanelDelete() {
        jpSignOff = new JPanel(new FlowLayout());
        jlDeleteID = new JLabel("DNI");
        jtDeleteID = new JTextArea("      ");
        jpSignOff.add(jlDeleteID);
        jpSignOff.add(jtDeleteID);
        jpSignOff.add(jbDeleteID);

        jpMain.add(jpSignOff);
        jpSignOff.setBounds(10, 60, dimesion.width, 200);

        jpSignOff.setVisible(false);
    }

    public void creapanelCambiar1() {
        jpChange1 = new JPanel(new FlowLayout());
        jlChangeID = new JLabel("DNI");
        jtChangeID = new JTextArea("      ");
        jpChange1.add(jlChangeID);
        jpChange1.add(jtChangeID);
        jpChange1.add(jbChangeID);

        jpMain.add(jpChange1);
        jpChange1.setBounds(10, 60, dimesion.width, 200);

        jpChange1.setVisible(false);
    }

    public void creapanelCambiar2() {
        jpChange2 = new JPanel(new GridLayout(6, 6, 5, 5));
        jlNameChange = new JLabel("nombre");
        jlLasNameChange = new JLabel("apellidos");
        jlIDChange = new JLabel("dni");
        jlAgeChange = new JLabel("años");
        jtNameChange = new JTextArea(" ");
        jtLasNameChange = new JTextArea(" ");
        jtIDChange = new JTextArea(" ");
        jtAgeChange = new JTextArea(" ");
        jpChange2.add(jlNameChange);
        jpChange2.add(jtNameChange);
        jpChange2.add(jlLasNameChange);
        jpChange2.add(jtLasNameChange);
        jpChange2.add(jlIDChange);
        jpChange2.add(jtIDChange);
        jpChange2.add(jlAgeChange);
        jpChange2.add(jtAgeChange);
        jpChange2.add(jbChange2);

        jpMain.add(jpChange2);
        jpChange2.setBounds(10, 60, dimesion.width, 300);
        jpChange2.setVisible(false);
    }

    public static void main(String[] args) {
        new Ventana();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbAlta) {
            jpMain.setComponentZOrder(jpSignOn, 0);
            jpSignOn.setVisible(true);
            jpShowMain.setVisible(false);
            jpChange1.setVisible(false);
            jpChange2.setVisible(false);
            jpSignOff.setVisible(false);
        } else if (e.getSource() == jbShow) {
            jpShowMain.removeAll();
            crearPanelShow();
            jpMain.setComponentZOrder(jpShowMain, 0);
            jpShowMain.setVisible(true);
            jpSignOn.setVisible(false);
            jpChange1.setVisible(false);
            jpChange2.setVisible(false);
            jpSignOff.setVisible(false);
        } else if (e.getSource() == jbChange) {
            jpMain.setComponentZOrder(jpChange1, 0);
            jpChange1.setVisible(true);
            jpShowMain.setVisible(false);
            jpSignOn.setVisible(false);
            jpChange2.setVisible(false);
            jpSignOff.setVisible(false);
        } else if (e.getSource() == jbChangeID) {
            int aux = Integer.parseInt(jtChangeID.getText().trim());
            boolean valido = datosCliente.delete(aux);
            if (valido) {
                jpMain.setComponentZOrder(jpChange2, 0);
                jpChange2.setVisible(true);
                jpChange1.setVisible(false);
                jpShowMain.setVisible(false);
                jpSignOn.setVisible(false);
                jpSignOff.setVisible(false);
            }
        } else if (e.getSource() == jbChange2) {
            Cliente aux = new Cliente();
            aux.setNombre(jtNameAdd.getText().trim());
            aux.setApellido(jtLasNameAdd.getText().trim());
            aux.setDni(Integer.parseInt(jtIDadd.getText().trim()));
            aux.setEdad(Integer.parseInt(jtAgeAdd.getText().trim()));
            if (datosCliente.add(aux)) {
                JOptionPane.showMessageDialog(this, "El cliente fue cambiado ", "ok", 1);
            } else {
                JOptionPane.showMessageDialog(this, "El cliente no fue cambiado ", "error", 1);
            }
        } else if (e.getSource() == jbBaja) {
            jpMain.setComponentZOrder(jpSignOff, 0);
            jpSignOff.setVisible(true);
            jpChange2.setVisible(false);
            jpChange1.setVisible(false);
            jpShowMain.setVisible(false);
            jpSignOn.setVisible(false);
        } else if (e.getSource() == jbAgreeAdd) {
            Cliente aux = new Cliente();
            aux.setNombre(jtNameAdd.getText().trim());
            aux.setApellido(jtLasNameAdd.getText().trim());
            aux.setDni(Integer.parseInt(jtIDadd.getText().trim()));
            aux.setEdad(Integer.parseInt(jtAgeAdd.getText().trim()));
            if (datosCliente.add(aux)) {
                JOptionPane.showMessageDialog(this, "Cliente fue añadido con exito", "OK", 1);
            } else {
                JOptionPane.showMessageDialog(this, "El cliente ya existe", "Error", 1);
            }
        } else if (e.getSource() == jbDeleteID) {
            int dni = Integer.parseInt(jtDeleteID.getText().trim());
            if (datosCliente.delete(dni)) {
                JOptionPane.showMessageDialog(this, "Cliente fue borrado con exito", "OK", 1);
            } else {
                JOptionPane.showMessageDialog(this, "El cliente no existe", "Error", 1);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        datosCliente.guardarCambios();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
