package Personajes;
import java.util.Random;
public class Jugador extends Personaje{
    private boolean dobleSiguiente;

    public Jugador(String nombre) {
        super(nombre,3);
        this.dobleSiguiente = false;
    }

    public boolean isDobleSiguiente()        {

        return dobleSiguiente;
    }
    public void    setDobleSiguiente (boolean dobleSiguiente ){
        this.dobleSiguiente = dobleSiguiente;
    }
    public int tirarDado(){
        Random random=new Random();
        return random.nextInt(6)+1;

    }
    @Override
    public void mover(int dado){
        int movimiento=dado;
        if (dobleSiguiente) {
            movimiento= dado * 2;
            dobleSiguiente = false;
            System.out.println( getNombre() + " usa Pocion de Velocidad se mueve " + movimiento + " casillas");
        }
        setPosicion(getPosicion()+movimiento);
    }
    @Override
    public String toString() {
        return "JUGADOR " + super.toString();
    }

}
