package uniajc.view;

import java.awt.Color;
import java.awt.Font;
import uniajc.model.*;

import javax.swing.*;
import java.util.List;

public class PanelCursos extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JComboBox<Docente> comboDocente;
    private JButton btnGuardar;

    public PanelCursos() {
        setTitle("Registro de Cursos");
        setSize(450, 250);
        setLayout(null);
        JLabel titulo = new JLabel("Curso");
        titulo.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        titulo.setForeground(Color.RED);
        titulo.setBounds(235, -6, 300, 40);
        add(titulo);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 30, 100, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(140, 30, 250, 25);
        add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 70, 250, 25);
        add(txtNombre);

        JLabel lblDocente = new JLabel("Docente:");
        lblDocente.setBounds(30, 110, 100, 25);
        add(lblDocente);

        comboDocente = new JComboBox<>();
        comboDocente.setBounds(140, 110, 250, 25);
        add(comboDocente);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(140, 150, 100, 30);
        add(btnGuardar);

        cargarDocentes();

        btnGuardar.addActionListener(e -> {
            int cod = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText();
            Docente docente = (Docente) comboDocente.getSelectedItem();
            Curso curso = new Curso(cod, nombre, docente.getCodDocente());
            new GestorDeDatos().insertarCurso(curso);
            JOptionPane.showMessageDialog(null, "Curso guardado.");
            txtCodigo.setText("");
            txtNombre.setText("");
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void cargarDocentes() {
        List<Docente> lista = new GestorDeDatos().obtenerDocentes();
        for (Docente d : lista) {
            comboDocente.addItem(d);
        }
    }
}
