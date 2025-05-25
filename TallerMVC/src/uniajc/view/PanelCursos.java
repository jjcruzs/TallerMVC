package uniajc.view;

import javax.swing.*;

public class PanelCursos extends JFrame {
    public PanelCursos() {
        setTitle("Registro de Cursos");
        setSize(300, 200);
        setLayout(null);

        JLabel lbl = new JLabel("Panel de Cursos");
        lbl.setBounds(60, 50, 200, 30);
        add(lbl);

        setVisible(true);  
    }
}
