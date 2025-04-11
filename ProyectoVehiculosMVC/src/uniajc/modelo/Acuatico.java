package uniajc.modelo;


import uniajc.modelo.Vehiculo;
import uniajc.modelo.Vela;

public class Acuatico extends Vehiculo implements Vela {
    private String tipo;
    private int capacidadPasajeros;

    public Acuatico(int velocidadActual, int velocidadMaxima, String tipo, int capacidadPasajeros) {
        super(velocidadActual, velocidadMaxima);
        this.tipo = tipo;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public void acelerar(int velocidad) {
        velocidadActual = Math.min(velocidadActual + velocidad, velocidadMaxima);
    }

    @Override
    public void frenar(int velocidad) {
        velocidadActual = Math.max(velocidadActual - velocidad, 0);
    }

    public void recomendarVelocidad(int velocidadViento) {
        if (velocidadViento > 80) {
            System.out.println("Viento muy fuerte. No se recomienda navegar.");
            velocidadActual = 0;
        } else if (velocidadViento < 10) {
            System.out.println("Viento muy débil. No se recomienda navegar.");
        } else {
            System.out.println("Condiciones adecuadas para navegar.");
        }
    }

    public int calcularRevolucionesMotor(int fuerza, int radio) {
        return fuerza * radio;
    }
}
