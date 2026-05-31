# Dragon Race
Videojuego de carreras por turnos desarrollado en Java, como proyecto final de la asignatura Lógica de Programación y laboratorio del Instituto Tecnológico Metropolitano — ITM.


## Descripcion
Dragon Race es un juego de carreras donde el jugador compite contra una Mauina(el Dragón) a lo largo de un mapa generado aleatoriamente. En cada turno se tira un dado, se avanza por el mapa y se activan casillas que pueden ayudar o perjudicar al corredor. Gana quien llegue primero a la meta o quien deje al rival sin vidas.


## ¿Como se juega?

1. Ingresa tu nombre al iniciar el juego
2. Se genera un mapa aleatorio de entre 15 y 25 casillas
3. Cada turno presionas Enter para tirar el dado
4. Dependiendo de la casilla en la que caigas puede pasar:
    - **Normal** — no pasa nada, sigues avanzando
    - **Boost** — recibes un beneficio (escudo, vida extra, avance extra)
    - **Obstaculo** — sufres una penalización (pierdes vida, retrocedes, pierdes turno)
5. Gana el primero en llegar a la meta, o el que deje al rival sin vidas
6. Al terminar puedes jugar otra partida y el marcador acumula los resultados


## Arquitectura de Clases y Decisiones de Diseño

### -Jerarquía de Personajes

La clase base Personaje encapsula los atributos comunes a todo corredor: nombre, vidas, posición, escudo activo y turno congelado. Se optó por una clase base concreta (no abstracta) porque el array polimórfico de Main.java requiere un tipo común para iterar corredores sin conocer su subtipo.

Las clases hijas son:

Jugador: extiende Personaje y sobreescribe mover() para aplicar el efecto de la Poción de Velocidad (doble dado). Agrega el atributo dobleSiguiente para controlar este estado.

Maquina: extiende Personaje y sobreescribe mover() y tirarDado() para ajustar el rango del dado según la dificultad (Fácil: 1–4, Normal: 1–6, Difícil: 3–6). La dificultad se asigna aleatoriamente en el constructor.



### - Jerarquía de Casillas

La clase base Casilla representa una casilla genérica (inicio, normal, meta) con el método sobreescribible reaccionar(Personaje p). Las subclases especializan el comportamiento:

Boost: sobreescribe reaccionar() para aplicar uno de cuatro efectos positivos (Escoba Voladora, Poción de Velocidad, Escudo Mágico, Amuleto de vida).

Obstaculo: sobreescribe reaccionar() para aplicar efectos negativos (Trampa de Runas, Aliento de Dragón, Pantano Mágico, Portal Roto). Si el personaje tiene escudo activo, el obstáculo es bloqueado automáticamente.



### - Clases de Soporte

**Mapa:** genera el tablero de juego con longitud aleatoria (15–25 casillas). Posiciona casillas de inicio y meta, y distribuye aleatoriamente Obstaculos, Boosts y casillas normales en las posiciones intermedias.

**Marcador:** registra victorias del jugador, victorias de la máquina y empates entre partidas de la misma sesión.

**Main:** orquesta el flujo completo: creación de personajes, bucle de turnos con polimorfismo, detección de fin de partida y gestión del marcador.


## Conceptos utilizados
### -Clases y objetos 
— El proyecto tiene 9 clases, cada una en su propio archivo .java: Personaje, Jugador, Maquina, Casilla, Boost, Obstaculo, Mapa, Marcador y Main.
### -Constructores 
— Todos los objetos se instancian con new. Cada constructor inicializa sus atributos con this.. Los constructores hijos llaman a super() con los parámetros del padre.
### Encapsulación 
— Los atributos sensibles son private con getters y setters públicos. Por ejemplo, private int vidas con getVidas() y setVidas(), donde el setter valida que el valor esté entre 0 y 3.
### Herencia 
— Jugador y Maquina extienden Personaje. Boost y Obstaculo extienden Casilla. Todos los constructores hijos llaman a super() con los argumentos correspondientes.
### Polimorfismo 
— Main.java declara Personaje[] corredores = {jugador, maquina} y lo recorre con for-each. En cada iteración llama a corredor.mover(dado) y corredor.tirarDado(), y Java ejecuta la versión sobreescrita en Jugador o en Maquina según el tipo real del objeto. El mismo principio aplica a las casillas: el Mapa almacena Casilla[] y llama a casilla.reaccionar(corredor), ejecutando el comportamiento de Boost, Obstaculo o Casilla normal según corresponda.El mismo principio se aplica a las casillas: el Mapa almacena un array Casilla[] y llama a casilla.reaccionar(corredor). Según si la casilla es un Boost, un Obstaculo o una Casilla normal, se ejecuta el comportamiento correspondiente.
## Realizado por:
Kevin Alejandro Rincon Valencia - 
Nicolle Selena Goez Sanchez

