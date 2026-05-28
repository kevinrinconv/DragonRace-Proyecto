package Personajes;
import java.util.Random;

public class Maquina extends Personaje{
    public String dificultad;
    public Maquina(String nombre){
        super(nombre,3);
        this.dificultad=dificultadRam();
    }

    public String getNivelDificultad() {
        return dificultad;
    }
    private String dificultadRam() {
        Random random = new Random();
        int n = random.nextInt(3);
        if (n == 0){
            return "Facil";
        }
        if (n == 1){
            return "Normal";
        }
        return "Dificil";
    }
    public int tirarDado() {
        Random random = new Random();
        if (dificultad.equals("Facil")) {
            return random.nextInt(4) + 1;
        }
        if (dificultad.equals("Dificil")){
            return random.nextInt(4) + 3;
        }else {
            return random.nextInt(6) + 1;
        }
    }
    @Override
    public void mover(int dado) {
        setPosicion(getPosicion() + dado);
    }
    @Override
    public String toString() {
        return "Maquina-" + dificultad + " " + super.toString();
    }



}
