import java.util.Random;
import java.util.Scanner;

public class Principal {

    // Atributos de clase
    public static Scanner in = new Scanner(System.in);
    static Random ran = new Random();
    static String br = ("_________________________________________________________________________");
    static String vacio = "----------";
    static boolean gameStatus = true;

    // Metodos de clase
    public static void tablero() {
        // Generar Tablero de juego
        String[][] pos = new String[2][2];

        for (int i = 0; i < Tanques.tank.length; i++) {
            for (int j = 0; j < Tanques.tank[i].length; j++) {
                if (Tanques.tank[i][j] != null) {
                    if (Tanques.tank[i][j].vidaStatus()) {
                        pos[i][j] = Tanques.tank[i][j].getTank();
                    } else {
                        pos[i][j] = vacio;
                    }
                } else {
                    pos[i][j] = vacio;
                }
            }
        }

        System.out.println("-------1-----------2-------");
        System.out.println("| " + pos[0][0] + " | " + pos[0][1] + " |");
        System.out.println("---------------------------");
        System.out.println("| " + pos[1][0] + " | " + pos[1][1] + " |");
        System.out.println("-------3-----------4-------");
    }

    public static boolean continuarJuego() {
        // Validar que hayan tanques vivos en el tablero
        int counter = 0;
        for (Tanques[] tanks : Tanques.tank) {
            for (Tanques tank : tanks) {
                if (tank != null) {
                    if (tank.vidaStatus()) {
                        counter++;
                    }
                }
            }
        }
        if (counter != 0) {
            return true;
        }

        return false;
    }

    // Menú del juego
    public static void menu() {
        System.out.println(br);
        System.out.println("\n    ********* MENU DE OPCIONES *********\n");
        System.out.println("1: Dispararle a un tanque");
        System.out.println("2: Activar bomba atómica");
        System.out.println("3: Activa el Tanque Mutante");
        System.out.println("4: Invoca la frase de la abuelita ");
        System.out.println("5: Ver la cantidad de disparos realizados en la partida.");
        System.out.println("6: Salir del juego");

        System.out.print("Su opción: ");
        int opt = in.nextInt();

        if (opt == 1) {

            while (true) {

                System.out.println(br);
                System.out.println("Elija el número del tanque al que le va a disparar (1, 2, 3 ó 4): ");
                int pos = in.nextInt();
                if (pos > 4 || pos < 1) {
                    System.out.println("Error de rango, elige (1, 2, 3 ó 4)");
                    continue;
                }
                if (Tanques.validarPos(pos) == false) {
                    System.out.println("En esta posición no hay tanques");

                } else {
                    break;
                }

            }

        } else if (opt == 2) {
            Tanques tankInstans1 = Tanques.tankAleatorio();
            tankInstans1.bomba();
        } else if (opt == 3) {

            Tanques tankInstans2 = Tanques.menorSalud();
            tankInstans2.mutar();
        } else if (opt == 4) {
            Tanques.fraseAleatoria();
        } else if (opt == 5) {
            Tanques.couterShots();
        } else if (opt == 6) {
            System.out.println("¡Hasta Pronto!");
            gameStatus = false;
        } else {
            System.out.println("Error: Número no valido.");
            gameStatus = false;

        }

    }

    public static void main(String[] args) {

        System.out.println(br);
        System.out.println("     **** BIENVENIDO A TANKS WAR**** ");
        System.out.println(br);
        // Generar cantidad aleatoria de tanques
        int cantidadTanks = (int) (Math.random() * 4 + 1);
        for (int i = 0; i < cantidadTanks; i++) {
            // Generar tipo aleatorio de tanques

            int tipoTanks = ran.nextInt(2) + 1;
            if (tipoTanks == 1) {
                new TanquesNormales();
            } else if (tipoTanks == 2) {
                new TanquesAliens();
            } else {
                System.out.println("Error");
            }

        }

        // Ciclo infinito donde se ejecuta el juego
        while (true) {
            if (continuarJuego() == false) {
                System.out.println("\n ¡Todos los tanques han muerto!\n");
                break;
            }
            try {
                System.out.println("Cargando...");
                Thread.sleep(2000);
                System.out.println("Completado");
                System.out.println(br);
            } catch (Exception e) {
            }
            if (gameStatus) {
                tablero();
                menu();
            } else {
                break;
            }

        }

    }

}