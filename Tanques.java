import java.util.Random;

public class Tanques {

    // Atributos de clase
    // Estilo de codificación: camelCase

    private int salud;
    static private int counter = 0;
    public static Tanques[][] tank = new Tanques[2][2];

    // Constructor

    public Tanques(int salud) {

        this.salud = salud;

        // Proceso para asignar un valor a cada poscisión del arreglo.
        boolean vacio = true;
        for (int i = 0; i < tank.length; i++) {
            for (int j = 0; j < tank[i].length; j++) {
                if (tank[i][j] == null) {
                    tank[i][j] = this;
                    vacio = false;
                    break;
                }
            }
            if (vacio == false) {
                break;
            }
        }
    }

    // Setters & Getters

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getTank() {
        return "TK-" + getSalud();
    }

    // Revisar que esté vivo
    public boolean vidaStatus() {
        return this.salud > 0;
    }

    // Acciones del juego

    public void bala() {
        this.setSalud(this.salud - 5);
        counter++;
    }

    public void bomba() {
        this.setSalud(0);
    }

    public void mutar() {
        this.setSalud(this.salud * 2);
    }

    // Metodo para retornar el tanque con menor salud
    public static Tanques menorSalud() {
        Tanques tankMenorSalud = tank[0][0];
        for (Tanques[] newTank1 : tank) {
            for (Tanques newTank2 : newTank1) {
                if (newTank2 != null) {
                    if (newTank2.getSalud() < tankMenorSalud.getSalud() && newTank2.vidaStatus()) {
                        tankMenorSalud = newTank2;
                    }
                }
            }
        }
        return tankMenorSalud;
    }

    // Metodo para retornar un arreglo con los tanuques puestos aleatoriamente
    public static Tanques tankAleatorio() {
        Random ran = new Random();
        Tanques newTank = Tanques.tank[ran.nextInt(2)][ran.nextInt(2)];
        if (newTank == null) {
            System.out.println("La bomba cayó en una posición vacía");
            return tankAleatorio();
        } else {
            System.out.println("La bomba mató a un tanque");

        }
        return newTank;
    }

    public static boolean validarPos(int pos) {

        switch (pos) {
            case 1:
                if (tank[0][0] != null) {
                    if (tank[0][0].vidaStatus()) {
                        tank[0][0].bala();
                        return true;
                    }
                }

            case 2:
                if (tank[0][1] != null) {
                    if (tank[0][1].vidaStatus()) {
                        tank[0][1].bala();
                        return true;
                    }
                }

            case 3:
                if (tank[1][0] != null) {
                    if (tank[1][0].vidaStatus()) {
                        tank[1][0].bala();
                        return true;
                    }
                }

            case 4:
                if (tank[1][1] != null) {
                    if (tank[1][1].vidaStatus()) {
                        tank[1][1].bala();
                        return true;
                    }
                }

            default:
                return false;
        }

    }

    public static void fraseAleatoria() {
        int num = (int) (Math.random() * 4 + 1);

        String frase = "";

        switch (num) {
            case 1:
                frase = "Jejejejeje, ¡toma rufián!";
                break;

            case 2:

                frase = "Mijito, el computador me dice que cierre la ventana pero cierro la de la piesa y sigue saliendo lo mismo";

                break;

            case 3:
                frase = "El que mal actua, mal le va, por eso tienes que morir ¡tanque!";
                break;

            case 4:

                frase = "¡Pásame la chancla yo mato a ese tanque con mis propias manos!";

                break;
        }
        System.out.println("______________________________________________________________________");
        System.out.println("Mi abuela al jugar diría: " + frase);
        System.out.println("______________________________________________________________________");
    }

    public static void couterShots() {
        System.out.println("______________________________________________________________________");
        System.out.println("Has disparado " + counter + " veces en esta partida.");
        System.out.println("______________________________________________________________________");
    }

    public static void setUserSalud(int userSalud) {
        Tanques tanks = Tanques.tankAleatorio();
        tanks.setSalud(userSalud);
    }

}
