package mapa;

import casillas.Casilla;
import casillas.Obstaculo;
import casillas.Boost;

public class Mapa {

    private String nombre;
    private int longitud;
    private Casilla[] casillas;

    public Mapa(String nombre, int longitud) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.casillas = new Casilla[longitud];

        casillas[0] = new Casilla("Inicio", "Punto de partida");
        casillas[0].setPosicionEnMapa(0);

        for (int i = 1; i < longitud - 1; i++) {
            int numero = (int)(Math.random() * 3);

            if (numero == 0) {
                casillas[i] = new Obstaculo("Aliento de Dragon");
            } else if (numero == 1) {
                casillas[i] = new Boost("Escudo Magico");
            } else {
                casillas[i] = new Casilla("Normal", "Camino libre");
            }

            casillas[i].setPosicionEnMapa(i);
        }

        casillas[longitud - 1] = new Casilla("Meta", "Linea de meta");
        casillas[longitud - 1].setPosicionEnMapa(longitud - 1);
    }

    public String getNombre() {
        return nombre;
    }

    public int getLongitud() {
        return longitud;
    }

    public Casilla getCasilla(int posicion) {
        if(posicion < 0 || posicion >= longitud) {
            return null;
        }
        return casillas[posicion];
    }

    public void mostrarMapa() {
        System.out.println("Mapa: " + nombre + " | " + longitud + " casillas");

        for(int i = 0; i < longitud; i++) {
            System.out.println(" [" + i + "] " + casillas[i].getTipo() + " - " + casillas[i].getDescripcion());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Mapa: " + nombre + "  longitud:" + longitud;
    }
}
