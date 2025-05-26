package uniajc.view;

import uniajc.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class PanelMatricula extends JFrame {

    private JTextField txtCodigoEst;
    private JLabel lblNombreEst;
    private JComboBox<Curso> comboCursos;
    private JButton btnRegistrar, btnLimpiar;

    public PanelMatricula() {
        setTitle("Registrar Matrícula");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblCod = new JLabel("Código Estudiante:");
        lblCod.setBounds(30, 30, 130, 25);
        add(lblCod);
        
        JLabel titulo = new JLabel("Matricular");
        titulo.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        titulo.setForeground(Color.RED);
        titulo.setBounds(200, -6, 300, 40);
        add(titulo);

        txtCodigoEst = new JTextField();
        txtCodigoEst.setBounds(170, 30, 150, 25);
        add(txtCodigoEst);

        JLabel lblNom = new JLabel("Nombre Estudiante:");
        lblNom.setBounds(30, 70, 130, 25);
        add(lblNom);

        lblNombreEst = new JLabel(" ");
        lblNombreEst.setBounds(170, 70, 200, 25);
        add(lblNombreEst);

        JLabel lblCurso = new JLabel("Cursos a Matricular:");
        lblCurso.setBounds(30, 110, 130, 25);
        add(lblCurso);

        comboCursos = new JComboBox<>();
        comboCursos.setBounds(170, 110, 180, 25);
        add(comboCursos);

        btnRegistrar = new JButton("Registrar Matrícula");
        btnRegistrar.setBounds(80, 170, 150, 30);
        add(btnRegistrar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(240, 170, 100, 30);
        add(btnLimpiar);

        cargarCursos();

        txtCodigoEst.addActionListener(e -> buscarEstudiante());

        txtCodigoEst.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                buscarEstudiante();
            }
        });

        btnRegistrar.addActionListener(e -> {
            try {
                int codEst = Integer.parseInt(txtCodigoEst.getText());
                Curso curso = (Curso) comboCursos.getSelectedItem();

                Matricula m = new Matricula(codEst, curso.getCodCurso(), 0.0f);
                GestorDeDatos dao = new GestorDeDatos();
                dao.insertarMatricula(m);

                JOptionPane.showMessageDialog(this, "Matrícula registrada correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al registrar matrícula: " + ex.getMessage());
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtCodigoEst.setText(" ");
            lblNombreEst.setText(" ");
        });

        setVisible(true);
    }

    private void buscarEstudiante() {
        try {
            int cod = Integer.parseInt(txtCodigoEst.getText());
            GestorDeDatos dao = new GestorDeDatos();
            Estudiante est = dao.buscarEstudiantePorCodigo(cod);
            if (est != null) {
                lblNombreEst.setText(est.getNomEstudiante());
            } else {
                lblNombreEst.setText("No encontrado");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código no válido.");
        }
    }

    private void cargarCursos() {
        GestorDeDatos dao = new GestorDeDatos();
        List<Curso> cursos = dao.obtenerCursos();
        for (Curso c : cursos) {
            comboCursos.addItem(c);
        }
    }
}
