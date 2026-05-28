package juego;
import Personajes.Personaje;
import Personajes.Jugador;
import Personajes.Maquina;
import casillas.Casilla;
import mapa.Mapa;
import java.util.Scanner;
import java.util.Random;
public class Main {
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("    DragonRace  ");
       System.out.println("Ingrese su nombre:");
       String nombreJugador = sc.nextLine();
       if(nombreJugador.isEmpty()){
           nombreJugador="JUGADOR";
       }
       Random r = new Random();
       Marcador marcador = new Marcador(nombreJugador);
       String respuesta = "s";
       while (respuesta.equalsIgnoreCase("s")){
           Jugador jugador = new Jugador(nombreJugador);
           Maquina maquina = new Maquina("Dragon ");
           int longitud = r.nextInt(11) + 15;
           Mapa mapa = new Mapa("Valle de los Dragones", longitud);
           int meta = mapa.getLongitud() - 1;
           System.out.println("\n   Partida #" + (marcador.getPartidasJugadas() + 1) + "   ");
           System.out.println(jugador);
           System.out.println(maquina);
           System.out.println("Meta en casilla: " + meta);
           mapa.mostrarMapa();
           Personaje[] corredores ={jugador,maquina};
           int turno=1;
           boolean fin=false;
           while(!fin){
               System.out.println("\nTurno: "+ turno+"  ");
               for (Personaje corredor:corredores){
                   System.out.println("\nTurno de: "+ corredor.getNombre());
                   if (corredor.isTurnoCongelado()) {
                       corredor.setTurnoCongelado(false);
                       System.out.println("congelado :Pierde este turno.");
                       continue;
                   }
                   if (corredor instanceof Jugador) {
                       System.out.print("Presiona enter para continuar");
                       sc.nextLine();
                   }
                   int dado = corredor.tirarDado();

                   corredor.mover(dado);
                   if (corredor.getPosicion() >= meta) {
                       corredor.setPosicion(meta);
                       System.out.println(corredor.getNombre() + " llego a la meta");
                       fin = true;
                       break;
                   }
                   Casilla casilla = mapa.getCasilla(corredor.getPosicion());
                   if (casilla != null) {
                       System.out.println("Casilla: " + casilla.getTipo() + " - " + casilla.getDescripcion());
                       System.out.println(casilla.reaccionar(corredor));
                   }
                   if (!corredor.estaVivo()) {
                       System.out.println(corredor.getNombre() + " perdio todas sus vidas");
                       fin = true;
                       break;
                   }
                   System.out.println(corredor);
               }
               if (!fin) {
                   turno++;
               }
           }
           System.out.println("      Resultados de la partida    ");
           if (!jugador.estaVivo()) {
               System.out.println("Gana: Dragon  (el jugador perdio todas las vidas)");
               marcador.registrarVictoriaMaquina();
           } else if (!maquina.estaVivo()) {
               System.out.println("Gana: " + jugador.getNombre() + " (El dragon perdio todas las vidas)");
               marcador.registrarVictoriaJugador();
           } else if (jugador.getPosicion() >= meta) {
               System.out.println("Gana: " + jugador.getNombre() + "  ");
               marcador.registrarVictoriaJugador();
           } else {
               System.out.println("GANA: Dragon");
               marcador.registrarVictoriaMaquina();
           }
           marcador.mostrarMarcador();
           System.out.println("\nQuieres jugar otra partida?(s/n)");
           respuesta=sc.nextLine();
       }
       System.out.println("\nResumen final:");
       marcador.mostrarMarcador();
       sc.close();

   }
}
