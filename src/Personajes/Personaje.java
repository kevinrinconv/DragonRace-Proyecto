package Personajes;

public class Personaje {

    private int vidas;
    public String nombre;
    protected int posicion;
    protected boolean escudoActivo;
    protected boolean turnoCongelado;

    public Personaje(String nombre,int vidas) {
        this.nombre          = nombre;
        this.vidas           = vidas;
        this.posicion        = 0;
        this.escudoActivo    = false;
        this.turnoCongelado  = false;
    }
    public String getNombre() {
        return nombre;
    }
    public int getVidas() {
        return vidas;
    }
    public void setVidas(int vidas) {
        if (vidas < 0) {
            vidas = 0;
        }
        if (vidas > 3){
            vidas = 3;
        }
        this.vidas = vidas;
    }
    public int  getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        if (posicion < 0) posicion = 0;
        this.posicion = posicion;
    }
    public boolean isEscudoActivo(){
        return escudoActivo;
    }
    public void setEscudoActivo(boolean escudoActivo){

        this.escudoActivo = escudoActivo;
    }

    public boolean isTurnoCongelado(){
        return turnoCongelado;
    }
    public void    setTurnoCongelado(boolean turnoCongelado){
        this.turnoCongelado = turnoCongelado;
    }

    public boolean estaVivo() {
        return vidas > 0;
    }

    public void mover(int dado) {

        this.posicion = this.posicion + dado ;
    }
    @Override
    public String toString() {
        return nombre + "Posicion: " + posicion + " Vidas: " + vidas;
    }
}
