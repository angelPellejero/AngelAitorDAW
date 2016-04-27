package tema10.DataInputOutput;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener {

    private JPanel jpTop, jpAdd, jpDelete;
    private JButton jbtAdd, jbtDelete, jbtChange, jbtRight, jbtLeft, jbtAgree;
    private JTextArea jtName, jtLastName, jtDni, jtAge;
    private JLabel jlName, jlLastName, jlDni, jlAge;
    private Dimension dimesion;

    public Ventana() {
        jbtAdd = new JButton("Añadir");
        jbtAdd.addActionListener(this);
        jbtDelete = new JButton("Borrar");
        jbtChange = new JButton("Cambiar");
        jbtLeft = new JButton("<");
        jbtRight = new JButton(">");
        jbtAgree = new JButton("OK");

        dimesion = new Dimension(450, 150);

        jlName = new JLabel("Nombre: ");
        jlLastName = new JLabel("Apellidos: ");
        jlDni = new JLabel("DNI: ");
        jlAge = new JLabel("Edad: ");

        jtName = new JTextArea("");
        jtLastName = new JTextArea("");
        jtDni = new JTextArea("");
        jtAge = new JTextArea("");

        getContentPane().setLayout(new BorderLayout(5, 5));
        this.setSize(dimesion);

        jpTop = new JPanel(new FlowLayout());
        jpTop.add(jbtAdd);
        jpTop.add(jbtDelete);
        jpTop.add(jbtChange);
        jpTop.add(jbtLeft);
        jpTop.add(jbtRight);
        jpTop.add(jbtAgree);

        this.add(jpTop, BorderLayout.NORTH);

        crearPanelAdd();
        crearPanelDelete();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void crearPanelAdd() {
        jpAdd = new JPanel(new GridLayout(2, 2, 10, 10));
        jpAdd.add(jlName);
        jpAdd.add(jtName);
        jpAdd.add(jlLastName);
        jpAdd.add(jtLastName);
        jpAdd.add(jlAge);
        jpAdd.add(jtAge);
        jpAdd.add(jlDni);
        jpAdd.add(jtDni);
        this.add(jpAdd, BorderLayout.SOUTH);
        jpAdd.setVisible(false);
    }

    public void crearPanelDelete() {
        jpDelete = new JPanel(new GridLayout(2, 2, 10, 10));
        jpDelete.add(jlDni);
        jpDelete.add(jtDni);
        this.add(jpDelete, BorderLayout.SOUTH);
        jpDelete.setVisible(false);
    }

    public static void main(String[] args) {
        new Ventana();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton aux = (JButton) e.getSource();

        switch (aux.getText()) {
            case "Añadir":
                jpAdd.setVisible(true);
                jpDelete.setVisible(false);
                break;
            case "Borrar":
                jpDelete.setVisible(true);
                jpAdd.setVisible(false);
                break;
        }
    }
}
