package uniajc.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class VistaPrincipal extends JFrame {

    public JMenu menuCalificaciones, menuListado, menuMatricula;
    public JMenuItem itemEstudiantes, itemDocentes, itemCursos;

    public VistaPrincipal() {
        setTitle("Sistema Escolar");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);

        JLabel titulo = new JLabel("Sistema Escolar");
        titulo.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        titulo.setForeground(Color.RED);
        titulo.setBounds(145, 95, 300, 40);
        add(titulo);

        JMenuBar barra = new JMenuBar();

        JMenu menuIngresar = new JMenu("Ingresar");

        itemEstudiantes = new JMenuItem("Estudiantes");
        itemDocentes = new JMenuItem("Docentes");
        itemCursos = new JMenuItem("Cursos");

        menuIngresar.add(itemEstudiantes);
        menuIngresar.add(itemDocentes);
        menuIngresar.add(itemCursos);

        menuMatricula = new JMenu("Matrícular");

        menuCalificaciones = new JMenu("Ingreso Notas");
        menuListado = new JMenu("Listado");

        barra.add(menuIngresar);
        barra.add(menuMatricula);
        barra.add(menuCalificaciones);
        barra.add(menuListado);

        setJMenuBar(barra);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
