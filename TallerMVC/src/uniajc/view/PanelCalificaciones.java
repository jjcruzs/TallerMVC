package uniajc.view;

import java.awt.Color;
import java.awt.Font;
import uniajc.model.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class PanelCalificaciones extends JFrame {

    private JComboBox<Estudiante> comboEstudiante;
    private JComboBox<Curso> comboCurso;
    private JTextField txtNota;
    private JButton btnGuardar;

    public PanelCalificaciones() {
        setTitle("Registro de Calificaciones");
        setSize(400, 250);
        setLayout(null);

        JLabel titulo = new JLabel("Calificaciones");
        titulo.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        titulo.setForeground(Color.RED);
        titulo.setBounds(200, -6, 300, 40);
        add(titulo);

        JLabel lblEstudiante = new JLabel("Estudiante:");
        lblEstudiante.setBounds(30, 30, 100, 25);
        add(lblEstudiante);

        comboEstudiante = new JComboBox<>();
        comboEstudiante.setBounds(140, 30, 200, 25);
        add(comboEstudiante);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(30, 70, 100, 25);
        add(lblCurso);

        comboCurso = new JComboBox<>();
        comboCurso.setBounds(140, 70, 200, 25);
        add(comboCurso);

        JLabel lblNota = new JLabel("Nota:");
        lblNota.setBounds(30, 110, 100, 25);
        add(lblNota);

        txtNota = new JTextField();
        txtNota.setBounds(140, 110, 200, 25);
        add(txtNota);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(140, 150, 100, 30);
        add(btnGuardar);

        cargarDatosEnCombos();
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Estudiante est = (Estudiante) comboEstudiante.getSelectedItem();
                Curso curso = (Curso) comboCurso.getSelectedItem();
                float nota;

                try {
                    nota = Float.parseFloat(txtNota.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese una nota válida (decimal).");
                    return;
                }

                GestorDeDatos dao = new GestorDeDatos();
                dao.actualizarNota(est.getCodEstudiante(), curso.getCodCurso(), nota);

                JOptionPane.showMessageDialog(null, "Calificación registrada correctamente.");
                txtNota.setText("");
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void cargarDatosEnCombos() {
        GestorDeDatos dao = new GestorDeDatos();

        List<Estudiante> estudiantes = dao.obtenerEstudiantes();
        for (Estudiante e : estudiantes) {
            comboEstudiante.addItem(e);
        }

        List<Curso> cursos = dao.obtenerCursos();
        for (Curso c : cursos) {
            comboCurso.addItem(c);
        }
    }
}
