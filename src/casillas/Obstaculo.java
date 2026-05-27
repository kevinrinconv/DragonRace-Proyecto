package casillas;

import Personajes.Personaje;

public class Obstaculo extends Casilla {

    private String nombreObstaculo;
    private int danio;

    public Obstaculo(String nombreObstaculo) {
        super ("Obstaculo", elegirDescripcion(nombreObstaculo));
        this.nombreObstaculo = nombreObstaculo;
        this.danio = 1;
    }

    public String getNombreObstaculo() {
        return nombreObstaculo;
    }

    public int getDanio() {
        return danio;
    }

    private static String elegirDescripcion(String nombre) {
        if(nombre.equals("Trampa de Runas")) {
            return "Una runa maldita te congela un turno";
        } else if (nombre.equals("Aliento de Dragon")) {
            return "Pierdes una vida";
        } else if (nombre.equals("Pantano Magico")) {
            return "Retrocedes 3 casillas";
        } else {
            return "Portal Roto: te teletransporta";
        }
    }

    @Override
    public String reaccionar(Personaje p) {
        String mensaje = "  ! " + p.getNombre() + " cayo en (" + nombreObstaculo + "): ";

        if (p.isEscudoActivo()) {
            p.setEscudoActivo(false);
            return mensaje + "El escudo bloqueo el efecto, (escudo consumido)";

        } else if (nombreObstaculo.equals("Trampa de Runas")) {
            p.setTurnoCongelado(true);
            return mensaje + "Congelado -Pierdes el siguiente turno.";

        } else if (nombreObstaculo.equals("Aliento de Dragon")) {
            p.setVidas(p.getVidas() - danio);
            return mensaje + "Perdiste una vida -Vidas restantes: " + p.getVidas();

        } else if (nombreObstaculo.equals("Pantano Magico")) {
            int nuevaPos = p.getPosicion() - 3;
            if (nuevaPos < 0) {
                nuevaPos = 0;
            }
            p.setPosicion(nuevaPos);
            return mensaje + "Retrocede 3 casillas- Nueva posicion: " + p.getPosicion();

        } else {
            int nuevaPos = (int) (Math.random() * 21);
            p.setPosicion(nuevaPos);
            return mensaje + "Teletransportando a la casilla " + nuevaPos + "!";
        }
    }

    @Override
    public String toString() {
        return "Obstaculo " + nombreObstaculo + " - " + getDescripcion();
    }
}
