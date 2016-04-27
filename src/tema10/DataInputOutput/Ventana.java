package tema10.DataInputOutput;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener, WindowListener {

    private JPanel jpMain, jpTop, jpAdd, jpDelete;
    private JButton jbtAdd, jbtDelete, jbtChange, jbtshow, jbtAgreeAdd, jbtAgreeDel;
    private JTextArea jtName, jtLastName, jtDni, jtDniDel, jtAge;
    private JLabel jlName, jlLastName, jlDni, jlDniDel, jlAge;
    private Dimension dimesion;
    private CursorCliente datosFichero;
    private JScrollPane jscrollPanel;
    private JTable jTable;
    private JTextArea textArea;

    public Ventana() {
        datosFichero = new CursorCliente();
        jbtAdd = new JButton("Añadir");
        jbtAdd.addActionListener(this);
        jbtDelete = new JButton("Borrar");
        jbtDelete.addActionListener(this);
        jbtChange = new JButton("Cambiar");
        jbtshow = new JButton("Mostrar");
        jbtshow.addActionListener(this);
        jbtAgreeAdd = new JButton("ok");
        jbtAgreeAdd.addActionListener(this);
        jbtAgreeDel = new JButton("ok");
        jbtAgreeDel.addActionListener(this);
        dimesion = new Dimension(460, 250);

        jlName = new JLabel("Nombre: ");
        jlLastName = new JLabel("Apellidos: ");
        jlDni = new JLabel("DNI: ");
        jlDniDel = new JLabel("DNI: ");
        jlAge = new JLabel("Edad: ");

        jtName = new JTextArea("");
        jtLastName = new JTextArea("");
        jtDni = new JTextArea("");
        jtDniDel = new JTextArea("");
        jtAge = new JTextArea("");

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

    public void crearPanelMostrar() {
        textArea = new JTextArea(2, 2);
        jscrollPanel = new JScrollPane(textArea);
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
        } else if (e.getSource() == jbtDelete) {
            jpDelete.setVisible(true);
            jpAdd.setVisible(false);
        } else if (e.getSource() == jbtshow) {

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
        } else if (e.getSource() == jbtAgreeDel) {
            Cliente aux = new Cliente();
            int auxDni;
            auxDni = Integer.parseInt(jtDniDel.getText());
            aux.setDni(auxDni);
            datosFichero.delete(aux);
            borrarJtext();
        }

    }

    public void borrarJtext() {
        jtName.setText("");
        jtLastName.setText("");
        jtDni.setText("");
        jtAge.setText("");
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
