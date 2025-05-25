package uniajc.controller;

import uniajc.view.VistaPrincipalGUI;

public class TallerMVC {
    public static void main(String[] args) {
        VistaPrincipalGUI vista = new VistaPrincipalGUI();  
        new ControladorPrincipal(vista); 
    }
}
