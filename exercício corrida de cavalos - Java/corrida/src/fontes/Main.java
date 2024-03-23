//Ana Laura Angelieri 
//BP3038262

package fontes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à corrida de cavalos!");
        System.out.println("Durante a corrida, cada caractere representa um cavalo.");
        System.out.println();

        int numCavalos;
        // um do while para entrar mais que um cavalo, se não, não será uma corrida
        do {
            System.out.print("Digite o número total de cavalos: ");
            numCavalos = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            if (numCavalos <= 1) {
                System.out.println("O número total de cavalos deve ser maior que 1. Tente novamente.");
            }

            System.out.println();
        } while (numCavalos <= 1);

        String[] nomesCavalos = new String[numCavalos];
        String[] caracteresCavalos = new String[numCavalos]; // armazenar os caracteres para representar cada cavalo

        // for para digitar os nomes e caracteres para cada cavalo
        for (int i = 0; i < numCavalos; i++) {
            System.out.print("Digite o nome do cavalo " + (i + 1) + ": ");
            nomesCavalos[i] = scanner.nextLine();

            System.out.print("Digite o caractere para representar o cavalo " + nomesCavalos[i] + ": ");
            caracteresCavalos[i] = scanner.nextLine();

            System.out.println();
        }

        String[] apostadores = new String[numCavalos];
        // for para digitar os nomes dos apostadores respectivos de cada cavalo
        for (int i = 0; i < numCavalos; i++) {
            System.out.print("Digite o nome do apostador para o cavalo " + nomesCavalos[i] + ": ");
            apostadores[i] = scanner.nextLine();
        }

        scanner.close();

        // chama a classe corrida
        Corrida corrida = new Corrida(numCavalos, nomesCavalos, apostadores, caracteresCavalos);
        // inicia a corrida em si
        corrida.iniciarCorrida();
    }
}
