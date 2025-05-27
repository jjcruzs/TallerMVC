package uniajc.view;

import uniajc.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelListado extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton btnActualizar, btnEliminar;

    public PanelListado() {
        setTitle("Listado de Matrículas"); 
        setSize(700, 450);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear modelo de la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("Código Estudiante");
        modelo.addColumn("Nombre Estudiante");
        modelo.addColumn("Curso");
        modelo.addColumn("Nota");

        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        // Panel de botones abajo
        JPanel panelBotones = new JPanel();
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar Matrícula");

        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);

        add(panelBotones, BorderLayout.SOUTH);

        btnActualizar.addActionListener(e -> actualizarTabla());

        btnEliminar.addActionListener(e -> eliminarMatriculaSeleccionada());

        actualizarTabla();
        setVisible(true);
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        GestorDeDatos dao = new GestorDeDatos();
        List<String[]> datos = dao.obtenerListadoMatriculas();
        for (String[] fila : datos) {
            modelo.addRow(fila);
        }
    }

    private void eliminarMatriculaSeleccionada() {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int codEst = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
            String nombreCurso = modelo.getValueAt(fila, 2).toString();

            GestorDeDatos dao = new GestorDeDatos();
            List<Curso> cursos = dao.obtenerCursos();
            int codCurso = -1;
            for (Curso c : cursos) {
                if (c.getNomCurso().equals(nombreCurso)) {
                    codCurso = c.getCodCurso();
                    break;
                }
            }

            if (codCurso != -1) {
                int confirm = JOptionPane.showOptionDialog(
                        this,
                        "¿Está segura/o que desea eliminar la matrícula del estudiante " + codEst + " en el curso " + nombreCurso + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Eliminar", "Cancelar"},
                        "Cancelar"
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    dao.eliminarMatricula(codEst, codCurso);
                    modelo.removeRow(fila);
                    JOptionPane.showMessageDialog(this, "Matrícula eliminada correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el código del curso.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
        }
    }
}
