
import uniajc.modelo.Acuatico;
import uniajc.modelo.Terrestre;

public class Main {
    public static void main(String[] args) {
        
        Terrestre camioneta = new Terrestre(50, 120, 4, "civil");
        camioneta.acelerar(30);
        camioneta.frenar(20);
        camioneta.imprimir();
        System.out.println("Revoluciones motor camioneta: " + camioneta.calcularRevolucionesMotor(10, 5));
        System.out.println();

     
        Acuatico motoAcuatica = new Acuatico(50, 110, "superficie", 2);
        motoAcuatica.acelerar(40);
        motoAcuatica.frenar(30);
        motoAcuatica.recomendarVelocidad(90); 
        motoAcuatica.imprimir();
        System.out.println("Revoluciones motor moto acuática: " + motoAcuatica.calcularRevolucionesMotor(8, 6));
    }
}
