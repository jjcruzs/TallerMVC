package uniajc.view;

import javax.swing.*;

public class PanelEstudiantes extends JFrame {
    public PanelEstudiantes() {
        setTitle("Registro de Estudiantes");
        setSize(300, 200);
        setLayout(null);

        JLabel lbl = new JLabel("Panel de Estudiantes");
        lbl.setBounds(60, 50, 200, 30);
        add(lbl);

        setVisible(true);
    }
}
