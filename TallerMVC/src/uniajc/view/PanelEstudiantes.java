package uniajc.view;

import java.awt.Color;
import java.awt.Font;
import uniajc.model.*;

import javax.swing.*;

public class PanelEstudiantes extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JButton btnGuardar;

    public PanelEstudiantes() {
        setTitle("Registro de Estudiantes"); 
        setSize(400, 200);
        setLayout(null);
        JLabel titulo = new JLabel("Estudiante");
        titulo.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        titulo.setForeground(Color.RED);
        titulo.setBounds(200, -6, 300, 40);
        add(titulo);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 30, 100, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(140, 30, 200, 25);
        add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 70, 200, 25);
        add(txtNombre);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(140, 110, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            int cod = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText();
            Estudiante est = new Estudiante(cod, nombre);
            new GestorDeDatos().insertarEstudiante(est);
            JOptionPane.showMessageDialog(null, "Estudiante guardado.");
            txtCodigo.setText("");
            txtNombre.setText("");
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }
}
