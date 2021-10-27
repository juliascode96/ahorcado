package ahorcado;

import java.util.Arrays;
import java.util.Scanner;

public class ahorcadoControl {

    public Ahorcado crearJuego() {
        Scanner read = new Scanner(System.in);
        Ahorcado ahorcado = new Ahorcado();
        System.out.println("Ingrese una palabra");
        String p = read.next();
        String[] palabra = new String[p.length()];
        for (int i = 0; i < p.length(); i++) {
            palabra[i] = p.substring(i, i + 1);
        }
        ahorcado.setPalabra(palabra);
        ahorcado.setCantidadLetras(p.length());
        ahorcado.setIntentos(6);
        return ahorcado;
    }

    Ahorcado ahorcado = crearJuego();

    public void longitud() {
        System.out.println(ahorcado.getPalabra().length);
    }

    public int buscar(String letra, String[] mostrar) {

        int cont = 0;
        for (int i = 0; i < ahorcado.getCantidadLetras(); i++) {
            if (letra.equalsIgnoreCase(ahorcado.getPalabra()[i])) {
                cont++;
                System.out.println("Se encontró la letra " + letra + " en la posición " + i);
                mostrar[i] = letra;
            }
        }

        if (cont > 0) {
            if (cont == 1) {
                System.out.println("Se encontró la letra " + letra + " " + cont + " vez");
            } else {
                System.out.println("Se encontró la letra " + letra + " " + cont + " veces");
            }

        } else {
            System.out.println("No se encontró la letra " + letra);
        }
        for (int j = 0; j < ahorcado.getCantidadLetras(); j++) {
            System.out.print(mostrar[j]);

        }
        System.out.println("");
        return cont;

    }

    public boolean encontradas(String letra) {
        boolean e;
        int cont = 0;
        for (int i = 0; i < ahorcado.getCantidadLetras(); i++) {
            if (letra.equalsIgnoreCase(ahorcado.getPalabra()[i])) {
                cont++;
            }

        }
        e = cont > 0;
        return e;
    }

    public void intentos() {
        System.out.println("Le quedan " + ahorcado.getIntentos() + " intentos");
    }

    public void dibujarMuñeco(int i) {
        switch (i) {
            case 5:
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___");
                break;
            case 4:
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |");
                System.out.println("___|___");
                break;
            case 3:
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |          /    ");
                System.out.println("___|___      /     ");
                break;
            case 2:
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |          / \\ ");
                System.out.println("___|___      /   \\");
                break;
            case 1:
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |          _| ");
                System.out.println("   |         / |   ");
                System.out.println("   |          / \\ ");
                System.out.println("___|___      /   \\");
                break;
            case 0:
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |          _|_");
                System.out.println("   |         / | \\");
                System.out.println("   |          / \\ ");
                System.out.println("___|___      /   \\");
                break;
            default:
                System.out.println("");

        }
    }

    public void juego() {
        Scanner read = new Scanner(System.in);
        String letra = "";
        int correctas = 0;
        int vueltas = 0;
        String[] mostrar = new String[ahorcado.getCantidadLetras()];
        Arrays.fill(mostrar, "_");
        System.out.println("");
        longitud();
        String[] ingresadas = new String[ahorcado.getIntentos()];
        Arrays.fill(ingresadas, " ");

        for (int i = 0; i < 50; i++) {
            System.out.println("*");
        }

        while (correctas != ahorcado.getCantidadLetras()) {
            System.out.println("Ingrese una letra");
            letra = read.next();
            buscar(letra, mostrar);
            System.out.println("");
            System.out.println("");

            if (encontradas(letra) == false) {
                ingresadas[vueltas] = letra;
                ahorcado.setIntentos(ahorcado.getIntentos() - 1);
                System.out.println("LETRAS INCORRECTAS INGRESADAS:");
                for (int i = 0; i < 6; i++) {
                    System.out.print(ingresadas[i] + " ");
                }
                System.out.println("");
                dibujarMuñeco(ahorcado.getIntentos());
                vueltas++;
                System.out.println("");
            } else {
                correctas = correctas + buscar(letra, mostrar);
                System.out.println("Letras encontradas: " + correctas);
                System.out.println("Faltan: " + (ahorcado.getCantidadLetras() - correctas));
                System.out.println("LETRAS INCORRECTAS INGRESADAS:");
                for (int i = 0; i < 6; i++) {
                    System.out.print(ingresadas[i] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
            intentos();

            if (ahorcado.getIntentos() == 0) {

                for (String palabra : ahorcado.getPalabra()) {
                    System.out.print("[" + palabra + "]");
                }
                System.out.println("");
                break;

            }

        }
    }

}

