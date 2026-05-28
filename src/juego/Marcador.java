package juego;

public class Marcador {

    private String nombreJugador;
    private int victoriasJugador;
    private int victoriasMaquina;
    private int empates;
    private int partidasJugadas;

    public Marcador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.victoriasJugador = 0;
        this.victoriasMaquina = 0;
        this.empates = 0;
        this.partidasJugadas = 0;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getVictoriasJugador() {
        return victoriasJugador;
    }

    public int getVictoriasIA() {
        return victoriasMaquina;
    }

    public int getEmpates() {
        return empates;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void registrarVictoriaJugador() {
        victoriasJugador++;
        partidasJugadas++;
    }

    public void registrarVictoriaMaquina() {
        victoriasMaquina++;
        partidasJugadas++;
    }

    public void registrarEmpate() {
        empates++;
        partidasJugadas++;
    }

    public void mostrarMarcador() {
        System.out.println("Marcador");
        System.out.println("Partidas jugadas: " + partidasJugadas);
        System.out.println(nombreJugador + " : " + victoriasJugador + " victorias");
        System.out.println("Dragon: " + victoriasMaquina+ " victorias");
    }

    @Override
    public String toString() {
        return nombreJugador + " : " + victoriasJugador + "  Dragon:  " + victoriasMaquina + "  Empates: " + empates;
    }
}
