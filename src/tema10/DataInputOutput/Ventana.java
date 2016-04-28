package tema10.DataInputOutput;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener, WindowListener {

    private JPanel jpMain, jpTop, jpAdd, jpDelete, jpChange, jpChange2;
    private JButton jbtAdd, jbtDelete, jbtChange, jbtshow, jbtAgreeAdd, jbtAgreeDel, jbtChangeOne, jbtChangeTwo;
    private JTextArea jtName, jtNameChan2, jtLastName, jtLastNameChan2, jtDni, jtDniChan2, jtDniDel, jtAge, jtAgeChan2, jtAgreeChange;
    private JLabel jlName, jlNameChan2, jlLastName, jlLastNameChan2, jlDni, jlDniChan2, jlDniDel, jlAge, jlAgeChan2, jlDniChange;
    private Dimension dimesion;
    private CursorCliente datosFichero;
    private JScrollPane jscrollPanel;
    private JTextArea textArea;
    private static int posicion;

    public Ventana() {
        datosFichero = new CursorCliente();
        jbtAdd = new JButton("Añadir");
        jbtAdd.addActionListener(this);
        jbtDelete = new JButton("Borrar");
        jbtDelete.addActionListener(this);
        jbtChange = new JButton("Cambiar");
        jbtChange.addActionListener(this);
        jbtshow = new JButton("Mostrar");
        jbtshow.addActionListener(this);
        jbtAgreeAdd = new JButton("ok");
        jbtAgreeAdd.addActionListener(this);
        jbtAgreeDel = new JButton("ok");
        jbtAgreeDel.addActionListener(this);
        jbtChangeOne = new JButton("ok");
        jbtChangeOne.addActionListener(this);
        jbtChangeTwo = new JButton("ok");
        jbtChangeTwo.addActionListener(this);
        dimesion = new Dimension(460, 250);

        jlName = new JLabel("Nombre: ");
        jlLastName = new JLabel("Apellidos: ");
        jlDni = new JLabel("DNI: ");
        jlAge = new JLabel("Edad: ");

        jlDniDel = new JLabel("DNI: ");

        jlNameChan2 = new JLabel("Nombre: ");
        jlLastNameChan2 = new JLabel("Apellidos: ");
        jlDniChan2 = new JLabel("DNI: ");
        jlAgeChan2 = new JLabel("Edad: ");

        jtName = new JTextArea("");
        jtLastName = new JTextArea("");
        jtDni = new JTextArea("");
        jtDniDel = new JTextArea("");
        jtAge = new JTextArea("");

        jtNameChan2 = new JTextArea("");
        jtLastNameChan2 = new JTextArea("");
        jtDniChan2 = new JTextArea("");
        jtAgeChan2 = new JTextArea("");

        jpMain = new JPanel(null);
        this.add(jpMain);
        this.setSize(dimesion);

        jpTop = new JPanel(new FlowLayout());
        jpMain.add(jpTop);
        jpTop.setBounds(10, 10, dimesion.width - 25, 40);
        jpTop.add(jbtAdd);
        jpTop.add(jbtDelete);
        jpTop.add(jbtChange);
        jpTop.add(jbtshow);

        crearPanelAdd();
        crearPanelDelete();
        crearPanelMostrar();
        crearPanelCambiarDatos();
        crearPanelCambiarDatos2();

        this.addWindowListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void crearPanelAdd() {
        jpAdd = new JPanel(null);
        jpMain.add(jpAdd);
        jpAdd.setBounds(10, 60, dimesion.width, 300);
        jpAdd.add(jlName);
        jlName.setBounds(10, 5, 60, 30);
        jpAdd.add(jtName);
        jtName.setBounds(80, 5, 130, 20);
        jpAdd.add(jlLastName);
        jlLastName.setBounds(10, 50, 60, 30);
        jpAdd.add(jtLastName);
        jtLastName.setBounds(80, 50, 130, 20);
        jpAdd.add(jlAge);
        jlAge.setBounds(230, 5, 60, 30);
        jpAdd.add(jtAge);
        jtAge.setBounds(280, 5, 130, 20);
        jpAdd.add(jlDni);
        jlDni.setBounds(230, 50, 60, 30);
        jpAdd.add(jtDni);
        jtDni.setBounds(280, 50, 130, 20);
        jpAdd.add(jbtAgreeAdd);
        jbtAgreeAdd.setBounds(280, 80, 50, 40);
        jpAdd.setVisible(false);
    }

    public void crearPanelCambiarDatos() {
        jpChange = new JPanel(null);
        jpMain.add(jpChange);
        jpChange.setBounds(10, 60, dimesion.width, 100);
        jlDniChange = new JLabel("DNI del usuario a cambiar los datos: ");
        jlDniChange.setBounds(10, 10, 250, 30);
        jpChange.add(jlDniChange);
        jtAgreeChange = new JTextArea("");
        jtAgreeChange.setBounds(100, 50, 130, 20);
        jpChange.add(jtAgreeChange);
        jbtChangeOne.setBounds(250, 50, 50, 50);
        jpChange.add(jbtChangeOne);
        jpChange.setVisible(false);
    }

    public void crearPanelCambiarDatos2() {
        jpChange2 = new JPanel(null);
        jpMain.add(jpChange2);
        jpChange2.setBounds(10, 60, dimesion.width, 300);
        jpChange2.add(jlNameChan2);
        jlNameChan2.setBounds(10, 5, 60, 30);
        jpChange2.add(jtNameChan2);
        jtNameChan2.setBounds(80, 5, 130, 20);
        jpChange2.add(jlLastNameChan2);
        jlLastNameChan2.setBounds(10, 50, 60, 30);
        jpChange2.add(jtLastNameChan2);
        jtLastNameChan2.setBounds(80, 50, 130, 20);
        jpChange2.add(jlAgeChan2);
        jlAgeChan2.setBounds(230, 5, 60, 30);
        jpChange2.add(jtAgeChan2);
        jtAgeChan2.setBounds(280, 5, 130, 20);
        jpChange2.add(jlDniChan2);
        jlDniChan2.setBounds(230, 50, 60, 30);
        jpChange2.add(jtDniChan2);
        jtDniChan2.setBounds(280, 50, 130, 20);
        jpChange2.add(jbtChangeTwo);
        jbtChangeTwo.setBounds(280, 80, 50, 40);

        jpChange2.setVisible(false);
    }

    public void crearPanelMostrar() {
        textArea = new JTextArea(2, 2);
        jscrollPanel = new JScrollPane(textArea);
        textArea.setText(datosFichero.mostrarDatos());//rellenar el tex Area con lso datos del fichero
        jpMain.add(jscrollPanel);
        jscrollPanel.setBounds(10, 60, dimesion.width - 35, 120);
        jscrollPanel.setVisible(false);
    }

    public void crearPanelDelete() {
        jpDelete = new JPanel(null);
        jpMain.add(jpDelete);
        jpDelete.setBounds(10, 60, dimesion.width, 100);
        jpDelete.add(jlDniDel);
        jlDniDel.setBounds(110, 30, 60, 30);
        jpDelete.add(jtDniDel);
        jtDniDel.setBounds(150, 30, 130, 20);
        jpDelete.add(jbtAgreeDel);
        jbtAgreeDel.setBounds(280, 60, 50, 40);
        jpDelete.setVisible(false);
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbtAdd) {
            jpAdd.setVisible(true);
            jpDelete.setVisible(false);
            jscrollPanel.setVisible(false);
            jpChange.setVisible(false);
            jpChange2.setVisible(false);
        } else if (e.getSource() == jbtDelete) {
            jpDelete.setVisible(true);
            jpAdd.setVisible(false);
            jscrollPanel.setVisible(false);
            jpChange.setVisible(false);
            jpChange2.setVisible(false);
        } else if (e.getSource() == jbtChange) {
            jpChange.setVisible(true);
            jscrollPanel.setVisible(false);
            jpDelete.setVisible(false);
            jpAdd.setVisible(false);
            jpChange2.setVisible(false);

        } else if (e.getSource() == jbtshow) {
            jscrollPanel.setVisible(true);
            jpDelete.setVisible(false);
            jpAdd.setVisible(false);
            jpChange.setVisible(false);
            jpChange2.setVisible(false);

        } else if (e.getSource() == jbtAgreeAdd) {//crear nuevo cliente
            Cliente aux = new Cliente();
            int auxDni, auxEdad;
            aux.setNombre(jtName.getText());
            aux.setApellido(jtLastName.getText());
            auxDni = Integer.parseInt(jtDni.getText());
            aux.setDni(auxDni);
            auxEdad = Integer.parseInt(jtAge.getText());
            aux.setEdad(auxEdad);
            datosFichero.add(aux);
            borrarJtext();
        } else if (e.getSource() == jbtAgreeDel) {//borrar cliente
            Cliente aux = new Cliente();
            int auxDni;
            auxDni = Integer.parseInt(jtDniDel.getText());
            aux.setDni(auxDni);
            datosFichero.delete(aux);
            borrarJtext();
        } else if (e.getSource() == jbtChangeOne) {
            int dniAUX;
            Cliente aux = new Cliente();
            dniAUX = Integer.parseInt(jtAgreeChange.getText());
            aux.setDni(dniAUX);
            posicion = datosFichero.userExists(aux);
            borrarJtext();
            if (posicion != -1) {
                jpChange2.setVisible(true);
                jpChange.setVisible(false);
                jscrollPanel.setVisible(false);
                jpDelete.setVisible(false);
                jpAdd.setVisible(false);
            }
        } else if (e.getSource() == jbtChangeTwo) {
            int auxDni, auxEdad;
            Cliente aux2 = new Cliente();
            aux2.setNombre(jtNameChan2.getText());
            aux2.setApellido(jtLastNameChan2.getText());
            auxDni = Integer.parseInt(jtDniChan2.getText());
            aux2.setDni(auxDni);
            auxEdad = Integer.parseInt(jtAgeChan2.getText());
            aux2.setEdad(auxEdad);
            datosFichero.cambiarDatos(posicion, aux2);
        }

    }

    public void cambiarUsuario2() {

    }

    public void borrarJtext() {
        jtName.setText("");
        jtLastName.setText("");
        jtDni.setText("");
        jtAge.setText("");
        jtDniDel.setText("");
        jtNameChan2.setText("");
        jtLastNameChan2.setText("");
        jtDniChan2.setText("");
        jtAgeChan2.setText("");

    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        datosFichero.guardarDatos();
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
