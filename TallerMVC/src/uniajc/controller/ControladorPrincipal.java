package uniajc.controller;

import uniajc.view.*;

public class ControladorPrincipal {
    private VistaPrincipalGUI vista;

    public ControladorPrincipal(VistaPrincipalGUI vista) {
        this.vista = vista;

        vista.itemEstudiantes.addActionListener(e -> new PanelEstudiantes());
        vista.itemDocentes.addActionListener(e -> new PanelDocentes());
        vista.itemCursos.addActionListener(e -> new PanelCursos());
        vista.itemMatricula.addActionListener(e -> new PanelMatricula());   
    }
}
