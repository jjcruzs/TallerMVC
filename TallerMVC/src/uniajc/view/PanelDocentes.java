package uniajc.view;

import javax.swing.*;

public class PanelDocentes extends JFrame {
    public PanelDocentes() {
        setTitle("Registro de Docentes");
        setSize(300, 200);
        setLayout(null);

        JLabel lbl = new JLabel("Panel de Docentes");
        lbl.setBounds(60, 50, 200, 30);
        add(lbl);

        setVisible(true);
    }  
}
