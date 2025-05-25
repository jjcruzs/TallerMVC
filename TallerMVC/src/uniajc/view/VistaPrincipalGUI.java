package uniajc.view;

import javax.swing.*;

public class VistaPrincipalGUI extends JFrame {
    public JMenu menu;
    public JMenuBar barra;
    public JMenuItem itemEstudiantes, itemDocentes, itemCursos, itemMatricula;

    public VistaPrincipalGUI() {
        setTitle("Sistema Escolar");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        barra = new JMenuBar();
        menu = new JMenu("Administrar");  

        itemEstudiantes = new JMenuItem("Estudiantes");
        itemDocentes = new JMenuItem("Docentes");
        itemCursos = new JMenuItem("Cursos"); 
        itemMatricula = new JMenuItem("Matrícula");

        menu.add(itemEstudiantes);
        menu.add(itemDocentes);
        menu.add(itemCursos);
        menu.add(itemMatricula);
        barra.add(menu);

        setJMenuBar(barra);
        setVisible(true);
    }
}
