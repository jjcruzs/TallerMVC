package uniajc.view;

import javax.swing.*;

public class PanelMatricula extends JFrame {
    public PanelMatricula() {
        setTitle("Registro de Matrícula");
        setSize(300, 200);
        setLayout(null);

        JLabel lbl = new JLabel("Panel de Matrícula");
        lbl.setBounds(60, 50, 200, 30);
        add(lbl);

        setVisible(true);
        
          
    }
}
