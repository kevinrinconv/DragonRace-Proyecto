package casillas;

import Personajes.Personaje;

public class Casilla {
    private String tipo;
    private String descripcion;
    private int posicionEnMapa;

    public Casilla(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.posicionEnMapa = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPosicionEnMapa() {
        return posicionEnMapa;
    }

    public void setPosicionEnMapa(int posicion) {
        this.posicionEnMapa = posicion;
    }

    public String reaccionar(Personaje p) {
        return p.getNombre() + " paso por una casilla normal. Sin efecto.";
    }

    @Override
    public String toString() {
        return "(" + tipo + ") " + descripcion;
    }
}
