package uniajc.modelo;

public class Terrestre extends Vehiculo implements Motor {
    private int cantidadLlantas;
    private String uso;

    public Terrestre(int velocidadActual, int velocidadMaxima, int cantidadLlantas, String uso) {
        super(velocidadActual, velocidadMaxima);
        this.cantidadLlantas = cantidadLlantas;
        this.uso = uso;
    }

    @Override
    public void acelerar(int velocidad) {
        velocidadActual = Math.min(velocidadActual + velocidad, velocidadMaxima);
    }

    @Override
    public void frenar(int velocidad) {
        velocidadActual = Math.max(velocidadActual - velocidad, 0);
    }

    public int calcularRevolucionesMotor(int fuerza, int radio) {
        return fuerza * radio;
    }
}
