package uniajc.controller;

import uniajc.view.VistaPrincipal;

public class TallerMVC {

    public static void main(String[] args) { 
        VistaPrincipal vista = new VistaPrincipal();
        new ControladorPrincipal(vista);
    }
}
