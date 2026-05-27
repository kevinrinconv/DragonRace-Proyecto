package casillas;

import Personajes.Jugador;
import Personajes.Personaje;

import java.util.Random;

public class Boost extends Casilla {

    private String nombreBoost;
    private int valor;

    public Boost(String nombreBoost) {
        super("Boost", elegirDescripcion(nombreBoost));
        this.nombreBoost = nombreBoost;
        Random rand = new Random();
        this.valor = rand.nextInt(6) + 1;
    }
    public String getNombreBoost()  {
        return nombreBoost;
    }

    public int getValor()  {
        return valor;
    }

    private static String elegirDescripcion(String nombre)  {
        if(nombre.equals("Escoba Voladora"))  {
            return "Avanzas " + " casillas extra";
        } else if(nombre.equals("Pocion de Velocidad"))  {
            return "Doblas el dado del siguiente turno";
        } else if (nombre.equals("Escudo Magico"))  {
            return "Bloqueas el proximo obstaculo";
        } else  {
            return "Amuleto: recuperas 1 vida";
        }
    }

    @Override
    public String reaccionar(Personaje p) {
        String mensaje = "  * " + p.getNombre() + " obtuvo (" + nombreBoost + "): ";

        if(nombreBoost.equals("Escoba Voladora")) {
            p.setPosicion(p.getPosicion() + valor);
            return mensaje + "Avanza " + valor + " casillas extra, Nueva posicion: " + p.getPosicion();

        } else if (nombreBoost.equals("Pocion de Velocidad")) {
            if(p instanceof Jugador) {
                Jugador jugador = (Jugador) p;
                jugador.setDobleSiguiente(true);
            }
            return mensaje + "El siguiente dado sera el doble" ;

        }else if (nombreBoost.equals("Escudo Magico")) {
            p.setEscudoActivo(true);
            return mensaje + "Escudo activado, El proximo obstaculo sera bloqueado.";

        } else {
            p.setVidas(p.getVidas() + 1);
            return mensaje + "Vida recuperada, vidas: " + p.getVidas();
        }
    }
    @Override
    public String toString() {
        return "Boost " + nombreBoost + " - " + getDescripcion();
    }
}
