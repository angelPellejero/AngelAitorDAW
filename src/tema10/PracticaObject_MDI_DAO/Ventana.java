package tema10.PracticaObject_MDI_DAO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class Ventana extends JInternalFrame implements ActionListener, InternalFrameListener {

    private JPanel jpMain, jpTop, jpAdd, jpDelete, jpChange, jpChange2, jpShowByNumberPlate;
    private JButton jbtAdd, jbtDelete, jbtChange, jbtShow, jbtshowLeft, jbtshowRight, jbtAgreeAdd, jbtAgreeDel, jbtChangeOne, jbtChangeTwo;
    private JButton jbShowByNumberPlate;
    private JTextArea jtName, jtNameChan2, jtKm, jtKmChan2, jtMatricula, jtMatriculaChan2, jtMatriculaDel, jtAge, jtAgeChan2, jtAgreeChange;
    private JLabel jlName, jlNameChan2, jlKm, jlKmChan2, jlMatricula, jlMatriculaChan2, jlMatriculaDel, jlAge, jlAgeChan2, jlMatriChange;
    private JLabel jlShowByNumberPlate;
    private Dimension dimesion;
    private DaoObjectStream datosFichero;
    private JScrollPane jscrollPanel;
    private JTextArea textArea, jtShowByNumberPlate;
    private static int posicion;

    public Ventana() {
        datosFichero = new DaoObjectStream();
        jbtAdd = new JButton("Alta");
        jbtAdd.addActionListener(this);
        jbtDelete = new JButton("baja");
        jbtDelete.addActionListener(this);
        jbtChange = new JButton("Cambiar");
        jbtShow = new JButton("Mostrar");
        jbtShow.addActionListener(this);
        jbtChange.addActionListener(this);
        jbtshowLeft = new JButton("<");
        jbtshowLeft.addActionListener(this);
        jbtshowRight = new JButton(">");
        jbtshowRight.addActionListener(this);
        jbtAgreeAdd = new JButton("ok");
        jbtAgreeAdd.addActionListener(this);
        jbtAgreeDel = new JButton("ok");
        jbtAgreeDel.addActionListener(this);
        jbtChangeOne = new JButton("ok");
        jbtChangeOne.addActionListener(this);
        jbtChangeTwo = new JButton("ok");
        jbtChangeTwo.addActionListener(this);
        jbShowByNumberPlate = new JButton("ok");
        jbShowByNumberPlate = new JButton("ok");
        dimesion = new Dimension(460, 250);

        jlName = new JLabel("Nombre: ");
        jlKm = new JLabel("Km: ");
        jlMatricula = new JLabel("Matricula: ");
        jlAge = new JLabel("Año: ");

        jlMatriculaDel = new JLabel("Matricula: ");

        jlNameChan2 = new JLabel("Nombre: ");
        jlKmChan2 = new JLabel("Km: ");
        jlMatriculaChan2 = new JLabel("Matricula: ");
        jlAgeChan2 = new JLabel("Año: ");

        jtName = new JTextArea("");
        jtKm = new JTextArea("");
        jtMatricula = new JTextArea("");
        jtMatriculaDel = new JTextArea("");
        jtAge = new JTextArea("");

        jtNameChan2 = new JTextArea("");
        jtKmChan2 = new JTextArea("");
        jtMatriculaChan2 = new JTextArea("");
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
        jpTop.add(jbtshowLeft);
        jpTop.add(jbtshowRight);
        jpTop.add(jbtShow);

        crearPanelAdd();
        crearPanelDelete();
        crearPanelMostrar();
        crearPanelCambiarDatos();
        crearPanelCambiarDatos2();

        addInternalFrameListener(this);//nuevo listener similar al de windowListener para el JInternalFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
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
        jpAdd.add(jlKm);
        jlKm.setBounds(10, 50, 60, 30);
        jpAdd.add(jtKm);
        jtKm.setBounds(80, 50, 130, 20);
        jpAdd.add(jlAge);
        jlAge.setBounds(230, 5, 60, 30);
        jpAdd.add(jtAge);
        jtAge.setBounds(280, 5, 130, 20);
        jpAdd.add(jlMatricula);
        jlMatricula.setBounds(230, 50, 60, 30);
        jpAdd.add(jtMatricula);
        jtMatricula.setBounds(280, 50, 130, 20);
        jpAdd.add(jbtAgreeAdd);
        jbtAgreeAdd.setBounds(280, 80, 50, 40);
        jpAdd.setVisible(false);
    }

    public void crearPanelCambiarDatos() {
        jpChange = new JPanel(null);
        jpMain.add(jpChange);
        jpChange.setBounds(10, 60, dimesion.width, 100);
        jlMatriChange = new JLabel("Matricula del barco a cambiar los datos: ");
        jlMatriChange.setBounds(10, 10, 250, 30);
        jpChange.add(jlMatriChange);
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
        jpChange2.add(jlKmChan2);
        jlKmChan2.setBounds(10, 50, 60, 30);
        jpChange2.add(jtKmChan2);
        jtKmChan2.setBounds(80, 50, 130, 20);
        jpChange2.add(jlAgeChan2);
        jlAgeChan2.setBounds(230, 5, 60, 30);
        jpChange2.add(jtAgeChan2);
        jtAgeChan2.setBounds(280, 5, 130, 20);
        jpChange2.add(jlMatriculaChan2);
        jlMatriculaChan2.setBounds(230, 50, 60, 30);
        jpChange2.add(jtMatriculaChan2);
        jtMatriculaChan2.setBounds(280, 50, 130, 20);
        jpChange2.add(jbtChangeTwo);
        jbtChangeTwo.setBounds(280, 80, 50, 40);

        jpChange2.setVisible(false);
    }

    public void crearPanelMostrar() {
        jpShowByNumberPlate = new JPanel(new FlowLayout());
        jtShowByNumberPlate = new JTextArea("    ");
        jlShowByNumberPlate = new JLabel("Matricula");
        jpShowByNumberPlate.add(jlShowByNumberPlate);
        jpShowByNumberPlate.add(jtShowByNumberPlate);
        jpShowByNumberPlate.add(jbShowByNumberPlate);

        textArea = new JTextArea(2, 2);
        jscrollPanel = new JScrollPane(textArea);
        textArea.setText(" ");//Mirar porque no cambian los datos aqui depurar
        jpMain.add(jpShowByNumberPlate);
        jpMain.add(jscrollPanel);
        jpShowByNumberPlate.setBounds(10, 60, dimesion.width - 35, 120);
        jscrollPanel.setBounds(10, 90, dimesion.width - 35, 120);
        jscrollPanel.setVisible(false);
        jpShowByNumberPlate.setVisible(false);
    }

    public void crearPanelDelete() {
        jpDelete = new JPanel(null);
        jpMain.add(jpDelete);
        jpDelete.setBounds(10, 60, dimesion.width, 100);
        jpDelete.add(jlMatriculaDel);
        jlMatriculaDel.setBounds(90, 30, 60, 30);
        jpDelete.add(jtMatriculaDel);
        jtMatriculaDel.setBounds(150, 30, 130, 20);
        jpDelete.add(jbtAgreeDel);
        jbtAgreeDel.setBounds(280, 60, 50, 40);
        jpDelete.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtAdd) {
            jpMain.setComponentZOrder(jpAdd, 1);
            jpAdd.setVisible(true);
            jpDelete.setVisible(false);
            jscrollPanel.setVisible(false);
            jpChange.setVisible(false);
            jpChange2.setVisible(false);
            jpShowByNumberPlate.setVisible(false);
        } else if (e.getSource() == jbtAgreeAdd) {//Dar de alta a un Barco
            Barco aux = new Barco();
            aux.setNombre_barco(jtName.getText());
            aux.setKm(Integer.parseInt(jtKm.getText()));
            aux.setMatricula(Integer.parseInt(jtMatricula.getText()));
            aux.setAnoFabricacion(Integer.parseInt(jtAge.getText()));
            if (datosFichero.alta(aux)) {
                JOptionPane.showMessageDialog(this, "Barco añadido con exito", "OK", 1);
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un Barco con esta natricula", "Error", 2);
            }
            borrarJtext();
        } else if (e.getSource() == jbtDelete) { //mostrar el panel de borrar barco por matricula
            jpMain.setComponentZOrder(jpDelete, 1);
            jpDelete.setVisible(true);
            jpAdd.setVisible(false);
            jscrollPanel.setVisible(false);
            jpChange.setVisible(false);
            jpChange2.setVisible(false);
            jpShowByNumberPlate.setVisible(false);
        } else if (e.getSource() == jbtAgreeDel) {//Pulsado el boton de borrar el barco
            int auxmatricula;
            auxmatricula = Integer.parseInt(jtMatriculaDel.getText());
            if (datosFichero.baja(auxmatricula)) {
                JOptionPane.showMessageDialog(this, "El Barco fue borrado con exito", "OK", 1);
            } else {
                JOptionPane.showMessageDialog(this, "Este Barco no existe", "Error", 2);
            }
            borrarJtext();
        } else if (e.getSource() == jbtChange) {
            jpMain.setComponentZOrder(jpChange, 1);
            jpChange.setVisible(true);
            jscrollPanel.setVisible(false);
            jpDelete.setVisible(false);
            jpAdd.setVisible(false);
            jpChange2.setVisible(false);
            jpShowByNumberPlate.setVisible(false);
        } else if (e.getSource() == jbtChangeOne) {
            int auxKM;
            Barco aux = new Barco();
            auxKM = Integer.parseInt(jtAgreeChange.getText());
            aux.setMatricula(auxKM);
            posicion = datosFichero.existeBarco(aux);
            borrarJtext();
            if (posicion != -1) {
                jpMain.setComponentZOrder(jpChange2, 1);
                jpChange2.setVisible(true);
                jpChange.setVisible(false);
                jpDelete.setVisible(false);
                jpAdd.setVisible(false);
                jpShowByNumberPlate.setVisible(false);
                jscrollPanel.setVisible(false);
            }
        } else if (e.getSource() == jbtChangeTwo) {
            Barco aux2 = new Barco();
            aux2.setNombre_barco(jtNameChan2.getText());
            aux2.setKm(Integer.parseInt(jtKmChan2.getText()));
            aux2.setMatricula(Integer.parseInt(jtMatriculaChan2.getText()));
            aux2.setAnoFabricacion(Integer.parseInt(jtAgeChan2.getText()));
            datosFichero.modificacion(posicion, aux2);
        } else if (e.getSource() == jbtShow) {//cada vez que se le da a mostrar genera de nuevo el area de texto por el tema de la acctualizacion de los datos
            jscrollPanel.removeAll();//se borra todo lo que tiene este  panel
            crearPanelMostrar();//se vuelve a crear el panel de mostrar con los datos acctuales
            jpMain.setComponentZOrder(jscrollPanel, 1);
            jscrollPanel.setVisible(true);
            jpShowByNumberPlate.setVisible(true);
            jpDelete.setVisible(false);
            jpAdd.setVisible(false);
            jpChange.setVisible(false);
            jpChange2.setVisible(false);
        }else if (e.getSource() == jbShowByNumberPlate){
            int auxMatricula;
            auxMatricula = Integer.parseInt(jtShowByNumberPlate.getText().trim());
            textArea.setText(datosFichero.consulta(auxMatricula));
        }
    }

    public void borrarJtext() {
        jtName.setText("");
        jtKm.setText("");
        jtMatricula.setText("");
        jtAge.setText("");
        jtMatriculaDel.setText("");
        jtNameChan2.setText("");
        jtKmChan2.setText("");
        jtMatriculaChan2.setText("");
        jtAgeChan2.setText("");
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        datosFichero.salvarDatos();
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }
}
