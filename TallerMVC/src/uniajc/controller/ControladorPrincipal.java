package uniajc.controller;

import uniajc.view.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorPrincipal {  

    private VistaPrincipal vista;

    public ControladorPrincipal(VistaPrincipal vista) {
        this.vista = vista;

        vista.itemEstudiantes.addActionListener(e -> {
            new PanelEstudiantes();
        });
        vista.itemDocentes.addActionListener(e -> {
            new PanelDocentes();
        });
        vista.itemCursos.addActionListener(e -> {
            new PanelCursos();
        });

        vista.menuCalificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new PanelCalificaciones();
            }
        });

        vista.menuListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new PanelListado();
            }
        });

        vista.menuMatricula.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new PanelMatricula();
            }
        });

    }
}
